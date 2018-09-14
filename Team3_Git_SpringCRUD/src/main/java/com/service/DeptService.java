package com.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DeptDao;
import com.dto.DeptDto;

@Service
public class DeptService {

	@Autowired
	private SqlSession sqlsession;

	/******************** 재훈 start (select관련) ***********************/

	public List<DeptDto> getDeptList() {
		DeptDao deptdao = sqlsession.getMapper(DeptDao.class);
		List<DeptDto> list = deptdao.getDeptList();
		return list;
	}

	/******************** 재훈 end (select관련) ***********************/

	// 정원 excel, pdf service

	// 게시판 엑셀
	public List<DeptDto> noticeExcel() throws ClassNotFoundException, SQLException {
		DeptDao noticedao = sqlsession.getMapper(DeptDao.class);
		List<DeptDto> list = noticedao.getDownload();

		return list;
	}

	// 게시판 pdf
	public List<DeptDto> noticePdf() throws ClassNotFoundException, SQLException {
		DeptDao noticedao = sqlsession.getMapper(DeptDao.class);
		List<DeptDto> list = noticedao.getDownload();

		return list;
	}


/**********회준 start**********/
	public int insertDept(DeptDto dto) {
		DeptDao deptdao=  sqlsession.getMapper(DeptDao.class);
		int result = deptdao.insertDept(dto);
		return result;
	}
/**********회준 end**********/
	
}
