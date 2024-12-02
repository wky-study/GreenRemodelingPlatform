package com.team.green.notice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team.green.attach.dto.AttachDTO;
import com.team.green.attach.service.AttachService;
import com.team.green.common.exception.BizNotFoundException;
import com.team.green.notice.dto.NoticeDTO;
import com.team.green.common.vo.FileUploadVO;
import com.team.green.common.vo.SearchVO;
import com.team.green.member.dto.MemberDTO;
import com.team.green.notice.service.NoticeService;
import com.team.green.reply.dto.ReplyDTO;
import com.team.green.reply.service.ReplyService;

@Controller
public class NoticeController {
	
	@Value("#{util['file.attach.path']}")
	String attachPath;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	ReplyService replyService;
	
	@Autowired
	AttachService attachService;
	
	@Autowired
	FileUploadVO fileUpload;
	
	@RequestMapping("/noticeView")
	public String noticeView(Model model, SearchVO search, HttpSession session) {
	    int noticeCount = noticeService.getNoticeCount(search);
	    System.out.println(noticeCount);
	    
	    search.setNoticeCount(noticeCount);
	    search.noticeSetting();
	    
	    List<NoticeDTO> notice = noticeService.getNoticeList(search);
	    System.out.println(notice);
	    System.out.println(search);
	    
	    model.addAttribute("keyNotice", notice);
	    model.addAttribute("keySearch", search);

	    // ���ǿ� �α��ε� ����� ������ �ִ� ��� ID�� �𵨿� �߰�
	    MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
	    if (login != null) {
	        model.addAttribute("loggedInUserId", login.getMemId());
	    }

	    return "notice/noticeView";
	}
	
	@RequestMapping("/noticeDetailView")
	public String noticeDetailView(ReplyDTO reply, int no, Model model, HttpSession session) {
		System.out.println("Ŭ���� �Խñ� ��ȣ" + no);
		
		MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
	    if (login != null) {
	        model.addAttribute("loggedInUserId", login.getMemId());
	    }
		
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
		
		model.addAttribute("keyNotice", notice);
		
		// ��� ��� ��������
		List<ReplyDTO> replyList = replyService.getReplyList(reply);
		model.addAttribute("keyReplyList",replyList);
		
		// �Խñ� ��� �� ��������
		int replyCount = replyService.replyCount(no);
		model.addAttribute("keyReplyCount", replyCount);
		
		// �ش� �Խñ��� ÷������ ��������
		List<AttachDTO> attachList = attachService.getAttachList(no);
		model.addAttribute("attachList", attachList);
		
		
		return "notice/noticeDetailView";
	}
	
	// ����Խ��� �� ���� ȭ��
		@PostMapping("/noticeEditView")
		public String noticeEditView(int no, Model model) {
			
			try {
				NoticeDTO notice = noticeService.getNotice(no);
				model.addAttribute("keyNotice", notice);
			} catch (BizNotFoundException e) {
				e.printStackTrace();
				return "errPage";
			}
			
			return "notice/noticeEditView";
		}
		
		// �����Խ��� �� ���� ���
		@PostMapping("/noticeEditDo")
		public String noticeEditDo(NoticeDTO notice) {
			
			System.out.println(notice);
			
			noticeService.updateNotice(notice);
			
			return "redirect:/noticeDetailView?no=" + notice.getNoticeNo();
			
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
	public String noticeWriteDo(NoticeDTO notice, HttpSession session, MultipartFile[] noFile) {
	    System.out.println(notice);

	    // ���ǿ� ��� ȸ�� ���� Ȯ��
	    MemberDTO login = (MemberDTO) session.getAttribute("memInfo");

	    // �α��� ������ ���� ��� memId�� null ���� ���� - �۾������� �ص� �ڵ�
	 	if (login == null) {
	 		notice.setMemId(null);
	 	} else {
	 		String memId = login.getMemId();
	 		notice.setMemId(memId);
	 	}
	 	
	 	int atchNoticeNo = noticeService.getNoticeNo();
	 	
	 	System.out.println("����"+noFile);
	 		
	 	// ÷�ε� ������ ������ �� ������ ���ÿ� �����ϰ� DB�� ����� ������ ������ ������
	 	// ÷�������� ���� �� ����Ǿ���
	 	if(noFile != null && noFile.length > 0 && !noFile[0].isEmpty()) {
	 		System.out.println("���� ����: " + noFile.length);
	 		
	 		try {
	 			List<AttachDTO> attachList = fileUpload.saveFiles(noFile);
	 			if(!attachList.isEmpty()) {
	 				for(AttachDTO attach : attachList) {
	 					attach.setAtchNoticeNo(atchNoticeNo);
	 					attachService.insertAttach(attach);
	 				}
	 			}
	 		} catch(IOException e) {
	 			e.printStackTrace();
	 			System.out.println("���ε�ȵ�");
	 			return "notice/noticeView";
	 		}
	 	}
	 		
	 		
	 		

	    // �������� ���
	    noticeService.writeNotice(notice); // �������� ��� ���� ȣ��

	    

	    return "redirect:/noticeView"; // �������� ������� �����̷�Ʈ
	}

	// �� ����
	@PostMapping("/noticeDeleteDo")
	public String noticeDeleteDo(@RequestParam int noticeNo) { 
		// 'noticeNo' �Ķ���͸� @RequestParam���� ����
	    System.out.println("������ �� ��ȣ: " + noticeNo);

	    noticeService.noticeDeleteDo(noticeNo);

	    return "redirect:/noticeView";
	}



	
	

}
