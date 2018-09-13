package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import com.dto.DeptDto;
import com.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private View jsonview;
	@Autowired
	private DeptService deptService;

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

	@RequestMapping(value = "deptInsert.htm", method = RequestMethod.GET)
	public String deptinsert() {

		return "crud.deptInsert";
	}

	@RequestMapping(value = "deptInsert.htm", method = RequestMethod.POST)
	public String insert(DeptDto dto) {

		deptService.insertDept(dto);
		return "redirect:index.htm";
	}

	@RequestMapping(value = "deptUpdateForm.htm", method = RequestMethod.GET)
	public String deptupdateForm() {

		return "crud.deptUpdate";
	}

	@RequestMapping(value = "deptUpdate.htm", method = RequestMethod.POST)
	public String deptupdate(DeptDto dto) throws ClassNotFoundException, SQLException {

		deptService.update(dto);
		return "redirect:index.htm";
	}
	
	@RequestMapping(value = "deptDelete.htm")
	public String deptdelete(DeptDto dto) {

		deptService.delete(dto);
		return "redirect:index.htm";

	}
	
	/*ajax*/
	@RequestMapping(value="deptnoCheck.htm", method = RequestMethod.GET)
	public View deptnoChk(int deptno, ModelMap map){
		
		List<DeptDto> list = deptService.deptnoCheck(deptno);
		map.addAttribute("list", list);
		
		return jsonview;  //private View jsonview 타입으로 리턴
	}
	/*ajax*/
	@RequestMapping("ajaxInsert.htm")
	public @ResponseBody View add(@RequestBody DeptDto dto) //@RequestBody (비동기: 객체 형태로 받아요) 
	{	
		deptService.insertDept(dto);
		return jsonview;
	}
}
