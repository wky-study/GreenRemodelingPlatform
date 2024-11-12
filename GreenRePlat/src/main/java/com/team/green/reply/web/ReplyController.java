package com.team.green.reply.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.green.common.util.MyUtil;
import com.team.green.reply.dto.ReplyDTO;
import com.team.green.reply.service.ReplyService;


@Controller
public class ReplyController {

	@Autowired
	ReplyService replyService;

	@ResponseBody
	@PostMapping("/replyWriteDo")
	public ReplyDTO replyWriteDo(ReplyDTO reply) {
		System.out.println(reply); // reviewNo, memId, replyContent�� ���
		
		String uniqueId = MyUtil.makeUniqueId();
		reply.setReplyNo(uniqueId); // ����ũ ���̵� �ݿ�
		
		replyService.insertReply(reply);  // DB�� ��� ���
		
		ReplyDTO result = replyService.getReply(uniqueId); // ��� �߰��� ��� ������ ������
		
		return result;
		
		
	}

	@ResponseBody
	@PostMapping("/delReplyDo")
	public String delReplyDo(String replyNo) {
		
		System.out.println(replyNo);
		String resp = "success";
		
		int cnt = replyService.deleteReply(replyNo);
		
		
		if(cnt == 0) {
			resp = "fail";
		}
		
		return resp;
	}
	
}
