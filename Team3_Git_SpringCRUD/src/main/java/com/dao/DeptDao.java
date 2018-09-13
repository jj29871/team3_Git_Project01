package com.dao;

import java.util.List;

import com.dto.DeptDto;

public interface DeptDao {

	/*************** ���� Start **************/

	List<DeptDto> getDeptList(); // ��ü��ȸ

	/**************** ���� End ***************/

	// 정원 게시물 엑셀출력, pdf출력
	List<DeptDto> getDownload();

}
