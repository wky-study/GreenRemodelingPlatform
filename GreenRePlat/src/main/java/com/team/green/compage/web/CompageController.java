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

	// 리뷰목록 페이지
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
	
	// 리뷰 게시글 추가로 가져오기
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
	
	// 리뷰 글 작성 클릭
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
	
	
	// 리뷰 글 상세 페이지
	@RequestMapping("/compageDetailView")
	public String compageDetailView(ReplyDTO reply, Model model, int no) {
		
		System.out.println("클릭한 게시글 번호" + no);
		
		reply.setReviewNo(no);
		
		System.out.println(reply);
		
		// 조회수 기능 추가 할거
		cpgSvc.cpCountUp(no);
		
		System.out.println("조회수 끝");
		
		CompageDTO cp = null;
		try {
			cp = cpgSvc.getCp(no);
			
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
		
		System.out.println(cp);
		
		model.addAttribute("keyCp", cp);
		
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
	
	// 자유게시판 글 수정 등록
	@PostMapping("/compageEditDo")
	public String reviewEditDo(CompageDTO cp) {
		
		System.out.println(cp);
		
		cpgSvc.updateCp(cp);
		
		return "redirect:/compageDetailView?no=" + cp.getCpNo();	
	}
	
	// 자유게시판 글 삭제
	@PostMapping("/compageDeleteDo")
	public String compageDeleteDo(int no) {
		
		cpgSvc.deleteCp(no);
		
		return "redirect:/compageView";	
	}
}
