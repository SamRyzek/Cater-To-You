package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cater.data.CompanyDAO;
import cater.data.CustomerDAO;
import entity.Item;
import entity.User;

@Controller
public class AdminController {

	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(path = "UpdateAccount.do", method = RequestMethod.POST)
	public String chooseUpdatePage(Model model, @RequestParam("userID") Integer id) {
		User user = companyDAO.findUserById(id);
		if (user.getUserRoles().getId() == 1) {
			model.addAttribute("address", user.getCustomer().getAddress());
			return "views/customerUpdate.jsp";
		} else if (user.getUserRoles().getId() == 2) {
			model.addAttribute("user", user);
			model.addAttribute("employee", user.getEmployee());
			return "views/employeeUpdate.jsp";
		}
		return "redirect:index.do";
	}
}