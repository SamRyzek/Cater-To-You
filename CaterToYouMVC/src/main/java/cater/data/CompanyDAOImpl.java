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
	public Menu updateMenuItem(Item i) {
		
		
		
		return null;
	}

	@Override
	public Menu addMenuItem(Item i) {
		
		
		
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
	public List<Company> index() {
			String sql = "SELECT c FROM Company c";
			return em.createQuery(sql, Company.class).getResultList();
	}

	@Override
	public Company findCompanyById(int id) {
		String sql = "SELECT c FROM Company c where c.id= :id";
		
		return em.createQuery(sql, Company.class).setParameter("id", id).getResultList().get(0);
	
	}}




	
	
	
	
	
	
	
