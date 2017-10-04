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

	@RequestMapping(path = "editCompany.do", method = RequestMethod.POST)
	public String userEdit(@RequestParam("id") int id, @RequestParam("addId") int addId,
			@RequestParam("name") String name, @RequestParam("street") String street,
			@RequestParam("street2") String street2, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("zip") int zip, @RequestParam("url") String imageURL,
			Model model, HttpSession session) {
		Company comp = companyDAO.findCompanyById(id);
		Company compTemp = new Company();
		Address add = comp.getAddress();
		Address addTemp = new Address();
		if (name == null) {
			compTemp.setName(comp.getName());
		} else {
			compTemp.setName(name);
		}
		if (street == null) {
			addTemp.setStreet(add.getStreet());
		} else {
			addTemp.setStreet(street);
		}
		if (street2 == null) {
			addTemp.setStreet2(add.getStreet2());
		} else {
			addTemp.setStreet2(street2);
		}
		if (city == null) {
			addTemp.setCity(add.getCity());
		} else {
			addTemp.setCity(city);
		}
		if (state == null) {
			addTemp.setState(add.getState());
		} else {
			addTemp.setState(state);
		}
		if (zip == ' ') {
			addTemp.setZip(add.getZip());
		} else {
			addTemp.setZip(zip);
		}
		if (imageURL == " ") {
			imageURL = comp.getImage().getImageUrl();
		} 

		
		addTemp.setId(addId);
		addTemp = customerDAO.updateAddress(addTemp);
		compTemp.setAddress(addTemp);
		compTemp.setId(id);
		compTemp.setImage(comp.getImage());
		compTemp.getImage().setImageUrl(imageURL);
		compTemp = companyDAO.updateCompanyInfo(compTemp);
		User activeUser = (User) session.getAttribute("user");
		List<Item> menuItems = customerDAO.showMenu(activeUser.getEmployee().getCompany().getId());
		model.addAttribute("user", activeUser);
		model.addAttribute("employee", activeUser.getEmployee());
		model.addAttribute("company", activeUser.getEmployee().getCompany());
		model.addAttribute("address", activeUser.getEmployee().getCompany().getAddress());
		model.addAttribute("menu", menuItems);
		return "redirect:index.do";
	}

	@RequestMapping(path = "editUser.do", method = RequestMethod.POST)
	public String userEdit(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName,
			@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("email") String email, @RequestParam("id") int id, Model model, HttpSession session) {
		User user = companyDAO.findUserById(id);
		User userTemp = new User();
		if (fName == null) {
			userTemp.setFirstName(user.getFirstName());
		} else {
			userTemp.setFirstName(fName);
		}
		if (lName == null) {
			userTemp.setLastName(user.getLastName());
		} else {
			userTemp.setLastName(lName);
		}
		if (username == null) {
			userTemp.setUsername(user.getUsername());
		} else {
			userTemp.setUsername(username);
		}
		if (password == null) {
			userTemp.setPassword(user.getPassword());
		} else {
			userTemp.setPassword(password);
		}
		if (email == null) {
			userTemp.setEmail(user.getEmail());
		} else {
			userTemp.setEmail(email);
		}
		userTemp.setId(id);
		userTemp = companyDAO.editUser(userTemp);
		User activeUser = (User) session.getAttribute("user");
		List<Item> menuItems = customerDAO.showMenu(activeUser.getEmployee().getCompany().getId());
		model.addAttribute("user", activeUser);
		model.addAttribute("employee", activeUser.getEmployee());
		model.addAttribute("company", activeUser.getEmployee().getCompany());
		model.addAttribute("address", activeUser.getEmployee().getCompany().getAddress());
		model.addAttribute("menu", menuItems);
		return "redirect:index.do";
	}

	@RequestMapping(path = "editItem.do", method = RequestMethod.POST)
	public String itemEdit(@RequestParam("name") String name, @RequestParam("calories") Integer calories,
			@RequestParam("price") Double price, @RequestParam("description") String description,
			@RequestParam("availability") Integer availability, @RequestParam("imageURL") String imageURL,
			@RequestParam("oldItemId") Integer oldId, Model model, HttpSession session) {
		Item item = customerDAO.returnItemById(oldId);
		Item itemTemp = new Item();
		if (name == null) {
			itemTemp.setName(item.getName());
		} else {
			itemTemp.setName(name);
		}
		if (calories == null) {
			itemTemp.setCalories(item.getCalories());
		} else {
			itemTemp.setCalories(calories);
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
		model.addAttribute("user", user);
		model.addAttribute("employee", user.getEmployee());
		model.addAttribute("company", user.getEmployee().getCompany());
		model.addAttribute("address", user.getEmployee().getCompany().getAddress());
		model.addAttribute("menu", menuItems);
		return "redirect:index.do";
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
		return "redirect:index.do";
	}

	@RequestMapping(path = "InactivateEmployee.do", method = RequestMethod.POST)
	public String inactivateEmp(@RequestParam("oldId") Integer oldId, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getEmployee().getEmployeeID() != oldId) {
			Employee employee = companyDAO.findEmployeeById(oldId);
			companyDAO.makeEmployeeInactive(employee);
		} else {
			String error = "You can not make yourself inactive from this screen";
			model.addAttribute("message", error);

		}
		Company company = companyDAO.findCompanyById(user.getEmployee().getCompany().getId());
		model.addAttribute("user", user);
		model.addAttribute("company", company);
		model.addAttribute("address", user.getEmployee().getCompany().getAddress());
		model.addAttribute("users", companyDAO.findUserEmployeesByCompany(company));
		List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
		model.addAttribute("menu", menuItems);
		model.addAttribute("employee", user.getEmployee());
		String removed = " can not make yourself inactive from this screen";
		model.addAttribute("message", removed);

		return "redirect:index.do";
	}

	@RequestMapping(path = "ActivateEmployee.do", method = RequestMethod.POST)
	public String activateEmp(@RequestParam("inactiveId") Integer id, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getEmployee().getEmployeeID() != id) {
		Employee employee = companyDAO.findEmployeeById(id);
		companyDAO.makeEmployeeActive(employee);}
		else {
			String error = "You can not make yourself inactive from this screen";
			model.addAttribute("message", error);

		}
		Company company = companyDAO.findCompanyById(user.getEmployee().getCompany().getId());
		model.addAttribute("user", user);
		model.addAttribute("company", company);
		model.addAttribute("address", user.getEmployee().getCompany().getAddress());
		model.addAttribute("users", companyDAO.findUserEmployeesByCompany(company));
		List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
		model.addAttribute("menu", menuItems);
		model.addAttribute("employee", user.getEmployee());
		String removed = " can not make yourself inactive from this screen";
		model.addAttribute("message", removed);

		return "redirect:index.do";
	}

	@RequestMapping(path = "updateCompanyProfile.do", method = RequestMethod.POST)
	public String userUpdate(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			Company company = companyDAO.findCompanyById(user.getEmployee().getCompany().getId());
			model.addAttribute("user", user);
			model.addAttribute("company", company);
			model.addAttribute("address", user.getEmployee().getCompany().getAddress());
			model.addAttribute("staff", companyDAO.findUserEmployeesByCompany(company));
			model.addAttribute("inactiveStaff", companyDAO.findInactiveUserEmployeesByCompany(company));
			List<Item> menuItems = customerDAO.showMenu(user.getEmployee().getCompany().getId());
			model.addAttribute("menu", menuItems);
			model.addAttribute("employee", user.getEmployee());
			model.addAttribute("image", user.getEmployee().getCompany().getImage());

		}
		return "views/companyUpdate.jsp";
	}

}
