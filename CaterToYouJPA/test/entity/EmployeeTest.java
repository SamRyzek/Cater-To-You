package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

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
	public void test_Employee_user_mapped() {
		Employee e = em.find(Employee.class, 4);
		assertEquals(4, e.getUser().getId());
	}
	
	@Test
	public void test_Employee_company_mapped() {
		Employee e = em.find(Employee.class, 4);
		assertEquals(2, e.getCompany().getId());
	}
}
