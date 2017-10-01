package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
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
	public void test_Customer_user_mapped() {
		Customer c = em.find(Customer.class, 1);
		assertEquals(13, c.getUser().getId());
	}
	
	@Test
	public void test_Customer_cart_mapped() {
		Customer c = em.find(Customer.class, 1);
		assertEquals(1, c.getCart().getId());
	}
	
	@Test
	public void test_Customer_image_mapped() {
		Customer c = em.find(Customer.class, 1);
		assertEquals(6, c.getImage().getId());
	}
	
	@Test
	public void test_Customer_address_mapped() {
		Customer c = em.find(Customer.class, 1);
		assertEquals(6, c.getAddress().getId());
	}
	
	@Test
	public void test_Customer_orderList_mapped() {
		Customer c = em.find(Customer.class, 1);
		assertEquals(1, c.getOrderList().size());
		assertEquals(4, c.getOrderList().get(0).getId());
	}
}
