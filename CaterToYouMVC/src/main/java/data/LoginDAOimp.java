package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Company;
import entity.Customer;
import entity.Employee;
import entity.User;

@Repository 
@Transactional
public class LoginDAOimp implements LoginDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User returnUser(String userName, String password) {
		String sql = "SELECT u FROM User u WHERE u.username = :user AND u.password = :pass";
		User user = em.createQuery(sql, User.class).setParameter("user", userName)
				.setParameter("pass", password).getResultList().get(0);
		return user;
	}

	@Override
	public Company getCompany(User user) {
		String sql = "SELECT c FROM Company WHERE c.employeeList.id = :id";
		Company comp = em.createQuery(sql, Company.class).setParameter("id", user.getEmployee()
				.getEmployeeID()).getResultList().get(0);
		return comp;
	}

	@Override
	public Employee getEmployee(User user) {
		return em.find(Employee.class, user.getEmployee().getEmployeeID());
	}

	@Override
	public Customer getCustomer(User user) {
		return em.find(Customer.class, user.getCustomer().getId());
	}

	

}
