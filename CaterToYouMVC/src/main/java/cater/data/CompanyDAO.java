package cater.data;

import java.util.List;

import entity.Company;
import entity.Employee;
import entity.Image;
import entity.Item;
import entity.Menu;
import entity.User;

public interface CompanyDAO {
	
	
	
	public Company findCompanyById(int id);
	public Company updateCompanyInfo(Company c);
	public List<Company> index();
	
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
	
	
	

}
