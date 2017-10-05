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
import entity.Address;
import entity.Company;
import entity.Item;
import entity.Menu;
import entity.User;

@Controller
public class AdminController {

	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private AdminDAO adminDAO;

	@RequestMapping(path = "UpdateAccount.do", method = RequestMethod.GET)
	public String chooseUpdatePage(Model model, @RequestParam("userID") Integer id) {
		User user = companyDAO.findUserById(id);

		if (user.getUserRoles().getId() == 1) {
			model.addAttribute("address", user.getCustomer().getAddress());
			model.addAttribute("user", user);
			model.addAttribute("customer", user.getCustomer());
			return "views/customerUpdate.jsp";
		} else if (user.getUserRoles().getId() == 2) {
			model.addAttribute("user", user);
			model.addAttribute("employee", user.getEmployee());
			return "views/employeeUpdate.jsp";
		}
		return "redirect:index.do";
	}

	@RequestMapping(path = "AdminUpdateCompany.do", method = RequestMethod.GET)
	public String userUpdate(@RequestParam("companyID") Integer id, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			Company company = companyDAO.findCompanyById(id);
			System.out.println(company.getName());
			model.addAttribute("user", user);
			model.addAttribute("company", company);
			model.addAttribute("address", company.getAddress());
			model.addAttribute("staff", companyDAO.findUserEmployeesByCompany(company));
			model.addAttribute("inactiveStaff", companyDAO.findInactiveUserEmployeesByCompany(company));
			List<Item> menuItems = customerDAO.showMenu(company.getId());
			model.addAttribute("menu", menuItems);
			model.addAttribute("employee", user.getEmployee());
			model.addAttribute("image", company.getImage());

		}
		return "views/companyUpdate.jsp";
	}

	@RequestMapping(path = "CreateCompany.do", method = RequestMethod.GET)
	public String userUpdate(Model model, HttpSession session) {
		return "views/createCompany.jsp";

	}

	@RequestMapping(path = "makeCompany.do", method = RequestMethod.POST)
	public String userEdit(@RequestParam("name") String name, @RequestParam("street") String street,
			@RequestParam("street2") String street2, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("zip") int zip, @RequestParam("url") String imageURL,
			Model model, HttpSession session) {
		Company compTemp = new Company();
		Address addTemp = new Address();
	
		if (name.isEmpty()) {
			model.addAttribute("message", "Company must have a name.");
			return "views/createCompany.jsp";
		} else {
			compTemp.setName(name);
		}
		if (street == null) {
			model.addAttribute("message", "Company must have a street.");
			return "views/createCompany.jsp";
		} else {
			addTemp.setStreet(street);
		}
		if (street2 == null) {
		} else {
			addTemp.setStreet2(street2);
		}
		if (city.isEmpty()) {
			model.addAttribute("message", "Company must have a city.");
			return "views/createCompany.jsp";
		} else {
			addTemp.setCity(city);
		}
		if (state.isEmpty()) {
			model.addAttribute("message", "Company must have a state.");
			return "views/createCompany.jsp";
		} else {
			addTemp.setState(state);
		}
		if (zip == ' ') {
			model.addAttribute("message", "Company must have a zip.");
			return "views/createCompany.jsp";
		} else {
			addTemp.setZip(zip);
		}
		addTemp = companyDAO.createAddress(addTemp);
		Menu menu = adminDAO.createMenu();
		compTemp.setMenu(menu);
		compTemp.setAddress(addTemp);
		
		compTemp = adminDAO.createCompany(compTemp);
		model.addAttribute("company", compTemp);
		return "views/createEmployee.jsp";
	}
	
	@RequestMapping(path = "InactivateCompany.do", method = RequestMethod.POST)
	public String inactivateComp(@RequestParam("companyID") Integer oldId, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
			Company company = companyDAO.findCompanyById(oldId);
			adminDAO.makeCompanyInactive(company);

		return "redirect:index.do";
	}
	@RequestMapping(path = "ActivateCompany.do", method = RequestMethod.POST)
	public String activateComp(@RequestParam("companyID") Integer oldId, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Company company = companyDAO.findCompanyById(oldId);
		adminDAO.makeCompanyActive(company);
		
		return "redirect:index.do";
	}

}