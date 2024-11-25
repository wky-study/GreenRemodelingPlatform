package com.team.green.compage.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.green.common.exception.BizNotFoundException;
import com.team.green.compage.dto.CompageDTO;
import com.team.green.compage.service.CompageService;
import com.team.green.material.SearchM;
import com.team.green.member.dto.MemberDTO;
import com.team.green.reply.dto.ReplyDTO;
import com.team.green.reply.service.ReplyService;

@Controller
public class CompageController {

	@Value("#{util['file.attach.path']}")
	String attachPath;
	
	@Autowired
	CompageService cpgSvc;
	
	@Autowired
	ReplyService replyService;

	// ������ ������
	@RequestMapping("/compageView")
	public String compageView(Model model, SearchM search) {
		
		int cpCnt = cpgSvc.getCpCount(search);
		
		System.out.println(cpCnt);
		
		search.setCpCount(cpCnt);
		search.cpgSetting();
		
		List<CompageDTO> cp = cpgSvc.getCpList(search);
		
		System.out.println(cp);
		System.out.println(search);
		
		model.addAttribute("keyCp", cp);
		model.addAttribute("keySearch", search);
	
		return "compage/compageView";
	}
	
	// ���� �Խñ� �߰��� ��������
	@ResponseBody
	@PostMapping("/loadMoreDOcomPage")
	public List<CompageDTO> loadMoreDO(SearchM search) {
		
		System.out.println(search);
		
		search.setting();
		
		List<CompageDTO> review = cpgSvc.getCpList(search);
		
		return review;
	}
	
	@RequestMapping("/compageWriteView")
	public String compageWriteView(HttpSession session) {
		
		System.out.println(session.getAttribute("memInfo"));
		
		if(session.getAttribute("memInfo") == null) {
			return "redirect:/loginView";
		}
		
		return "compage/compageWriteView";
	}
	
	// ���� �� �ۼ� Ŭ��
	@PostMapping("/compageWriteDo")
	public String reviewWriteDo(CompageDTO cp, String imgFileName, HttpSession session) {
		
		MemberDTO memInfo= (MemberDTO)session.getAttribute("memInfo");
		
		cp.setMemId(memInfo.getMemId());
		cp.setMemName(memInfo.getMemName());
		cp.setCpPath(imgFileName);
		System.out.println(cp);
		
		cpgSvc.writeCp(cp);

		return "redirect:compageView";
	}
	
	
	// ���� �� �� ������
	@RequestMapping("/compageDetailView")
	public String compageDetailView(ReplyDTO reply, Model model, int no) {
		
		System.out.println("Ŭ���� �Խñ� ��ȣ" + no);
		
		reply.setReviewNo(no);
		
		System.out.println(reply);
		
		// ��ȸ�� ��� �߰� �Ұ�
		cpgSvc.cpCountUp(no);
		
		System.out.println("��ȸ�� ��");
		
		CompageDTO cp = null;
		try {
			cp = cpgSvc.getCp(no);
			
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			// ���� �߻� �� ���� �����ڵ�� �����޽��� Ȯ��
			String errCode = e.getErrCode();
			String errMsg = e.getMessage();
			
			// ������������ �����޽����� �����ְ��� �Ѵٸ� �𵨿� �߰�
			model.addAttribute("errMsg", errMsg);
			
			// ������������ ������(�ȸ���)
			return "error/errPage";
			
		}
		
		System.out.println(cp);
		
		model.addAttribute("keyCp", cp);
		
		// ��� ��� ��������
		List<ReplyDTO> replyList = replyService.getReplyList(reply);
		model.addAttribute("keyReplyList",replyList);	
		
		
		// �Խñ� ��� �� ��������
		int replyCount = replyService.replyCount(no);
		model.addAttribute("keyReplyCount", replyCount);
		
		
		return "compage/compageDetailView";
	}
	
	// ����Խ��� �� ���� ȭ��
	@PostMapping("/compageEditView")
	public String compageEditView(int no, Model model) {
		
		try {
			CompageDTO cp = cpgSvc.getCp(no);
			model.addAttribute("keyCp", cp);
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			return "errPage";
		}
		
		return "compage/compageEditView";
	}
	
	// �����Խ��� �� ���� ���
	@PostMapping("/compageEditDo")
	public String reviewEditDo(CompageDTO cp) {
		
		System.out.println(cp);
		
		cpgSvc.updateCp(cp);
		
		return "redirect:/compageDetailView?no=" + cp.getCpNo();	
	}
	
	// �����Խ��� �� ����
	@PostMapping("/compageDeleteDo")
	public String compageDeleteDo(int no) {
		
		cpgSvc.deleteCp(no);
		
		return "redirect:/compageView";	
	}
}
