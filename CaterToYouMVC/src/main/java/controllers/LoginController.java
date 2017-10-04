package controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cater.data.AdminDAO;
import cater.data.CompanyDAO;
import cater.data.CustomerDAO;
import data.LoginDAO;
import entity.Customer;
import entity.Employee;
import entity.Item;
import entity.User;

@Controller
public class LoginController {

	@Autowired
	LoginDAO dao;
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	CompanyDAO companyDAO;
	@Autowired
	AdminDAO adminDAO;

	@RequestMapping("index.do")
	public String displayHome(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "views/index.jsp";
		}
		return getCorrectJSP(model, user);
	}

	@RequestMapping("newUser.do")
	public String goToCreateUserPage() {
		return "views/newUser.jsp";
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
		User user = (User) session.getAttribute("user");
		List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
		model.addAttribute("user", user);
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("company", user.getEmployee().getCompany());
		model.addAttribute("address", user.getEmployee().getCompany().getAddress());
		model.addAttribute("menu", menuItems);

		return "views/company.jsp";
	}

	@RequestMapping("admin.do")
	public String displayAdmin(Model model, HttpSession session) {
		model.addAttribute("companies", companyDAO.index());
		model.addAttribute("users", adminDAO.index());
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
		return getCorrectJSP(model, user);
	}

	private String getCorrectJSP(Model model, User user) {
		String jsp = "";
		switch (user.getUserRoles().getId()) {

		case 1:
			jsp = "redirect:customer.do";
			break;
		case 2:
			if (user.getEmployee().getActive() == 1) {
				jsp = "redirect:company.do";
			} else {
				model.addAttribute("loginErr", "Your information Incorrect");
				return "/views/index.jsp";
			}
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
		case 2:
			Employee employee = dao.getEmployee(user);
			session.setAttribute("employee", employee);
			session.setAttribute("user", user);
			break;
		case 3:
			session.setAttribute("user", user);
			break;
		}
	}

}
