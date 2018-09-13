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
	
	public int insertDept(DeptDto dto) {
		DeptDao deptdao=  sqlsession.getMapper(DeptDao.class);
		int result = deptdao.insertDept(dto);
		return result;
	}
	public int update(DeptDto dto) {
		DeptDao deptdao=  sqlsession.getMapper(DeptDao.class);
		deptdao.update(dto);
		return 0;
	}
	public int delete(DeptDto dto) {
		DeptDao deptdao=  sqlsession.getMapper(DeptDao.class);
		deptdao.delete(dto);
		return 0;
	}
	public List<DeptDto> getDeptList(){		
		DeptDao deptdao=  sqlsession.getMapper(DeptDao.class);
		List<DeptDto> list = deptdao.getDeptList();
		return list;
	}
	public List<DeptDto> deptnoCheck(int deptno){
		DeptDao deptdao=  sqlsession.getMapper(DeptDao.class);
		List<DeptDto> list = deptdao.deptnoCheck(deptno);
		return list;
	}
	
}
