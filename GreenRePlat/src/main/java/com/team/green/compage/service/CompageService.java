package com.team.green.compage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.common.exception.BizNotFoundException;
import com.team.green.common.vo.SearchVO;
import com.team.green.compage.dao.ICompageDAO;
import com.team.green.compage.dto.CompageDTO;

@Service
public class CompageService {

	@Autowired
	ICompageDAO dao;

	// 글 목록 가져오기
	public List<CompageDTO> getCpList(SearchVO search) {
		List<CompageDTO> result = dao.getCpList(search);
		return result;
	}

	// 글 총 갯수 가져오기
	public int getCpCount(SearchVO search) {
		int result = dao.getCpCount(search);
		return result;
	}

	// 글 한개 조회 하기
	public CompageDTO getCp(int no) throws BizNotFoundException {
		CompageDTO result = dao.getCp(no);

		if (result == null) {
			throw new BizNotFoundException("해당 게시글의 번호가 존재하지 않습니다.", "API_001");
		}

		return result;
	}

	// 글 작성하기
	public int writeCp(CompageDTO cp) {
		int result = dao.writeCp(cp);
		return result;
	}

	// 리뷰게시글 조회수 업데이트
	public int cpCountUp(int no) {
		int result = dao.cpCountUp(no);
		return result;
	}

	// 리뷰게시글 수정
	public int updateCp(CompageDTO cp) {
		int result = dao.updateCp(cp);
		return result;

	}

	// 리뷰 게시글 삭제
	public int deleteCp(int cpNo) {
		int result = dao.deleteCp(cpNo);
		return result;
	}
}
