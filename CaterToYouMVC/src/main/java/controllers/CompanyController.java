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
	@Autowired
	private AdminDAO adminDAO;

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

	@RequestMapping(path = "CreateEmployee.do", method = RequestMethod.GET)
	public String createEmployee(Model model, @RequestParam("companyId") Integer id) {
		Company compTemp = companyDAO.findCompanyById(id);
		model.addAttribute("company", compTemp);
		return "views/createEmployee.jsp";
	}

	@RequestMapping(path = "CreateItem.do", method = RequestMethod.GET)
	public String createItem(Model model, @RequestParam("companyId") Integer id) {
		Company compTemp = companyDAO.findCompanyById(id);
		model.addAttribute("company", compTemp);
		return "views/createItem.jsp";
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
		if (imageURL != "") {
			compTemp.setImage(comp.getImage());
			compTemp.getImage().setImageUrl(imageURL);
		}
		compTemp = companyDAO.updateCompanyInfo(compTemp);

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

		return "redirect:index.do";
	}

	@RequestMapping(path = "InactivateItem.do", method = RequestMethod.POST)
	public String inactivate(@RequestParam("oldItemId") Integer oldId, Model model, HttpSession session) {
		Item item = companyDAO.findItemById(oldId);
		companyDAO.makeMenuItemInactive(item);

		return "redirect:index.do";
	}

	@RequestMapping(path = "InactivateEmployee.do", method = RequestMethod.POST)
	public String inactivateEmp(@RequestParam("oldId") Integer oldId, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getEmployee().getEmployeeID() != oldId) {
			Employee employee = companyDAO.findEmployeeById(oldId);
			companyDAO.makeEmployeeInactive(employee);
		}

		return "redirect:index.do";
	}

	@RequestMapping(path = "ActivateEmployee.do", method = RequestMethod.POST)
	public String activateEmp(@RequestParam("inactiveId") Integer id, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getEmployee().getEmployeeID() != id) {
			Employee employee = companyDAO.findEmployeeById(id);
			companyDAO.makeEmployeeActive(employee);
		}
		return "redirect:index.do";
	}

	@RequestMapping(path = "updateCompanyProfile.do", method = RequestMethod.GET)
	public String userUpdate(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			Company company = companyDAO.findCompanyById(user.getEmployee().getCompany().getId());
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

	@RequestMapping(path = "MakeEmployee.do", method = RequestMethod.POST)
	public String makeEmployee(@RequestParam("fName") String fName, @RequestParam("lName") String lName,
			@RequestParam("email") String email, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("companyId") int companyId, Model model,
			HttpSession session) {
		Company comp = companyDAO.findCompanyById(companyId);
		User userTemp = new User();
		Employee empTemp = new Employee();

		if (fName == null) {
			return "views/createEmployee.jsp";
		} else {
			userTemp.setFirstName(fName);
		}
		if (lName == null) {
			return "views/createEmployee.jsp";
		} else {
			userTemp.setLastName(lName);
		}
		if (username == null) {
			return "views/createEmployee.jsp";
		} else {
			userTemp.setUsername(username);
		}
		if (email == null) {
			return "views/createEmployee.jsp";
		} else {
			userTemp.setEmail(email);
		}
		if (password == null) {
			return "views/createEmployee.jsp";
		} else {
			userTemp.setPassword(password);
		}
		userTemp = companyDAO.createUserWithEmployeeRole(userTemp);
		empTemp.setActive(1);
		empTemp.setUser(userTemp);
		empTemp.setCompany(comp);
		empTemp = companyDAO.createEmployee(empTemp);

		return "redirect:index.do";
	}

	@RequestMapping(path = "MakeItem.do", method = RequestMethod.POST)
	public String MakeItem(@RequestParam("name") String name, @RequestParam("calories") Integer calories,
			@RequestParam("price") Double price, @RequestParam("description") String description,
			@RequestParam("availability") Integer availability, @RequestParam("imageURL") String imageURL, @RequestParam("companyID") int companyID,Model model,
			HttpSession session) {
		Company comp = companyDAO.findCompanyById(companyID);
		Item itemTemp = new Item();
		if (name == null) {
			return "createItem.do";
		} else {
			itemTemp.setName(name);
		}
		if (calories == null) {
			return "createItem.do";
		} else {
			itemTemp.setCalories(calories);
		}
		if (price == null) {
			return "createItem.do";
		} else {
			itemTemp.setPrice(price);
		}
		if (description == null) {
			return "createItem.do";
		} else {
			itemTemp.setDescription(description);
		}
		if (availability == null) {
			return "createItem.do";
		} else {
			itemTemp.setAvailability(availability);
		}
		if (imageURL == null) {
		} else {
			Image image = new Image();
			image.setImageUrl(imageURL);
			image = companyDAO.addImage(image);
			itemTemp.setImage(image);
		}
		itemTemp.setMenu(comp.getMenu());
		itemTemp = companyDAO.addItem(itemTemp);

		return "redirect:index.do";
	}

}
