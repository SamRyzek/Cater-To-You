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
		if (user == null) {
			return "views/index.jsp";
		}
		return getCorrectJSP(user);
	}
	
	@RequestMapping("customer.do")
	public String displayCustomer(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("address", user.getCustomer().getAddress());
		return "views/customer.jsp";
	}
	
	@RequestMapping("company.do")
	public String displayCompany(Model model, HttpSession session) {
		return "views/company.jsp";
	}
	
	@RequestMapping("admin.do")
	public String displayAdmin(Model model, HttpSession session) {
		return "views/admin.jsp";
	}

	@RequestMapping(path = "checkLogin.do", method = RequestMethod.POST)
	public String checkLogin(Model model, HttpSession session, @RequestParam("username") String userName,
			@RequestParam("password") String password) {
		User user = dao.returnUser(userName, password);
		if (user == null) {
			model.addAttribute("loginErr", "Your information Incorrect");
			return "/views/index.jsp";
		}
		setSessions(session, user);
		model.addAttribute("user", user);
		model.addAttribute("address", user.getCustomer().getAddress());
		return getCorrectJSP(user);
	}

	private String getCorrectJSP(User user) {
		String jsp = "";
		switch (user.getUserRoles().getId()) {

		case 1:
			jsp = "redirect:customer.do";
			break;
		case 2:
			jsp = "redirect:company.do";
			break;
		case 3:
			jsp = "redirect:admin.do";
			break;
		default:
			jsp = "redirect:index.jsp";
		}
		return jsp;
	}

	private void setSessions(HttpSession session, User user) {
		switch (user.getUserRoles().getId()) {
		case 1:
			Customer cust = dao.getCustomer(user);
			session.setAttribute("customer", cust);
			session.setAttribute("user", user);
			break;
		}
	}

}
