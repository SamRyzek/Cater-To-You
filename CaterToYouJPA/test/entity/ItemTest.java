package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {


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
	public void test_Item_name_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(" Grilled Chicken Tacos", i.getName());
	}
	
	@Test
	public void test_Item_calories_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(500, i.getCalories());
	}
	
	@Test
	public void test_Item_description_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(" Just your basic chicken tacos", i.getDescription());
	}
	
	@Test
	public void test_Item_price_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(7.29, i.getPrice(), .001);
	}
	
	@Test
	public void test_Item_availability_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(1000, i.getAvailability());
	}
	
	@Test
	public void test_Item_menu_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(1, i.getMenu().getId());
	}
	
	@Test
	public void test_Item_image_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(13, i.getImage().getId());
		
	}
	
	@Test
	public void test_Item_cartHasItemList_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(3, i.getCartHasItemList().size());
		assertEquals(1, i.getCartHasItemList().get(0).getId());
	}
	
	@Test
	public void test_Item_orderHasItemList_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(2, i.getOrderHasItemsList().size());
		assertEquals(3, i.getOrderHasItemsList().get(0).getId());
	}
	
	@Test
	public void test_Item_categoryList_mapped() {
		Item i = em.find(Item.class, 1);
		assertEquals(1, i.getCategoryList().size());
		assertEquals(" Mexican", i.getCategoryList().get(0).getCategory());
	}
}
