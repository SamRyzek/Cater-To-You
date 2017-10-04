package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartTest {
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
	public void test_cart_cartHasItemList_mapped() {
		Cart c = em.find(Cart.class, 1);
		assertEquals(3, c.getCartHasItemList().size());
		assertEquals(1, c.getCartHasItemList().get(0).getCount());
	}
	
	@Test
	public void test_cart_customer_mapped() {
		Cart c = em.find(Cart.class, 1);
		assertEquals("Sara", c.getCustomer().getUser().getFirstName());
	}
}
