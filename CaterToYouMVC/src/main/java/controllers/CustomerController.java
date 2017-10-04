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
import entity.Cart;
import entity.Company;
import entity.Customer;
import entity.Item;
import entity.Order;
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
	
	@RequestMapping(path="newUser.do", method=RequestMethod.POST)
	public String newUser(Model model, HttpSession session, User user) {
		customerDAO.createUser(user);
		String message = "New user has been created successfully.";
		
		return "redirect:actionSuccessful.do?message=" + message; 
	}
	
	@RequestMapping(path="actionSuccessful.do", method=RequestMethod.GET)
	public String displayActionSuccessful(Model model, HttpSession session, String message) {
		model.addAttribute("message", message);
		return "views/actionSuccessful.jsp";
	}
	

	@RequestMapping(path = "ShopHere.do", method = RequestMethod.GET)
	public String show(@RequestParam("companyId") Integer id, Model model) {
		List<Item> menuItems = customerDAO.showMenu(id);
		Company company = companyDAO.findCompanyById(id);
		model.addAttribute("menu", menuItems);
		model.addAttribute("company", company);
		model.addAttribute("address", company.getAddress());
		return "views/menu.jsp";
	}

	@RequestMapping(path = "addToCart.do", method = RequestMethod.POST)
	public String addItemToCart(@RequestParam("itemId") Integer id, @RequestParam("quantity") int count,
			@RequestParam("company") int companyId, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (count > 0) {
			customerDAO.addItemToCart(id, customer.getCart(), count);
		}
		return "redirect:ShopHere.do?companyId=" + companyId;
	}

	@RequestMapping(path = "OrderHistory.do", method = RequestMethod.GET)
	public String showHistory(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		List<Order> orderHistory = customerDAO.returnOrdersForCustomer(customer);
		model.addAttribute("orders", orderHistory);
		return "views/orderHistory.jsp";
	}

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
		User user = (User) session.getAttribute("user");
		
		customer.getAddress().setCity(input.getCity());
		customer.getAddress().setState(input.getState());
		customer.getAddress().setStreet(input.getStreet());
		customer.getAddress().setStreet2(input.getStreet2());
		customer.getAddress().setZip(Integer.parseInt(input.getZip()));
		customer.setAddress(customerDAO.updateAddress(customer.getAddress()));
		
		user.setEmail(input.getEmail());
		user = customerDAO.updateEmail(user);
		
		session.setAttribute("user", user);
		session.setAttribute("customer", customer);
		model.addAttribute("customer", customer);
		model.addAttribute("address", customer.getAddress());
		model.addAttribute("user", user);
		return "redirect:customer.do";
	}

	@RequestMapping("showCart.do")
	public String showCart(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		Cart cart = customerDAO.showCartWithAllItems(customer);
		double subTotal = customerDAO.calculateCartTotal(cart);
		model.addAttribute("subTotal", decimalFormatting(subTotal));
		model.addAttribute("fee", decimalFormatting(subTotal * 0.1));
		model.addAttribute("tax", decimalFormatting(subTotal * 0.075));
		double total = (subTotal * 0.1) + (subTotal * 0.075) + subTotal;
		model.addAttribute("total", decimalFormatting(total));
		if (cart != null) {
			model.addAttribute("itemList", cart.getCartHasItemList());
		}
		model.addAttribute("cart", cart);
		return "views/cart.jsp";
	}

	private double decimalFormatting(double num) {
		return Math.round(num * 100) / 100.00;
	}

	@RequestMapping(path = "removeItem.do", method = RequestMethod.POST)
	public String removeItemFromCart(@RequestParam("itemId") int itemId, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		customerDAO.removeItemFromCart(itemId, customer.getCart());
		return "redirect:showCart.do";
	}
	
	@RequestMapping(path = "changeQuantity.do", method = RequestMethod.POST)
	public String updateQuantity(@RequestParam("itemId") int id, @RequestParam("count") int count) {
		customerDAO.updateQuantityInCart(id, count);
		return "redirect:showCart.do";
	}
	
	@RequestMapping("checkout.do")
	public String showCheckout(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		Cart cart = customerDAO.showCartWithAllItems(customer);
		double subTotal = customerDAO.calculateCartTotal(cart);
		model.addAttribute("subTotal", decimalFormatting(subTotal));
		model.addAttribute("fee", decimalFormatting(subTotal * 0.1));
		model.addAttribute("tax", decimalFormatting(subTotal * 0.075));
		double total = (subTotal * 0.1) + (subTotal * 0.075) + subTotal;
		model.addAttribute("total", decimalFormatting(total));
		model.addAttribute("itemList", cart.getCartHasItemList());
		model.addAttribute("cart", cart);
		return "views/checkout.jsp";
	}
	
	@RequestMapping(path="createOrder.do", method = RequestMethod.POST)
	public String createOrder(@RequestParam("date") String date,
							@RequestParam("time") String time,
							@RequestParam("cartId") int id, 
							@RequestParam("street") String street,
							@RequestParam("street2") String street2, 
							@RequestParam("city") String city,
							@RequestParam("state") String state,
							@RequestParam("zip") int zip) { 
		Address address = new Address();
		address.setStreet(street);
		address.setStreet2(street2);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		customerDAO.checkoutEmptiesCartMovesToOrder(id, address, time, date);
		
		String message ="Your order has been placed.";
		return "redirect:actionSuccessful.do?message=" + message;
	}

}