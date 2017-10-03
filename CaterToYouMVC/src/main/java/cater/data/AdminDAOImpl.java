package cater.data;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Company;
import entity.Customer;
import entity.Employee;
import entity.Image;
import entity.Item;
import entity.Menu;
import entity.User;
@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addItemToCart(Item i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQuantity(Item i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emptyCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItemFromCart(Item i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer updatePersonalInfo(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item returnItemToScreen(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company updateCompanyInfo(Company c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu updateMenuItem(Item i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu addMenuItem(Item i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu makeMenuItemInactive(Item i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee makeEmployeeInactive(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateImage(Image i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addImage(Image i) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<User> index() {
		String sql = "SELECT u FROM User u";
		return em.createQuery(sql, User.class).getResultList();
	}

}
