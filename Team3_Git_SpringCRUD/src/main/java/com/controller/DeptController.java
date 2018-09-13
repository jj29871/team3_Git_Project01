package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.DeptDto;
import com.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	private DeptService deptService;

	/********************* ���� Start (Select����) **********************/
	@RequestMapping("index.htm")
	public String deptlist(Model model) throws SQLException {

		List<DeptDto> list = deptService.getDeptList();
		model.addAttribute("list", list);
		return "home.deptList";
	}

	@RequestMapping("deptList.htm")
	public String getlist(Model model) throws SQLException {
		List<DeptDto> list = deptService.getDeptList();
		model.addAttribute("list", list);
		return "home.deptList";
	}

	/********************* ���� End (Select����) **********************/

	// 정원 excel, pdf controller
	@RequestMapping("noticeExcel.htm")
	public String noticeExcel(Model model) throws ClassNotFoundException, SQLException {

		List<DeptDto> list = deptService.noticeExcel();

		model.addAttribute("noticeList", list);

		return "noticeListExcel";
	}

	@RequestMapping("noticePdf.htm")
	public String pageRankReport(Model model) throws ClassNotFoundException, SQLException {

		List<DeptDto> list = deptService.noticePdf();

		model.addAttribute("noticeList", list);

		return "noticeListPdf";
	}

}
