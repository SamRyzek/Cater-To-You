package controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cater.data.CompanyDAO;
import cater.data.CustomerDAO;
import entity.Company;
import entity.Customer;
import entity.Item;
import entity.User;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private CustomerDAO customerDAO;


	@RequestMapping(path = "UpdateMenuItem.do", method = RequestMethod.GET)
	public String index(Model model, @RequestParam("menuId") Integer id) {
		Item item = customerDAO.returnItemById(id);
		model.addAttribute("item", item);
		return "views/itemUpdate.jsp";
	}




	

}