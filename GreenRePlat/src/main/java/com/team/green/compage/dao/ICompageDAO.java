package com.team.green.compage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.common.vo.SearchVO;
import com.team.green.compage.dto.CompageDTO;

@Mapper
public interface ICompageDAO {
	// 리뷰 게시판 글 목록 가져오기
		List<CompageDTO> getCpList(SearchVO search);
		
		// 리뷰 게시판 글 총 갯수 가져오기
		int getCpCount(SearchVO search);
		
		// 리뷰 게시글 한개 조회 하기
		CompageDTO getCp(int no);
		
		// 리뷰 게시글 작성하기
		int writeCp(CompageDTO cp);
		
		// 리뷰 게시글 조회수 업데이트
		int cpCountUp(int no);
		
		// 리뷰 게시글 수정
		int updateCp(CompageDTO cp);
		
		// 리뷰 게시글 삭제
		int deleteCp(int cpNo);
		
}
