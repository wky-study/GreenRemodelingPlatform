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
	 * Estimate ù ������
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
		System.out.println("���� : " + est);

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
		System.out.println("���� estimate : " + estimate);

		// ������ ���� MEM_ID�� EST_ADDRESS�� ���� �����Ͱ� �ִ��� üũ
		int cnt = estSvc.countEstimateByCriteria(estimate);

		System.out.println(estimate);
		System.out.println(cnt);

		if (cnt == 0) {
			// ���� �����Ͱ� ������ ���ο� ������ ����
			estId = estSvc.getEstId();
			estimate.setEstId(estId);
			estSvc.insertEstimate(estimate);
		} else {
			// ���� �����Ͱ� ������ ������Ʈ
			estSvc.updateEstimate(estimate);
		}

//		System.out.println(itemType);

		session.removeAttribute("keyEst");
		session.setAttribute("keyEst", estimate);

		List<MemberDTO> comList = memSvc.getComList();
		model.addAttribute("keyComList", comList);

//		List<MaterialDTO> materialList = matSvc.materialList(itemType);
//		model.addAttribute("keyMatList", materialList);

		return "estimate/est2"; // ���� �������� �̵�
	}

	@GetMapping("/est2")
	public String est2Redirect(HttpSession session, String itemType, Model model) {
		// ���ǿ��� estimate ���� ��������
		EstimateDTO estimate = (EstimateDTO) session.getAttribute("keyEst");

		// itemType ���� null�� �ƴϸ� �ش� ���� �´� ���� ����� �ҷ���
		if (itemType != null) {
//			List<MaterialDTO> materialList = matSvc.materialList(itemType);
			List<MemberDTO> comList = memSvc.getComList();
//			model.addAttribute("keyMatList", materialList);
			model.addAttribute("keyComList", comList);
		}

		// �𵨿� ���� estimate ������ ���
		model.addAttribute("keyEst", estimate);

		return "estimate/est2"; // ���� ���� �������� �̵�
	}

	@RequestMapping("/est3")
	public String est3(String memName, HttpSession session, Model model) {

		System.out.println("���õ� �ð����: " + memName);
		String comId = memSvc.getComId(memName);
		System.out.println("comId : " + comId);
		EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");
		// �ð���� ���� �ؾ���
		est.setComId(comId);
		System.out.println(est);
		estSvc.updateComId(est);

		List<AttachDTO> atchList = attachService.getEstAttachList(est.getEstId());

		System.out.println();
		System.out.println(atchList);

		model.addAttribute("atchList", atchList);

		return "estimate/est3";
	}

	// �ӽ�����
	@PostMapping("/saveEstimate")
	@ResponseBody
	public ResponseEntity<String> saveEstimate(EstimateDTO estimate, HttpSession session, MultipartFile[] estFile) {

		try {
			EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");
			estimate.setEstId(est.getEstId());

			// ���ǿ� ��� ȸ�� ���� Ȯ��
			MemberDTO member = (MemberDTO) session.getAttribute("memInfo");
			String memId = member.getMemId();

			estimate.setMemId(memId);

			int estId = estimate.getEstId();

			System.out.println("����" + estFile.length);

			// ���� ó�� (�ٸ� ���̺� ����)
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

			return ResponseEntity.ok().header("Content-Type", "text/plain; charset=UTF-8") // ���ڵ� ���
					.body("��û �Ϸ�"); // ��θ� ����
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("Content-Type", "text/plain; charset=UTF-8") // ���ڵ� ���
					.body("��û�� �����߽��ϴ�.");
		}
	}

	// ���� ���� ��û ó��
	@PostMapping("/estFileDel")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteFile(@RequestBody Map<String, String> params) {
		String atchFileName = params.get("atchFileName");

		// ���� ���� ���� ȣ��
		boolean isDeleted = attachService.estFileDel(atchFileName);

		Map<String, Object> response = new HashMap<>();
		if (isDeleted) {
			response.put("success", true);
			response.put("message", "������ �����Ǿ����ϴ�.");
		} else {
			response.put("success", false);
			response.put("message", "���� ������ �����߽��ϴ�.");
		}

		return ResponseEntity.ok(response); // JSON ���·� ���� ��ȯ
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
				System.out.println("����ο�");
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

		// �켱 ������ est�� ������
		EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");
		System.out.println(est); // [estId=3, memId=qwer, estAddress=���� ���� û��� 5, dongNm=101, hoNm=101,
									// estSdate=2025-02-14, estInteriorDesc=�ƹ��ų�, estSubmit=Y]

		String sigunguCd = est.getSigunguCd();
		String bjdongCd = est.getBjdongCd();

		// �ּҸ� ������� īī�� API ȣ��
		String address = est.getEstAddress(); // ��: "���� ���� û��� 5"

		// īī�� �ּ� ���� ȣ���Ͽ� ������ ���� ������ �޾ƿ�
		AddressVO addressVO = kakaoAddressService.getFormattedAddress(address);
		System.out.println(addressVO);
		String bun = addressVO.getBunji();
		String ji = addressVO.getJibun();

		String dongNm = est.getDongNm();
		String hoNm = est.getHoNm();
		String estArea = "";
		// ���䱳��� API ȣ��
		if (dongNm == null || dongNm.isEmpty()) {
			estArea = buildingInfoService.getBuildingArea(sigunguCd, bjdongCd, bun, ji, "", ""); // API ȣ��
		} else {
			estArea = buildingInfoService.getBuildingArea(sigunguCd, bjdongCd, bun, ji, dongNm + "��", hoNm + "ȣ"); // API
																													// ȣ��
		}
		System.out.println(estArea);
		est.setEstArea(estArea);
		
		try {
		    // String -> double ��ȯ
		    double area = Double.parseDouble(estArea); // "80.32" -> 80.32

		    // ������ ���� �߰� �ð� �Ⱓ ���
		    int additionalDays = estSvc.calculateConstructionPeriod(area);

		    // ���� ��¥ ��������
		    String startDate = est.getEstSdate(); // ��: "2025-02-14"
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = sdf.parse(startDate);

		    // �߰� �Ⱓ�� ���� ��¥ ���
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.add(Calendar.DATE, additionalDays);

		    // ���� ���� ��¥�� ������
		    String endDate = sdf.format(calendar.getTime());
		    est.setEstEdate(endDate); // ������ ���� �ʵ�� ����			
			
		}catch (Exception e) {}

		System.out.println("DB ������ : " + est);
		// �����ϱ� ������ ���� ������ ����� ������Ʈ ����Ʈ
		
		estSvc.estSubmit(est);

		List<EstimateDTO> estList = estSvc.getMemSubList(memId);
		model.addAttribute("keyEstList", estList);

		return "estimate/estSubmitList";
	}

	@GetMapping("/estListView")
	public String estListView(Model model, HttpSession session) {

		// �ۼ����� �ӽð����� ���
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
		System.out.println("�ҷ��� est: " + est);
		String estArea = est.getEstArea();
		String estType = est.getEstType();

		// http://192.168.0.187:5000/material?area=50&type=1
		String flaskUrl = "http://192.168.0.47:5000/material?area=" + estArea + "&type=" + estType;

		System.out.println("Flask URL: " + flaskUrl);

		// RestTemplate ����
		RestTemplate restTemplate = new RestTemplate();

		// Flask ������ ��û ������
		ResponseEntity<String> response = restTemplate.getForEntity(flaskUrl, String.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			// Flask ���� ������ JSON �Ľ�
			String responseData = response.getBody();
			System.out.println("Flask���� �� ����: " + responseData);

			try {
				System.out.println(responseData);
				// JSON �����͸� Map<String, Double>���� ��ȯ
				ObjectMapper objectMapper = new ObjectMapper();
				Map<String, Double> dataMap = objectMapper.readValue(responseData,
						new TypeReference<Map<String, Double>>() {
						});

				// DB���� �����͸� �ҷ����� ���� ȣ�� (�� itemId�� ��ȸ)
				List<MaterialDTO> materialList = new ArrayList<>();

				long totalAmount = 0;
				
				for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
					String itemId = entry.getKey(); // itemId (key)
				    // itemQuantity�� int�� �޾Ƽ� ���
					long itemQuantity = entry.getValue().longValue(); // Double -> long�� ��ȯ

					// DB���� itemId�� �´� ���� ��ȸ (��: ���� ȣ��)
					MaterialDTO material = matSvc.getMaterialByItemId(itemId); // DB ��ȸ �޼���
					
					if (material != null) {
						// DB���� ��ȸ�� �����Ϳ� itemQuantity�� MaterialDTO�� ����
						material.setItemQuantity(itemQuantity);
						
				        // itemPrice�� String Ÿ���̹Ƿ� �̸� int�� ��ȯ
				        int itemPrice = Integer.parseInt(material.getItemPrice());  // String -> int ��ȯ

				        // itemQuantity�� �̹� int�� ��ȯ�����Ƿ� ������ �ٷ� ����
				        long itemTotalPrice = itemPrice * itemQuantity; // itemQuantity�� int

				        // �� �ݾ׿� �ջ�
				        totalAmount += itemTotalPrice;						
						
						// ��ȸ�� DTO�� ����Ʈ�� �߰�
						materialList.add(material);
						
					}
				}
				
				Long constructionCost = totalAmount * 20 / 100;  // �ð��� 20% (Long Ÿ������ ���)
				Long vat = (totalAmount + constructionCost) * 10 / 100;  // �ΰ��� 10% (���� ���� + �ð��� ���� ���)
				Long finalAmount = totalAmount + constructionCost + vat;  // ���� �ݾ� (���� ���� + �ð��� + �ΰ���)
				
				// �ݾ� ������ (3�ڸ����� ��ǥ �߰�)
				DecimalFormat df = new DecimalFormat("#,###");
				String formattedTotalAmount = df.format(totalAmount);
				String formattedConstructionCost = df.format(constructionCost);
				String formattedVat = df.format(vat);
				String formattedFinalAmount = df.format(finalAmount);
				
				model.addAttribute("formattedTotalAmount", formattedTotalAmount);	// ����� ����
				model.addAttribute("formattedConstructionCost", formattedConstructionCost);	// �ð���
				model.addAttribute("formattedVat", formattedVat);	// �ΰ���
				model.addAttribute("formattedFinalAmount", formattedFinalAmount); // ���� �ݾ�
				
				String memId = est.getMemId();
				MemberDTO member = memSvc.getMemInfo(memId);
				
				model.addAttribute("keyMem", member);

				// �𵨿� ����Ʈ �߰�
				model.addAttribute("materialList", materialList);
				
				session.removeAttribute("keyEst");
				session.setAttribute("keyEst", est);

			} catch (Exception e) {
				System.out.println("JSON �Ľ� �� ���� �߻�: " + e.getMessage());
				e.printStackTrace();
			}
		}

		return "estimate/estDetailView";
	}

}
