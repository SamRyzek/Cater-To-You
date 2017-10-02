package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import data.LoginDAO;
import entity.User;

@Controller
public class LoginController {
	
	@Autowired
	LoginDAO dao;
	
	@RequestMapping("index.do")
	public String displayHome(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return "index";
		}
		return getCorrectJSP(user);
	}
	
	private String getCorrectJSP(User user) {
		String jsp = "";
		switch(user.getUserRoles().getId()) {
		
		case 1:
			jsp = "customer";
			break;
		case 2:
			jsp = "company";
			break;
		case 3:
			jsp = "admin";
			break;
		default: jsp = "index";
		}
		return jsp;
	}
	
	@RequestMapping(path = "", 
			method = RequestMethod.POST,
			params = "login")
	public String checkLogin(Model model, HttpSession session,
			@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		
		return "";
	}
	
}
