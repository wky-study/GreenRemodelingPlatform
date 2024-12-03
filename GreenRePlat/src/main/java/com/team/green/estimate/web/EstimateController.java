package com.team.green.estimate.web;

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
import org.springframework.web.multipart.MultipartFile;

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

		MemberDTO member = (MemberDTO) session.getAttribute("memInfo");
		String memId = member.getMemId();

		System.out.println();
		System.out.println(memId);

		int estId = estSvc.getEstId();
		estimate.setEstId(estId);

		estimate.setMemId(memId);
		System.out.println();
		System.out.println("���� estimate : " + estimate);

		session.removeAttribute("keyEst");
		session.setAttribute("keyEst", estimate);

		// ������ ���� MEM_ID�� EST_ADDRESS�� ���� �����Ͱ� �ִ��� üũ
		int cnt = estSvc.countEstimateByCriteria(estimate);

		System.out.println(estimate);
		System.out.println(cnt);

		if (cnt == 0) {
			// ���� �����Ͱ� ������ ���ο� ������ ����
			estSvc.insertEstimate(estimate);
		} else {
			// ���� �����Ͱ� ������ ������Ʈ
			estSvc.updateEstimate(estimate);
		}

		System.out.println(itemType);

		List<MaterialDTO> materialList = matSvc.materialList(itemType);
		List<MaterialDTO> typeList = matSvc.typeList();
		model.addAttribute("keyMatList", materialList);
		model.addAttribute("keyTypeList", typeList);

		return "estimate/est2"; // ���� �������� �̵�
	}

	@GetMapping("/est2")
	public String est2Redirect(HttpSession session, String itemType, Model model) {
		// ���ǿ��� estimate ���� ��������
		EstimateDTO estimate = (EstimateDTO) session.getAttribute("keyEst");

		// itemType ���� null�� �ƴϸ� �ش� ���� �´� ���� ����� �ҷ���
		if (itemType != null) {
			List<MaterialDTO> materialList = matSvc.materialList(itemType);
			List<MaterialDTO> typeList = matSvc.typeList();

			model.addAttribute("keyMatList", materialList);
			model.addAttribute("keyTypeList", typeList);
		}

		// �𵨿� ���� estimate ������ ���
		model.addAttribute("keyEst", estimate);

		return "estimate/est2"; // ���� ���� �������� �̵�
	}

	@RequestMapping("/est3")
	public String est3(HttpSession session, Model model) {

		EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");

		System.out.println(est);

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

			System.out.println();
			System.out.println(estimate);

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
					.body("�ӽ� ���� �Ϸ�"); // ��θ� ����
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("Content-Type", "text/plain; charset=UTF-8") // ���ڵ� ���
					.body("�ӽ� ���� ����");
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
			// 0 = ������
			// 1 = �Ϲ�
			// 2 = ���
			String memType = member.getMemType();

			System.out.println(memType);
			
			if(memType.equals("5") || memType.equals("0")) {
				estList = estSvc.getComSubList(member);
				System.out.println("����ο�");
			}else {
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
	public String estDetailView(@RequestParam("estId") int estId, HttpSession session) {

		// ȭ�� ��������

		System.out.println();
		System.out.println(estId);

		EstimateDTO estimate = estSvc.getEst(estId);

		System.out.println(estimate);
		session.removeAttribute("keyEst");
		session.setAttribute("keyEst", estimate);

		return "estimate/estDetailView";
	}

}
