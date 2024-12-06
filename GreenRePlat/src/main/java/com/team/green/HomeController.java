package com.team.green;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.green.notice.dto.NoticeDTO;
import com.team.green.notice.service.NoticeService;
import com.team.green.review.dto.ReviewDTO;
import com.team.green.review.service.ReviewService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
        List<NoticeDTO> notices = noticeService.getNoti(4); // NoticeService에서 데이터 가져오기
        List<ReviewDTO> reviewList = reviewService.getHomeReview();
        
        model.addAttribute("reviewList" , reviewList);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("notices", notices);
		System.out.println(model);
		
		return "home";
	}
	
}
