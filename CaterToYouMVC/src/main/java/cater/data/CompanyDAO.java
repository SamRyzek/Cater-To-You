package cater.data;

import javax.servlet.http.HttpSession;

import entity.Company;
import entity.Employee;
import entity.Image;
import entity.Item;
import entity.Menu;

public interface CompanyDAO {
	
	
	
	public Company updateCompanyInfo(Company c, int id);
	
	public Menu updateMenuItem(Item i); 
	public Menu addMenuItem(Item i); 
	public Menu makeMenuItemInactive(Item i); 
	
	public Employee updateEmployee(Employee e);
	public Employee addEmployee(Employee e);
	public Employee makeEmployeeInactive(Employee e);
	
	public void updateImage(Image i); //could be a url for String even
	public void addImage(Image i); //could be a url for String even
	
	

	
	
//	we arent going to be adding or deleting menus, only affecting items within
	
	
	
//	need shit that takes in this shit
//	company object
//	menu object
//	employee object

}
