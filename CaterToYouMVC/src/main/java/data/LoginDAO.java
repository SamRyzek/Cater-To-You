package data;

import entity.Company;
import entity.Customer;
import entity.Employee;
import entity.User;

public interface LoginDAO {
	public User returnUser(String userName, String password);
	public Company getCompany(User user);
	public Employee getEmployee(User user);
	public Customer getCustomer(User user);
}
