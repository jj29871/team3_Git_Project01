package ncontroller;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import service.JoinService;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	@Autowired
	private View jsonview;
	@Autowired
	private JoinService service;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "join.htm", method = RequestMethod.GET)
	public String join() {
		// return "join.jsp";
		return "joinus.join";
	}


	
	@RequestMapping(value = "join.htm", method = RequestMethod.POST)
	public String join(Member member) throws ClassNotFoundException, SQLException {
		int result = 0;
		String viewpage = "";
		String birth =member.getYear().substring(2)+member.getMonth()+member.getDay();
		System.out.println(birth);
		member.setBirth(birth);
		member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
		result = service.insertMember(member);
		System.out.println(member.getHabit());
		if (result > 0) {
			System.out.println("삽입 성공");
			viewpage = "redirect:/index.htm";
		} else {
			System.out.println("삽입 실패");
			viewpage = "join.htm";
		}
		return viewpage;
	}
	
	@RequestMapping(value = "idcheck.htm", method = RequestMethod.POST)
	public View idCheck(@RequestParam("userid") String userid, Model model) {
		int result = service.idCheck(userid);
		if (result > 0) {
			System.out.println("아이디 중복");
			model.addAttribute("result", "fail");
		} else {
			System.out.println("삽입 실패");
			model.addAttribute("result", "success");
		}
		return jsonview;
	}
	
	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String login() {

		return "joinus.login";
	}

}
