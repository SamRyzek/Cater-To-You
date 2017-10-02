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
import entity.Menu;
import entity.Order;

@Controller
public class CustomerController {
	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(path = "Shop.do", method = RequestMethod.GET)
	public String index(Model model) {
		List<Company> companies = companyDAO.index();
		model.addAttribute("allCompanies", companies);
		return "views/menus.jsp";
	}

	@RequestMapping(path = "ShopHere.do", method = RequestMethod.GET)
	public String show(@RequestParam("id") Integer id, Model model) {
		List<Item> menuItems = customerDAO.showMenu(id);
		model.addAttribute("menu", menuItems);
		return "views.menus.jsp";
	}

	@RequestMapping(path = "OrderHistory.do", method = RequestMethod.GET)
	public String show(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			List<Order> orderHistory = customerDAO.findOrderHistory(customer.getId());
			model.addAttribute("orders", orderHistory);
			return "views.orderHistory.jsp";
		}
	}

	@RequestMapping(path = "updateCustomer.do", method = RequestMethod.GET)
	public String customerUpdate(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			model.addAttribute("address", customer.getAddress());
		}
		return "views.customerUpdate.jsp";

	}
	
	

}