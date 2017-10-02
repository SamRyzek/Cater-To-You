package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {
	
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
	public void test_Address_street_mapped() {
		Address add = em.find(Address.class, 7);
		assertEquals("5695 S Galena St.",add.getStreet());
	}
	
	@Test
	public void test_Address_Street2_mapped() {
		Address add = em.find(Address.class, 7);
		assertEquals("", add.getStreet2());
	}
	
	@Test
	public void test_Address_city_mapped() {
		Address add = em.find(Address.class, 7);
		assertEquals("Greenwood Village", add.getCity());
	}
	
	@Test
	public void test_Address_state_mapped() {
		Address add = em.find(Address.class, 7);
		assertEquals("CO", add.getState());
	}
	
	@Test
	public void test_Address_zip_mapped() {
		Address add = em.find(Address.class, 7);
		assertEquals(80111, add.getZip());
	}
	
	@Test
	public void test_Address_customerList_mapped() {
		Address add = em.find(Address.class, 6);
		assertEquals(1, add.getCustomerList().size());
		assertEquals(1, add.getCustomerList().get(0).getId());
	}
	
	@Test
	public void test_Address_orderList_mapped() {
		Address add = em.find(Address.class, 7);
		assertEquals(2, add.getOrderList().size());
		assertEquals(3, add.getOrderList().get(1).getId());
	}
	
	@Test
	public void test_Address_companyList_mapped() {
		Address add = em.find(Address.class, 1);
		assertEquals(1, add.getCompanyList().size());
		assertEquals("Illegal Pete's", add.getCompanyList().get(0).getName());
	}
}
