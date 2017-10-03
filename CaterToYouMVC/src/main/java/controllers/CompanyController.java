package controllers;

import java.awt.event.ItemEvent;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import entity.Company;
import entity.Customer;
import entity.Employee;
import entity.Image;
import entity.Item;
import entity.Menu;
import entity.User;

@Controller
public class CompanyController {

	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(path = "UpdateMenuItem.do", method = RequestMethod.POST)
	public String index(Model model, @RequestParam("itemId") Integer id) {
		Item item = customerDAO.returnItemById(id);
		model.addAttribute("item", item);
		return "views/itemUpdate.jsp";
	}
	
	@RequestMapping(path = "editItem.do", method = RequestMethod.POST)
	public String itemEdit(@RequestParam("name") String name, @RequestParam("calories") Integer calories,
			@RequestParam("price") Double price, @RequestParam("description") String description, @RequestParam("availability") Integer availability,
			@RequestParam("imageURL") String imageURL, @RequestParam("oldItemId") Integer oldId, Model model, HttpSession session) {
		Item item = customerDAO.returnItemById(oldId);
		Item itemTemp = new Item();
		if (name==null) {
			itemTemp.setName(item.getName());
		}
		else {
			itemTemp.setName(name);
		}
		if (calories==null) {
			itemTemp.setCalories(item.getCalories());
		}
		else {
			itemTemp.setCalories(calories);
		}
		if (price==null) {
			itemTemp.setPrice(item.getPrice());
		}
		else {
			itemTemp.setPrice(price);
		}
		if (description==null) {
			itemTemp.setDescription(item.getDescription());
		}
		else {
			itemTemp.setDescription(description);
		}
		if (availability==null) {
			itemTemp.setAvailability(item.getAvailability());
		}
		else {
			itemTemp.setAvailability(availability);
		}
		if (imageURL==null) {
			itemTemp.setImage(item.getImage());
		}
		else {
			Image image = new Image();
			image.setImageUrl(imageURL);
			image = companyDAO.addImage(image);
			itemTemp.setImage(image);
		}
		itemTemp.setMenu(item.getMenu());
		companyDAO.makeMenuItemInactive(item);
		itemTemp = companyDAO.addItem(itemTemp);
		User user = (User) session.getAttribute("user");
		List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
		model.addAttribute("user",user);
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("company", user.getEmployee().getCompany());
		model.addAttribute("address", user.getEmployee().getCompany().getAddress());
		model.addAttribute("menu", menuItems);
		return "views/company.jsp";
	}

	@RequestMapping(path = "editCompany.do", method = RequestMethod.POST)
	public String customerEdit(@RequestParam("name") String name, @RequestParam("street") String street,
			@RequestParam("street2") String street2, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("zip") String zip,
			@RequestParam("imageURL") String imageURL,
			@RequestParam("oldItemId") Integer oldId, Model model, HttpSession session) {
		Company company = companyDAO.updateCompanyInfo(company);
		Company tempCompany = new Company();
		if (name == null) {
			itemTemp.setName(item.getName());
		} else {
			itemTemp.setName(name);
		}
		if (street == null) {
			itemTemp.setStreet(item.getStreet());
		} else {
			itemTemp.setStreet(street);
		}
		if (price == null) {
			itemTemp.setPrice(item.getPrice());
		} else {
			itemTemp.setPrice(price);
		}
		if (description == null) {
			itemTemp.setDescription(item.getDescription());
		} else {
			itemTemp.setDescription(description);
		}
		if (availability == null) {
			itemTemp.setAvailability(item.getAvailability());
		} else {
			itemTemp.setAvailability(availability);
		}
		if (imageURL == null) {
			itemTemp.setImage(item.getImage());
		} else {
			Image image = new Image();
			image.setImageUrl(imageURL);
			image = companyDAO.addImage(image);
			itemTemp.setImage(image);
		}
		itemTemp.setMenu(item.getMenu());
		companyDAO.makeMenuItemInactive(item);
		itemTemp = companyDAO.addItem(itemTemp);
		User user = (User) session.getAttribute("user");
		List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
		model.addAttribute("user",user);
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("company", user.getEmployee().getCompany());
		model.addAttribute("address", user.getEmployee().getCompany().getAddress());
		model.addAttribute("menu", menuItems);
		return "views/company.jsp";
	}
	@RequestMapping(path = "InactivateItem.do", method = RequestMethod.POST)
	public String inactivate(@RequestParam("oldItemId") Integer oldId, Model model, HttpSession session) {
		Item item = companyDAO.findItemById(oldId);
		companyDAO.makeMenuItemInactive(item);
		User user = (User) session.getAttribute("user");
		List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
		model.addAttribute("user", user);
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("company", user.getEmployee().getCompany());
		model.addAttribute("address", user.getEmployee().getCompany().getAddress());
		model.addAttribute("menu", menuItems);
		return "views/company.jsp";
	}
	@RequestMapping(path = "InactivateEmployee.do", method = RequestMethod.POST)
	public String inactivateEmp(@RequestParam("oldEmployeeId") Integer oldId, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getEmployee().getEmployeeID() != oldId) {
		Employee employee = companyDAO.findEmployeeById(oldId);
		companyDAO.makeEmployeeInactive(employee);}
		else {
			String error = "You can not make yourself inactive from this screen";
			model.addAttribute("message",error);
			
		}
		Company company = companyDAO.findCompanyById(user.getEmployee().getCompany().getId());
		model.addAttribute("user",user);
		model.addAttribute("company", company);
		model.addAttribute("address", user.getEmployee().getCompany().getAddress());
		model.addAttribute("users", companyDAO.findEmployeesByCompany(company));
		List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
		model.addAttribute("menu", menuItems);
		model.addAttribute("employee", user.getEmployee());
		
		
		return "views/company.jsp";
	}


	@RequestMapping(path = "updateCompanyProfile.do", method = RequestMethod.POST)
	public String userUpdate(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			model.addAttribute("address", user.getEmployee().getCompany().getAddress());
		}
		return "views/companyUpdate.jsp";
	}





}
