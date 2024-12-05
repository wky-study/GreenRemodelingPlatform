package com.team.green.estimate.web;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.green.attach.dto.AttachDTO;
import com.team.green.attach.service.AttachService;
import com.team.green.common.vo.FileUploadVO;
import com.team.green.estimate.dto.AddressVO;
import com.team.green.estimate.dto.EstimateDTO;
import com.team.green.estimate.service.BuildingInfoService;
import com.team.green.estimate.service.EstimateService;
import com.team.green.estimate.service.KakaoAddressService;
import com.team.green.material.dto.MaterialDTO;
import com.team.green.material.service.MaterialService;
import com.team.green.member.dto.MemberDTO;
import com.team.green.member.service.MemberService;

@Controller
public class EstimateController {

	@Autowired
	EstimateService estSvc;

	@Autowired
	MaterialService matSvc;

	@Autowired
	AttachService attachService;

	@Autowired
	FileUploadVO fileUpload;

	@Autowired
	BuildingInfoService buildingInfoService;

	@Autowired
	KakaoAddressService kakaoAddressService;

	@Autowired
	MemberService memSvc;

	/*
	 * Estimate 첫 페이지
	 */

	@GetMapping("/estWrite")
	public String estWrite() {

		return "estimate/estWrite";
	}

	@RequestMapping("/est1")
	public String est1(@RequestParam("estId") int estId, HttpSession session) {
		System.out.println();
		System.out.println(estId);

		EstimateDTO estimate = estSvc.getEst(estId);

		System.out.println(estimate);
		session.removeAttribute("keyEst");
		session.setAttribute("keyEst", estimate);

		return "estimate/est1";
	}

	@PostMapping("/est2")
	public String est2(EstimateDTO estimate, Model model, String itemType, HttpSession session) {

		EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");
		System.out.println("세션 : " + est);

		MemberDTO member = (MemberDTO) session.getAttribute("memInfo");
		String memId = member.getMemId();
		int estId = 0;
		if (est != null) {
			estId = est.getEstId();
			estimate.setEstId(estId);
		}
		System.out.println();
		System.out.println(memId);

		estimate.setMemId(memId);
		System.out.println();
		System.out.println("들어온 estimate : " + estimate);

		// 기존에 같은 MEM_ID와 EST_ADDRESS를 가진 데이터가 있는지 체크
		int cnt = estSvc.countEstimateByCriteria(estimate);

		System.out.println(estimate);
		System.out.println(cnt);

		if (cnt == 0) {
			// 기존 데이터가 없으면 새로운 견적서 저장
			estId = estSvc.getEstId();
			estimate.setEstId(estId);
			estSvc.insertEstimate(estimate);
		} else {
			// 기존 데이터가 있으면 업데이트
			estSvc.updateEstimate(estimate);
		}

//		System.out.println(itemType);

		session.removeAttribute("keyEst");
		session.setAttribute("keyEst", estimate);

		List<MemberDTO> comList = memSvc.getComList();
		model.addAttribute("keyComList", comList);

//		List<MaterialDTO> materialList = matSvc.materialList(itemType);
//		model.addAttribute("keyMatList", materialList);

		return "estimate/est2"; // 자재 선택으로 이동
	}

	@GetMapping("/est2")
	public String est2Redirect(HttpSession session, String itemType, Model model) {
		// 세션에서 estimate 정보 가져오기
		EstimateDTO estimate = (EstimateDTO) session.getAttribute("keyEst");

		// itemType 값이 null이 아니면 해당 값에 맞는 자재 목록을 불러옴
		if (itemType != null) {
//			List<MaterialDTO> materialList = matSvc.materialList(itemType);
			List<MemberDTO> comList = memSvc.getComList();
//			model.addAttribute("keyMatList", materialList);
			model.addAttribute("keyComList", comList);
		}

		// 모델에 기존 estimate 정보도 담기
		model.addAttribute("keyEst", estimate);

		return "estimate/est2"; // 자재 선택 페이지로 이동
	}

	@RequestMapping("/est3")
	public String est3(String memName, HttpSession session, Model model) {

		System.out.println("선택된 시공사명: " + memName);
		String comId = memSvc.getComId(memName);
		System.out.println("comId : " + comId);
		EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");
		// 시공사명도 저장 해야함
		est.setComId(comId);
		System.out.println(est);
		estSvc.updateComId(est);

		List<AttachDTO> atchList = attachService.getEstAttachList(est.getEstId());

		System.out.println();
		System.out.println(atchList);

		model.addAttribute("atchList", atchList);

		return "estimate/est3";
	}

	// 임시저장
	@PostMapping("/saveEstimate")
	@ResponseBody
	public ResponseEntity<String> saveEstimate(EstimateDTO estimate, HttpSession session, MultipartFile[] estFile) {

		try {
			EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");
			estimate.setEstId(est.getEstId());

			// 세션에 담긴 회원 정보 확인
			MemberDTO member = (MemberDTO) session.getAttribute("memInfo");
			String memId = member.getMemId();

			estimate.setMemId(memId);

			int estId = estimate.getEstId();

			System.out.println("파일" + estFile.length);

			// 파일 처리 (다른 테이블에 저장)
			if (estFile != null && estFile.length > 0 && !estFile[0].isEmpty()) {
				List<AttachDTO> attachList = fileUpload.saveFiles(estFile);
				if (!attachList.isEmpty()) {
					for (AttachDTO attach : attachList) {
						attach.setEstId(estId);
						attachService.insertEstAttach(attach);
					}
				}
			}
			

			estSvc.updateEst(estimate);

			estimate = estSvc.getEst(estId);

			session.removeAttribute("keyEst");
			session.setAttribute("keyEst", estimate);

			return ResponseEntity.ok().header("Content-Type", "text/plain; charset=UTF-8") // 인코딩 명시
					.body("요청 완료"); // 경로를 포함
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("Content-Type", "text/plain; charset=UTF-8") // 인코딩 명시
					.body("요청에 실패했습니다.");
		}
	}

	// 파일 삭제 요청 처리
	@PostMapping("/estFileDel")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteFile(@RequestBody Map<String, String> params) {
		String atchFileName = params.get("atchFileName");

		// 파일 삭제 서비스 호출
		boolean isDeleted = attachService.estFileDel(atchFileName);

		Map<String, Object> response = new HashMap<>();
		if (isDeleted) {
			response.put("success", true);
			response.put("message", "파일이 삭제되었습니다.");
		} else {
			response.put("success", false);
			response.put("message", "파일 삭제에 실패했습니다.");
		}

		return ResponseEntity.ok(response); // JSON 형태로 응답 반환
	}

	@GetMapping("/estSubmitList")
	public String estSubmitList(HttpSession session, Model model) {

		MemberDTO member = (MemberDTO) session.getAttribute("memInfo");

		List<EstimateDTO> estList = null;

		if (member == null) {
			return "redirect:/loginView";
		} else {
			String memId = member.getMemId();
			String memType = member.getMemType();

			System.out.println(memType);

			if (memType.equals("5") || memType.equals("0")) {
				estList = estSvc.getComSubList(member);
				System.out.println("여기로옴");
			} else {
				estList = estSvc.getMemSubList(memId);
			}

			System.out.println(estList);

			model.addAttribute("keyEstList", estList);

			return "estimate/estSubmitList";
		}
	}

	@GetMapping("/est4")
	public String est4(@RequestParam("estId") int estId, HttpSession session, Model model) {

		MemberDTO member = (MemberDTO) session.getAttribute("memInfo");
		String memId = member.getMemId();

		// 우선 제출한 est를 가져옴
		EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");
		System.out.println(est); // [estId=3, memId=qwer, estAddress=대전 서구 청사로 5, dongNm=101, hoNm=101,
									// estSdate=2025-02-14, estInteriorDesc=아무거나, estSubmit=Y]

		String sigunguCd = est.getSigunguCd();
		String bjdongCd = est.getBjdongCd();

		// 주소를 기반으로 카카오 API 호출
		String address = est.getEstAddress(); // 예: "대전 서구 청사로 5"

		// 카카오 주소 서비스 호출하여 번지와 지번 정보를 받아옴
		AddressVO addressVO = kakaoAddressService.getFormattedAddress(address);
		System.out.println(addressVO);
		String bun = addressVO.getBunji();
		String ji = addressVO.getJibun();

		String dongNm = est.getDongNm();
		String hoNm = est.getHoNm();
		String estArea = "";
		// 국토교통부 API 호출
		if (dongNm == null || dongNm.isEmpty()) {
			estArea = buildingInfoService.getBuildingArea(sigunguCd, bjdongCd, bun, ji, "", ""); // API 호출
		} else {
			estArea = buildingInfoService.getBuildingArea(sigunguCd, bjdongCd, bun, ji, dongNm + "동", hoNm + "호"); // API
																													// 호출
		}
		System.out.println(estArea);
		est.setEstArea(estArea);
		
		try {
		    // String -> double 변환
		    double area = Double.parseDouble(estArea); // "80.32" -> 80.32

		    // 면적에 따른 추가 시공 기간 계산
		    int additionalDays = estSvc.calculateConstructionPeriod(area);

		    // 시작 날짜 가져오기
		    String startDate = est.getEstSdate(); // 예: "2025-02-14"
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = sdf.parse(startDate);

		    // 추가 기간을 더한 날짜 계산
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.add(Calendar.DATE, additionalDays);

		    // 계산된 종료 날짜를 포맷팅
		    String endDate = sdf.format(calendar.getTime());
		    est.setEstEdate(endDate); // 종료일 저장 필드로 설정			
			
		}catch (Exception e) {}

		System.out.println("DB 저장전 : " + est);
		// 제출하기 누르면 오는 페이지 제출된 프로젝트 리스트
		
		estSvc.estSubmit(est);

		List<EstimateDTO> estList = estSvc.getMemSubList(memId);
		model.addAttribute("keyEstList", estList);

		return "estimate/estSubmitList";
	}

	@GetMapping("/estListView")
	public String estListView(Model model, HttpSession session) {

		// 작성중인 임시견적서 목록
		MemberDTO member = (MemberDTO) session.getAttribute("memInfo");
		if (member == null) {
			return "redirect:/loginView";
		} else {
			String memId = member.getMemId();

			List<EstimateDTO> estList = estSvc.getMemEstList(memId);
			model.addAttribute("keyEstList", estList);

			return "estimate/estListView";
		}

	}

	@RequestMapping("/estDetailView")
	public String estDetailView(@RequestParam("estId") int estId, HttpSession session, Model model) {

		System.out.println(estId);

		EstimateDTO est = estSvc.getEst(estId);
		System.out.println("불러온 est: " + est);
		String estArea = est.getEstArea();
		String estType = est.getEstType();

		// http://192.168.0.187:5000/material?area=50&type=1
		String flaskUrl = "http://192.168.0.47:5000/material?area=" + estArea + "&type=" + estType;

		System.out.println("Flask URL: " + flaskUrl);

		// RestTemplate 생성
		RestTemplate restTemplate = new RestTemplate();

		// Flask 서버에 요청 보내기
		ResponseEntity<String> response = restTemplate.getForEntity(flaskUrl, String.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			// Flask 서버 응답을 JSON 파싱
			String responseData = response.getBody();
			System.out.println("Flask에서 온 응답: " + responseData);

			try {
				System.out.println(responseData);
				// JSON 데이터를 Map<String, Double>으로 변환
				ObjectMapper objectMapper = new ObjectMapper();
				Map<String, Double> dataMap = objectMapper.readValue(responseData,
						new TypeReference<Map<String, Double>>() {
						});

				// DB에서 데이터를 불러오는 서비스 호출 (각 itemId로 조회)
				List<MaterialDTO> materialList = new ArrayList<>();

				long totalAmount = 0;
				
				for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
					String itemId = entry.getKey(); // itemId (key)
				    // itemQuantity를 int로 받아서 사용
					long itemQuantity = entry.getValue().longValue(); // Double -> long로 변환

					// DB에서 itemId에 맞는 정보 조회 (예: 서비스 호출)
					MaterialDTO material = matSvc.getMaterialByItemId(itemId); // DB 조회 메서드
					
					if (material != null) {
						// DB에서 조회한 데이터와 itemQuantity를 MaterialDTO에 설정
						material.setItemQuantity(itemQuantity);
						
				        // itemPrice가 String 타입이므로 이를 int로 변환
				        int itemPrice = Integer.parseInt(material.getItemPrice());  // String -> int 변환

				        // itemQuantity는 이미 int로 변환했으므로 곱셈을 바로 진행
				        long itemTotalPrice = itemPrice * itemQuantity; // itemQuantity는 int

				        // 총 금액에 합산
				        totalAmount += itemTotalPrice;						
						
						// 조회된 DTO를 리스트에 추가
						materialList.add(material);
						
					}
				}
				
				Long constructionCost = totalAmount * 20 / 100;  // 시공비 20% (Long 타입으로 계산)
				Long vat = (totalAmount + constructionCost) * 10 / 100;  // 부가세 10% (자재 가격 + 시공비에 대해 계산)
				Long finalAmount = totalAmount + constructionCost + vat;  // 최종 금액 (자재 가격 + 시공비 + 부가세)
				
				// 금액 포맷팅 (3자리마다 쉼표 추가)
				DecimalFormat df = new DecimalFormat("#,###");
				String formattedTotalAmount = df.format(totalAmount);
				String formattedConstructionCost = df.format(constructionCost);
				String formattedVat = df.format(vat);
				String formattedFinalAmount = df.format(finalAmount);
				
				model.addAttribute("formattedTotalAmount", formattedTotalAmount);	// 자재비 총합
				model.addAttribute("formattedConstructionCost", formattedConstructionCost);	// 시공비
				model.addAttribute("formattedVat", formattedVat);	// 부가세
				model.addAttribute("formattedFinalAmount", formattedFinalAmount); // 최종 금액
				
				String memId = est.getMemId();
				MemberDTO member = memSvc.getMemInfo(memId);
				
				model.addAttribute("keyMem", member);

				// 모델에 리스트 추가
				model.addAttribute("materialList", materialList);
				
				session.removeAttribute("keyEst");
				session.setAttribute("keyEst", est);

			} catch (Exception e) {
				System.out.println("JSON 파싱 중 오류 발생: " + e.getMessage());
				e.printStackTrace();
			}
		}

		return "estimate/estDetailView";
	}

}
