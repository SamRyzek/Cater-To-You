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
import cater.data.CustomerInput;
import entity.Address;
import entity.Company;
import entity.Customer;
import entity.Item;
import entity.User;

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

	@RequestMapping(path = "ShopHere.do", method = RequestMethod.POST)
	public String show(@RequestParam("companyId") Integer id, Model model) {
		List<Item> menuItems = customerDAO.showMenu(id);
		Company company = companyDAO.findCompanyById(id);
		model.addAttribute("menu", menuItems);
		model.addAttribute("company", company);
		model.addAttribute("address", company.getAddress());
		return "views/menu.jsp";
	}

//	@RequestMapping(path = "OrderHistory.do", method = RequestMethod.GET)
//	public String show(Model model, HttpSession session) {
//		Customer customer = (Customer) session.getAttribute("customer");
//		if (customer != null) {
//			List<Order> orderHistory = customerDAO.findOrderHistory(customer.getId());
//			model.addAttribute("orders", orderHistory);
//			return "views/orderHistory.jsp";
//		}
//	}

	@RequestMapping(path = "UpdateCustomer.do", method = RequestMethod.POST)
	public String customerUpdate(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			model.addAttribute("address", customer.getAddress());
		}
		return "views/customerUpdate.jsp";
	}
	
	@RequestMapping(path = "editCustomer.do", method = RequestMethod.POST)
	public String customerEdit(Model model, HttpSession session, CustomerInput input) {
		Customer customer = (Customer) session.getAttribute("customer");
		Address address = customer.getAddress();
		address.setCity(input.getCity());
		address.setState(input.getState());
		address.setStreet(input.getStreet());
		address.setStreet2(input.getStreet2());
		address.setZip(Integer.parseInt(input.getZip()));
		User user = (User)session.getAttribute("user");
		customer = customerDAO.updateEmail(customer);
		customer = customerDAO.updateAddress(customer, address);
		session.setAttribute("user", user);
		session.setAttribute("customer", customer);
		model.addAttribute("customer", customer);
		model.addAttribute("address", customer.getAddress());
		model.addAttribute("user", (User)session.getAttribute("user"));
		return "views/customer.jsp";

	}
	

}