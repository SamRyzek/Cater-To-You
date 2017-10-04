package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {


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
	public void test_Category_category_mapped() {
		Category cat = em.find(Category.class, 1);
		assertEquals("BBQ", cat.getCategory());
	}
	
	@Test 
	public void test_Category_itemList_mapped() {
		Category cat = em.find(Category.class, 1);
		assertEquals(7, cat.getItemList().size());
		assertEquals("You're telling me you don't know what burnt ends are?", cat.getItemList().get(4).getDescription());
	}

}
