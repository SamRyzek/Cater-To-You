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
import entity.Address;
import entity.Company;
import entity.Employee;
import entity.Image;
import entity.Item;
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
	@RequestMapping(path = "UpdateStaff.do", method = RequestMethod.POST)
	public String find(Model model, @RequestParam("staffId") Integer id) {
		User user = companyDAO.findUserById(id);
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("user", user);
		return "views/employeeUpdate.jsp";
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
	public String customerEdit(@RequestParam("name") String name, @RequestParam("Address") Address address,
			@RequestParam("imageURL") String imageURL,
			@RequestParam("oldItemId") Integer oldId, Model model, HttpSession session) {
		Company company = new Company();
		company = companyDAO.updateCompanyInfo(company);
		Company tempCompany = new Company();
		if (name == null) {
			tempCompany.setName(company.getName());
		} else {
			tempCompany.setName(name);
		}
		if (address == null) {
			tempCompany.setAddress(company.getAddress());
		} else {
			tempCompany.setAddress(address);
		}
		if (imageURL == null) {
			tempCompany.setImage(company.getImage());
		} else {
			Image image = new Image();
			image.setImageUrl(imageURL);
			image = companyDAO.addImage(image);
			tempCompany.setImage(image);
		}

		User user = (User) session.getAttribute("user");
		model.addAttribute("company", user.getEmployee().getCompany());
		model.addAttribute("address", user.getEmployee().getCompany().getAddress());
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
	public String inactivateEmp(@RequestParam("oldId") Integer oldId, Model model, HttpSession session) {
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
		model.addAttribute("users", companyDAO.findUserEmployeesByCompany(company));
		List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
		model.addAttribute("menu", menuItems);
		model.addAttribute("employee", user.getEmployee());
		String removed = " can not make yourself inactive from this screen";
		model.addAttribute("message", removed);
		
		return "views/company.jsp";
	}
	
	@RequestMapping(path = "updateCompanyProfile.do", method = RequestMethod.POST)
	public String userUpdate(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			Company company = companyDAO.findCompanyById(user.getEmployee().getCompany().getId());
			model.addAttribute("user",user);
			model.addAttribute("company", company);
			model.addAttribute("address", user.getEmployee().getCompany().getAddress());
			model.addAttribute("staff", companyDAO.findUserEmployeesByCompany(company));
			List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
			model.addAttribute("menu", menuItems);
			model.addAttribute("employee", user.getEmployee());
			model.addAttribute("image", user.getEmployee().getCompany().getImage());
	
		}
		return "views/companyUpdate.jsp";
	}





}
