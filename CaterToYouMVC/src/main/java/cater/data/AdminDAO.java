package cater.data;

import java.util.List;

import entity.Company;
import entity.Customer;
import entity.Employee;
import entity.Image;
import entity.Item;
import entity.Menu;
import entity.User;

public interface AdminDAO {
	
	//Admin Shit
	
	//not sure if the admin stuff is going to be done in the controller vs the logic because the differentiator is the access privleges
	//the jsp page is gonna check for the user type, and based on that different data on the jsp will be displayed
	

	//**********************************************************
	//Customer shit
	// add item to cart
	public void addItemToCart(Item i);

	// update cart
	public void updateQuantity(Item i);

	// checkout cart
	// need to include functionality to update order history
	// may need to take in customer cart
	public void emptyCart();
	

	// delete item from cart
	public void removeItemFromCart(Item i);

	// enter shipping address

	// update personal information, and when we create a customer object he'll
	// automatically have all null shit, therefore we don't need an add customer
	// information
	public Customer updatePersonalInfo(Customer c);

	public Item returnItemToScreen(String title); // take in the title of the item off a drop down, go pull it out of
													// the db, and return it back to the controller, it gets put on a
													// jsp for the customer

	
	//***************************************************************
	//Company shit
	
	
	public Company updateCompanyInfo(Company c);
	
	public Menu updateMenuItem(Item i); 
	public Menu addMenuItem(Item i); 
	public Menu makeMenuItemInactive(Item i); 
	
	public Employee updateEmployee(Employee e);
	public Employee addEmployee(Employee e);
	public Employee makeEmployeeInactive(Employee e);
	
	public void updateImage(Image i); //could be a url for String even
	public void addImage(Image i); //could be a url for String even
	
	public List<User> index();

}
