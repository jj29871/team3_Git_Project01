package com.dao;

import java.util.List;

import com.dto.DeptDto;

public interface DeptDao {

	/*************** 재훈 Start **************/

	List<DeptDto> getDeptList(); // ��ü��ȸ

	/**************** 재훈 End ***************/

	/*************** 정원 게시물 엑셀출력, pdf출력******/
	
	List<DeptDto> getDownload();
	
	/********************************************/
	
	
	/**********회준 start**********/
	int insertDept(DeptDto dto);
	/**********회준 end**********/
	
	/**********민지 start***********/
	int delete(DeptDto dto);
	/**********민지 end***********/
	
	

}
