package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

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
	public void test_Order_total_mapped() {
		Order o = em.find(Order.class, 1);
		assertEquals(73, o.getTotal());
	}

	@Test
	public void test_Order_customer_mapped() {
		Order o = em.find(Order.class, 1);
		assertEquals(2, o.getCustomer().getId());
	}

	@Test
	public void test_Order_deliveryDateTime_mapped() {
		Order o = em.find(Order.class, 1);
		assertEquals("2017-09-26 11:58:00.0", o.getDeliveryDateTime().toString());
	}

	@Test
	public void test_Order_address_mapped() {
		Order o = em.find(Order.class, 1);
		assertEquals(7, o.getAddress().getId());
	}

	@Test
	public void test_Order_orderHasItemsList_mapped() {
		Order o = em.find(Order.class, 1);
		assertEquals(2, o.getOrderHasItemsList().size());
		assertEquals(1, o.getOrderHasItemsList().get(0).getId());
	}
}
