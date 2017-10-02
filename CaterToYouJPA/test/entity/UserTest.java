package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("CaterToYou");
		em = emf.createEntityManager();
	}

	@After
	public void tearDown() {
		em.close();
		emf.close();
	}

	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_user_firstName_mapped() {
		User user = em.find(User.class, 1);
		assertEquals("James", user.getFirstName());
	}
	
	@Test
	public void test_user_lastName_mapped() {
		User user = em.find(User.class, 1);
		assertEquals("Gato", user.getLastName());
	}
	
	@Test
	public void test_user_userName_mapped() {
		User user = em.find(User.class, 1);
		assertEquals("jGato", user.getUsername());
	}
	
	@Test
	public void test_user_password_mapped() {
		User user = em.find(User.class, 1);
		assertEquals("password1", user.getPassword());
	}
	
	@Test
	public void test_user_email_mapped() {
		User user = em.find(User.class, 1);
		assertEquals("jgato@gmail.com", user.getEmail());
	}
	@Test
	public void test_user_customer_mapped() {
		User user = em.find(User.class, 13);
		assertEquals(1, user.getCustomer().getId());
	}
	@Test
	public void test_user_employee_mapped() {
		User user = em.find(User.class, 1);
		assertEquals(1, user.getEmployee().getEmployeeID());
	}
	
	@Test
	public void test_uset_userroles_mapped() {
		User user = em.find(User.class, 1);
		assertEquals(2, user.getUserRoles().getId());
	}
}
