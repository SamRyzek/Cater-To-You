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
	public List<User> index() {
		String sql = "SELECT u FROM User u";
		return em.createQuery(sql, User.class).getResultList();
	}
	
	@Override
	public Company createCompany(Company company) {
		em.persist(company);
		return company;
	}

	@Override
	public Menu createMenu() {
		Menu menu = new Menu();
		em.persist(menu);
		return menu;
	}

	

	@Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public Company makeCompanyInactive(Company c) {
		Company company = em.find(Company.class, c.getId());
		company.setActive(0);
		return company;
	}
	@Override
	public Company makeCompanyActive(Company c) {
		Company company = em.find(Company.class, c.getId());
		company.setActive(1);
		return company;
	}

	
}
