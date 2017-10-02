package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompanyTest {
	
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
	public void test_company_name_mapped() {
		Company c = em.find(Company.class, 1);
		assertEquals(" Illegal Pete's", c.getName());
	}
	
	@Test
	public void test_company_menu_mapped() {
		Company c = em.find(Company.class, 1);
		assertEquals(1, c.getMenu().getId());
	}
	
	@Test
	public void test_company_address_mapped() {
		Company c = em.find(Company.class, 1);
		assertEquals(1, c.getAddress().getId());
		
	}
	
	@Test
	public void test_company_image_mapped() {
		Company c = em.find(Company.class, 1);
		assertEquals(1, c.getImage().getId());
		
	}
	
	@Test
	public void test_company_employeeList_mapped() {
		Company c = em.find(Company.class, 1);
		assertEquals(3, c.getEmployeeList().size());
		assertEquals(" James", c.getEmployeeList().get(0).getUser().getFirstName());
		
	}
}
