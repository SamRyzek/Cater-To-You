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
	
	
	public void addItemToCart(Item i);

	
	public void updateQuantity(Item i);

	public void emptyCart();
	


	public void removeItemFromCart(Item i);

	
	public Customer updatePersonalInfo(Customer c);

	public Item returnItemToScreen(String title); 
	
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
	public Company createCompany(Company company);
	
	public User createUser(User user);

	public Menu createMenu();
}
