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
	
	

	public List<User> index();
	public Company createCompany(Company company);
	
	public User createUser(User user);

	public Menu createMenu();

	public Company makeCompanyActive(Company c);

	public Company makeCompanyInactive(Company company);
}
