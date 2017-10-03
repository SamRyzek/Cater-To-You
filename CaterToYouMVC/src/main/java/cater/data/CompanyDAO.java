package cater.data;

import java.util.List;

import entity.Company;
import entity.Employee;
import entity.Image;
import entity.Item;
import entity.Menu;

public interface CompanyDAO {
	
	
	
	public Company findCompanyById(int id);
	public Company updateCompanyInfo(Company c);
	
//	public Menu updateMenuItem(Menu m); 
	public Menu addMenuItem(Item i, Menu menu); 
	public Menu makeMenuItemInactive(Item i); 
	
	public Employee findEmployeeById(int id);
	public Employee updateEmployee(Employee e);
	public Employee addEmployee(Employee e);
	public void makeEmployeeInactive(Employee e);
	public List<Employee> findEmployeesByCompany(Company c);
	
	public void updateImage(Image i); //could be a url for String even
	public Image addImage(Image i); //could be a url for String even

	public Item addItem(Item i);
	public Item findItemById(int id);
	
	public List<Company> index();
	

}
