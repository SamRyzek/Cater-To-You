package entity;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	Address add;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("CaterToYou");
		em = emf.createEntityManager();
		add = em.find(Address.class,1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		add = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true,true);
	}
	
	@Test 
	public void test_Address_street_mapped() {
		assertEquals("",add.getCity());
	}
	
	@Test
	public void test_Address_Street2_mapped() {
		assertEquals("", add.getStreet2());
	}
	
	@Test
	public void test_Address_city_mapped() {
		assertEquals("", add.getCity());
	}
	
	@Test
	public void test_Address_state_mapped() {
		assertEquals("", add.getState());
	}
	
	@Test
	public void test_Address_zip_mapped() {
		assertEquals("", add.getZip());
	}
}