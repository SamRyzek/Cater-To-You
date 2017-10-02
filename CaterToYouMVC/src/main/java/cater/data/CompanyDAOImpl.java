package cater.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Company;
import entity.Employee;
import entity.Image;
import entity.Item;
import entity.Menu;

@Repository
@Transactional
public class CompanyDAOImpl implements CompanyDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Company updateCompanyInfo(Company company, int id) {
	
		Company c = em.find(Company.class, id);
		
		if(c != null)
		
		{
			
			c.setAddress(company.getAddress());
			c.setImage(company.getImage());
			c.setName(company.getName());
			
		}

		em.close();
		return c;
	}

	@Override //session will give us the menu
	public Item updateMenuItem(Item i) {
		
		Item item = em.find(Item.class, 0);
		
		if(item != null) {
			
			item.setAvailability(i.getAvailability());
			item.setCalories(i.getCalories());
			item.setDescription(i.getDescription());
			item.setPrice(i.getPrice());
			item.setImage(i.getImage());
			item.setName(i.getName());
			
		}
		
		return item;
	}

	@Override
	public Item addMenuItem(Item i) {
		
		
		
		
		
		return null;
	}

	@Override
	public Item makeMenuItemInactive(Item i) {
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
	public List<Company> index() {
			String sql = "SELECT c FROM Company c";
			return em.createQuery(sql, Company.class).getResultList();
	}}



@Override
public List<Item> showMenu(id){
	String sql = "SELECT i FROM item i where i.menu.company.id = :id ";
	List<Item> menuItems = em.createQuery(sql, Menu.class).setParameter("id", id).getResultList;
	return menuItems;
}
@Override
public List<Order> findOrderHistory(id){
	String query = "SELECT i FROM item i where i.menu.company.id = :id ";
	List<Item> menuItems = em.createQuery(sql, Menu.class).setParameter("id", id).getResultList;
	return menuItems;
}


	
	
	
	
	
	
	
