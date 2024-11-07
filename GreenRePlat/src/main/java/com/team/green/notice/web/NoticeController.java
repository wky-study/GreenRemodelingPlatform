package com.team.green.notice.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.green.notice.dto.NoticeDTO;
import com.team.green.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("/noticeView")
	public String noticeView(Model model) {
		
		List<NoticeDTO> noticeList = noticeService.getNoticeList();
		model.addAttribute("noticeList", noticeList);
		
		return "notice/noticeView";
	}
	
	@RequestMapping("/noticeWriteView")
	public String noticeWriteView(HttpSession session) {
//		if(session.getAttribute("login") == null) {
//			return "redirect:/loginView";
//		}
		return "notice/noticeWriteView";
	}

}
