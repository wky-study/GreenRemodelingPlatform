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
import com.team.green.common.vo.SearchVO;
import com.team.green.compage.dto.CompageDTO;
import com.team.green.compage.service.CompageService;
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
	public String reviewView(Model model, SearchVO search) {
		
		int reviewCount = cpgSvc.getReviewCount(search);
		
		System.out.println(reviewCount);
		
		search.setReviewCount(reviewCount);
		search.reviewSetting();
		
		List<CompageDTO> review = cpgSvc.getReviewList(search);
		
		System.out.println(review);
		System.out.println(search);
		
		model.addAttribute("keyReview", review);
		model.addAttribute("keySearch", search);

		
		return "compage/compageView";
	}
	
	// ���� �Խñ� �߰��� ��������
	@ResponseBody
	@PostMapping("/loadMoreDOcomPage")
	public List<CompageDTO> loadMoreDO(SearchVO search) {
		
		System.out.println(search);
		
		search.setting();
		
		List<CompageDTO> review = cpgSvc.getReviewList(search);
		
		return review;
	}
	
	@RequestMapping("/compageWriteView")
	public String reviewWriteView(HttpSession session) {
		
		System.out.println(session.getAttribute("memInfo"));
		
		if(session.getAttribute("memInfo") == null) {
			return "redirect:/loginView";
		}
		
		return "compage/compageWriteView";
	}
	
	// ���� �� �ۼ� Ŭ��
	@PostMapping("/compageWriteDo")
	public String reviewWriteDo(CompageDTO review, String imgFileName, HttpSession session) {
		
		MemberDTO login= (MemberDTO)session.getAttribute("memInfo");
		
		review.setMemId(login.getMemId());
		review.setMemName(login.getMemName());
		review.setReviewPath(imgFileName);
		System.out.println(review);
		
		cpgSvc.writeReview(review);

		
		return "redirect:compageView";
	}
	
	
	// ���� �� �� ������
	@RequestMapping("/compageDetailView")
	public String reviewDetailView(ReplyDTO reply, Model model, int no) {
		
		System.out.println("Ŭ���� �Խñ� ��ȣ" + no);
		
		reply.setReviewNo(no);
		
		System.out.println(reply);
		
		// ��ȸ�� ��� �߰� �Ұ�
		cpgSvc.reviewCountUp(no);
		
		System.out.println("��ȸ�� ��");
		
		CompageDTO review = null;
		try {
			review = cpgSvc.getReview(no);
			
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
		
		System.out.println(review);
		
		model.addAttribute("keyReview", review);
		
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
	public String reviewEditView(int no, Model model) {
		
		try {
			CompageDTO review = cpgSvc.getReview(no);
			model.addAttribute("keyReview", review);
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			return "errPage";
		}
		
		return "compage/compageEditView";
	}
	
	// �����Խ��� �� ���� ���
	@PostMapping("/compageEditDo")
	public String reviewEditDo(CompageDTO review) {
		
		System.out.println(review);
		
		cpgSvc.updateReview(review);
		
		return "redirect:/compageDetailView?no=" + review.getReviewNo();	
	}
	
	// �����Խ��� �� ����
	@PostMapping("/compageDeleteDo")
	public String reviewDeleteDo(int no) {
		
		cpgSvc.deleteReview(no);
		
		return "redirect:/compageView";	
	}
}
