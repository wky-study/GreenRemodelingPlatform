package com.team.green.notice.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.green.common.exception.BizNotFoundException;
import com.team.green.notice.dto.NoticeDTO;
import com.team.green.common.vo.SearchVO;
import com.team.green.member.dto.MemberDTO;
import com.team.green.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("/noticeView")
	public String noticeView(Model model, SearchVO search, HttpSession session) {
	    int noticeCount = noticeService.getNoticeCount(search);
	    System.out.println(noticeCount);
	    
	    search.setNoticeCount(noticeCount);
	    search.noticeSetting();
	    
	    List<NoticeDTO> notice = noticeService.getNoticeList(search);
	    System.out.println(notice);
	    System.out.println(search);
	    
	    model.addAttribute("keynotice", notice);
	    model.addAttribute("keySearch", search);

	    // ���ǿ� �α��ε� ����� ������ �ִ� ��� ID�� �𵨿� �߰�
	    MemberDTO login = (MemberDTO) session.getAttribute("login");
	    if (login != null) {
	        model.addAttribute("loggedInUserId", login.getMemId());
	    }

	    return "notice/noticeView";
	}
	
	@RequestMapping("/noticeDeatilView")
	public String noticeDetailView(int no, Model model) {
		System.out.println("Ŭ���� �Խñ� ��ȣ" + no);
		
		// ��ȸ�� ��� �߰� �Ұ�
		noticeService.noticeCountUp(no);
		
		System.out.println("��ȸ�� ��");
		
		NoticeDTO notice = null;
		try {
			notice = noticeService.getNotice(no);
			
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			// ���� �߻� �� ���� �����ڵ�� �����޽��� Ȯ��
			String errCode = e.getErrCode();
			String errMsg = e.getMessage();
			
			// ������������ �����޽����� �����ְ��� �Ѵٸ� �𵨿� �߰�
			model.addAttribute("errMsg", errMsg);
			
			// ������������ ������(���������� �ȸ���)
			return "error/errPage";
			
		}
		
		System.out.println(notice);
		
		model.addAttribute("keynotice", notice);
		
//		// ��� ��� ��������
//		List<ReplyDTO> replyList = replyService.getReplyList(no);
//		model.addAttribute("keyReplyList",replyList);	
//		
//		
//		// �Խñ� ��� �� ��������
//		int replyCount = replyService.replyCount(no);
//		model.addAttribute("keyReplyCount", replyCount);
		
		
		return "notice/noticeDetailView";
	}


	
	@RequestMapping("/noticeWriteView")
	public String noticeWriteView(HttpSession session) {
		// �α����� �ȵǾ����� �� �α����������� �̵�
//		if(session.getAttribute("login") == null) {
//			return "redirect:/loginView";
//		}
		return "notice/noticeWriteView";
	}
	
	@PostMapping("/noticeWriteDo")
	public String noticeWriteDo(NoticeDTO notice, HttpSession session) {
		System.out.println(notice);
		
		// ���ǿ� ��� ȸ�� ���� Ȯ��
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		
		// �α��� ������ ���� ��� memId�� null ���� ���� - �۾������� �ص� �ڵ�
		if (login == null) {
			notice.setMemId(null);
		} else {
			String memId = login.getMemId();
			notice.setMemId(memId);
		}

		System.out.println(notice);
		
		// �������� ���
		noticeService.writeNotice(notice);
		
		return "redirect:/noticeView";
	}
	
	// �� ����
	@PostMapping("/noticeDeleteDo")
	public String noticeDeleteDo(int no) {
		
		noticeService.noticeDeleteDo(no);
		
		return "redirect:/noticeView";
	}
	
	

}
