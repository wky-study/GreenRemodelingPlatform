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

	// 리뷰목록 페이지
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
	
	// 리뷰 게시글 추가로 가져오기
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
	
	// 리뷰 글 작성 클릭
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
	
	
	// 리뷰 글 상세 페이지
	@RequestMapping("/compageDetailView")
	public String reviewDetailView(ReplyDTO reply, Model model, int no) {
		
		System.out.println("클릭한 게시글 번호" + no);
		
		reply.setReviewNo(no);
		
		System.out.println(reply);
		
		// 조회수 기능 추가 할거
		cpgSvc.reviewCountUp(no);
		
		System.out.println("조회수 끝");
		
		CompageDTO review = null;
		try {
			review = cpgSvc.getReview(no);
			
		} catch (BizNotFoundException e) {
			e.printStackTrace();
			// 에러 발생 시 넣은 에러코드와 에러메시지 확인
			String errCode = e.getErrCode();
			String errMsg = e.getMessage();
			
			// 에러페이지에 에러메시지를 보여주고자 한다면 모델에 추가
			model.addAttribute("errMsg", errMsg);
			
			// 에러페이지로 보내기(안만듬)
			return "error/errPage";
			
		}
		
		System.out.println(review);
		
		model.addAttribute("keyReview", review);
		
		// 댓글 목록 가져오기
		List<ReplyDTO> replyList = replyService.getReplyList(reply);
		model.addAttribute("keyReplyList",replyList);	
		
		
		// 게시글 댓글 수 가져오기
		int replyCount = replyService.replyCount(no);
		model.addAttribute("keyReplyCount", replyCount);
		
		
		return "compage/compageDetailView";
	}
	
	// 리뷰게시판 글 수정 화면
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
	
	// 자유게시판 글 수정 등록
	@PostMapping("/compageEditDo")
	public String reviewEditDo(CompageDTO review) {
		
		System.out.println(review);
		
		cpgSvc.updateReview(review);
		
		return "redirect:/compageDetailView?no=" + review.getReviewNo();	
	}
	
	// 자유게시판 글 삭제
	@PostMapping("/compageDeleteDo")
	public String reviewDeleteDo(int no) {
		
		cpgSvc.deleteReview(no);
		
		return "redirect:/compageView";	
	}
}
