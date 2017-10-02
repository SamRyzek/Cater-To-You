package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import data.LoginDAO;
import entity.Customer;
import entity.User;

@Controller
public class LoginController {

	@Autowired
	LoginDAO dao;

	@RequestMapping("index.do")
	public String displayHome(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return "views/index.jsp";
		}
		return getCorrectJSP(user);
	}

	private String getCorrectJSP(User user) {
		String jsp = "";
		switch(user.getUserRoles().getId()) {

		case 1:
			jsp = "views/customer..jsp";
			break;
		case 2:
			jsp = "views/company.jsp";
			break;
		case 3:
			jsp = "views/admin.jsp";
			break;
		default: jsp = "views/index.jsp";
		}
		return jsp;
	}

	@RequestMapping(path = "checkLogin.do",
			method = RequestMethod.GET)
	public String checkLogin(Model model, HttpSession session,
			@RequestParam("username") String userName,
			@RequestParam("password") String password) {
		String sql = "SELECT u FROM User u WHERE u.username = :user AND u.password = :pass";
		User user = dao.returnUser(userName, password);
		if(user == null) {
			model.addAttribute("loginErr", "Your information Incorrect");
			return "/views/index.jsp";
		}
		setSessions(session, user);
		return getCorrectJSP(user);
	}

	private void setSessions(HttpSession session, User user) {
		switch(user.getUserRoles().getId()) {
		case 1:
			Customer cust = dao.getCustomer(user);
			session.setAttribute("customer", cust);
			break;
		}
	}

}
