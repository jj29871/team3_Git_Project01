package com.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dto.DeptDto;



public interface DeptDao {
	
	int insertDept(DeptDto dto);
	int update(DeptDto dto);
	int delete(DeptDto dto);
	List<DeptDto> getDeptList(); //전체조회
	List<DeptDto> deptnoCheck(int deptno);
	
	
	
}
