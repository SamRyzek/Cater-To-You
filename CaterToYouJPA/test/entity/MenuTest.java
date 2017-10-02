package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MenuTest {

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
		assertEquals(true,true);
	}
	
	@Test
	public void test_Menu_company_mapped() {
		Menu m = em.find(Menu.class, 1);
		assertEquals(" Illegal Pete's", m.getCompany().getName());
	}
	
	@Test
	public void test_Menu_itemList_mapped() {
		Menu m = em.find(Menu.class, 1);
		assertEquals(6, m.getItemList().size());
		assertEquals(1, m.getItemList().get(0).getId());
	}
	
}
