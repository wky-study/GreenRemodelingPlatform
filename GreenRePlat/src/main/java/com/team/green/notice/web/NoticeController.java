package com.team.green.notice.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.green.common.exception.BizNotFoundException;
import com.team.green.notice.dto.NoticeDTO;
import com.team.green.common.vo.SearchVO;
import com.team.green.member.dto.MemberDTO;
import com.team.green.notice.service.NoticeService;
import com.team.green.reply.dto.ReplyDTO;
import com.team.green.reply.service.ReplyService;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	ReplyService replyService;
	
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

	    // 세션에 로그인된 사용자 정보가 있는 경우 ID를 모델에 추가
	    MemberDTO login = (MemberDTO) session.getAttribute("login");
	    if (login != null) {
	        model.addAttribute("loggedInUserId", login.getMemId());
	    }

	    return "notice/noticeView";
	}
	
	@RequestMapping("/noticeDetailView")
	public String noticeDetailView(ReplyDTO reply, int no, Model model) {
		System.out.println("클릭한 게시글 번호" + no);
		
		// 조회수 기능 추가 할거
		noticeService.noticeCountUp(no);
		
		System.out.println("조회수 끝");
		
		NoticeDTO notice = null;
		try {
			notice = noticeService.getNotice(no);
			
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			// 에러 발생 시 넣은 에러코드와 에러메시지 확인
			String errCode = e.getErrCode();
			String errMsg = e.getMessage();
			
			// 에러페이지에 에러메시지를 보여주고자 한다면 모델에 추가
			model.addAttribute("errMsg", errMsg);
			
			// 에러페이지로 보내기(에러페이지 안만듬)
			return "error/errPage";
			
		}
		
		System.out.println(notice);
		
		model.addAttribute("keyNotice", notice);
		
		// 댓글 목록 가져오기
		List<ReplyDTO> replyList = replyService.getReplyList(reply);
		model.addAttribute("keyReplyList",replyList);	
		
		
		// 게시글 댓글 수 가져오기
		int replyCount = replyService.replyCount(no);
		model.addAttribute("keyReplyCount", replyCount);
		
		
		return "notice/noticeDetailView";
	}
	
	// 리뷰게시판 글 수정 화면
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
		
		// 자유게시판 글 수정 등록
		@PostMapping("/noticeEditDo")
		public String noticeEditDo(NoticeDTO notice) {
			
			System.out.println(notice);
			
			noticeService.updateNotice(notice);
			
			return "redirect:/noticeDetailView?no=" + notice.getNoticeNo();
			
		}
	
	
	@RequestMapping("/noticeWriteView")
	public String noticeWriteView(HttpSession session) {
		// 로그인이 안되어있을 시 로그인페이지로 이동
//		if(session.getAttribute("login") == null) {
//			return "redirect:/loginView";
//		}
		return "notice/noticeWriteView";
	}
	
	@PostMapping("/noticeWriteDo")
	public String noticeWriteDo(NoticeDTO notice, HttpSession session) {
		System.out.println(notice);
		
		// 세션에 담긴 회원 정보 확인
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		
		// 로그인 정보가 없을 경우 memId에 null 값을 설정 - 작업용으로 해둔 코드
		if (login == null) {
			notice.setMemId(null);
		} else {
			String memId = login.getMemId();
			notice.setMemId(memId);
		}

		System.out.println(notice);
		
		// 공지사항 등록
		noticeService.writeNotice(notice);
		
		return "redirect:/noticeView";
	}
	
	// 글 삭제
	@PostMapping("/noticeDeleteDo")
	public String noticeDeleteDo(@RequestParam int noticeNo) { // 'noticeNo' 파라미터를 @RequestParam으로 받음
//	    if (noticeNo == null) {
//	        // 'noticeNo' 파라미터가 없을 경우 처리할 코드
//	        return "redirect:/noticeView"; // 예시: 홈으로 리디렉션
//	    }
	    System.out.println("삭제할 글 번호: " + noticeNo);

	    noticeService.noticeDeleteDo(noticeNo);

	    return "redirect:/noticeView";
	}



	
	

}
