package com.team.green.notice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team.green.notice.dto.NoticeDTO;

@Mapper
public interface INoticeDAO {
	
	List<NoticeDTO> getNoticeList();
	

}
