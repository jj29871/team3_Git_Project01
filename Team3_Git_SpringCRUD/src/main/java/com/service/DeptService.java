package com.service;

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
	
/********************���� start (select����)***********************/
	
	public List<DeptDto> getDeptList(){		
		DeptDao deptdao=  sqlsession.getMapper(DeptDao.class);
		List<DeptDto> list = deptdao.getDeptList();
		return list;
	}
	
/********************���� end (select����)***********************/
	
/**********회준 start**********/
	public int insertDept(DeptDto dto) {
		DeptDao deptdao=  sqlsession.getMapper(DeptDao.class);
		int result = deptdao.insertDept(dto);
		return result;
	}
/**********회준 end**********/
	
}
