package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImageTest {
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
	public void test_Image_url_mapped() {
		Image im = em.find(Image.class, 1);
		assertEquals("http://illegalpetes.com/wp-content/uploads/2015/06/logo-home.png", im.getImageUrl());
	}
	
	@Test
	public void test_Image_companyList_mapped() {
		Image im = em.find(Image.class, 1);
		assertEquals(1, im.getCompanyList().size());
		assertEquals(1, im.getCompanyList().get(0).getId());
	}
	
	@Test
	public void test_Image_customerList_mapped() {
		Image im = em.find(Image.class, 6);
		assertEquals(1, im.getCustomerList().size());
		assertEquals(1, im.getCustomerList().get(0).getId());
	}
	
	@Test
	public void test_Image_itemList_mapped() {
		Image im = em.find(Image.class, 13);
		assertEquals(1, im.getItemList().size());
		assertEquals(1, im.getItemList().get(0).getId());
	}
}
