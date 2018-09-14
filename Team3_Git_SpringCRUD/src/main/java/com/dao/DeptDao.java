package com.dao;

import java.util.List;

import com.dto.DeptDto;

public interface DeptDao {
	
	/***************���� Start**************/
	
	List<DeptDto> getDeptList(); //��ü��ȸ
	
	/****************���� End***************/
	
	/**********회준 start**********/
	int insertDept(DeptDto dto);
	/**********회준 end**********/
}
