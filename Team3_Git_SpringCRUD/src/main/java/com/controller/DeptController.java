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

	
/*********************ÀçÈÆ Start (Select°ü·Ã)**********************/
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
/*********************ÀçÈÆ End (Select°ü·Ã)**********************/
	
	
}
