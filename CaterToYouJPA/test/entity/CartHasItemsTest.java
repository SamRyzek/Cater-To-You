package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartHasItemsTest {

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
	public void test_cartHasItems_count_mapped() {
		CartHasItem chi = em.find(CartHasItem.class, 7);
		assertEquals(22, chi.getCount());
	}

	@Test
	public void test_cartHasItems_Item_mapped() {
		CartHasItem chi = em.find(CartHasItem.class, 7);
		assertEquals(6, chi.getItem().getId());
	}

	@Test
	public void test_cartHasItems_cart_mapped() {
		CartHasItem chi = em.find(CartHasItem.class, 7);
		assertEquals(3, chi.getCart().getId());
	}
}
