package entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserRolesTest {
	
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
	public void test_UserRoles_user_mapped() {
		UserRoles ur = em.find(UserRoles.class, 1);
		assertEquals(7, ur.getUser().size());
		assertEquals(13, ur.getUser().get(0).getId());
	}
	
	@Test
	public void test_UserRoles_type_mapped() {
		UserRoles ur = em.find(UserRoles.class, 1);
		assertEquals("Customer", ur.getType());
	}
}
