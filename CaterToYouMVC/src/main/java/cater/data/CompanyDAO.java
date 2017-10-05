package cater.data;

import java.util.List;

import entity.Address;
import entity.Company;
import entity.Customer;
import entity.Employee;
import entity.Image;
import entity.Item;
import entity.Menu;
import entity.Order;
import entity.OrderHasItems;
import entity.User;

public interface CompanyDAO {
	
	
	
	public Company findCompanyById(int id);
	public Company updateCompanyInfo(Company c);
	public List<Company> index();
	public List<Company> indexActive();
	public List<Company> indexInactive();
	
	public List<OrderHasItems> findOrderHavesByCompany(Company company, Order order);
	public Order findOrderByOrderId(int id);
	public List<Order> findOrdersByCompany(Company company);
	
	public Menu addMenuItem(Item i, Menu menu); 
	public Menu makeMenuItemInactive(Item i); 
	
	public Employee findEmployeeById(int id);
	public Employee updateEmployee(Employee e);
	public Employee addEmployee(Employee e);
	
	
	public void makeEmployeeInactive(Employee e);
	public void makeEmployeeActive(Employee e);
	
	public List<User> findUserEmployeesByCompany(Company c);
	public List<User> findInactiveUserEmployeesByCompany(Company c);
	
	public User findUserById(int id);
	public User editUser(User user);
	
	public void updateImage(Image i);
	
	public Image addImage(Image i); 
	
	public Item addItem(Item i);
	public Item findItemById(int id);
	public Address createAddress(Address address);
	public Address findAddressByAddressId(int id);
	public Employee createEmployee(Employee employee);
	public User createUserWithEmployeeRole(User user);
	
	
	

}
