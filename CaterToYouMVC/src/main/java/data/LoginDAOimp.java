package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.User;

@Repository 
@Transactional
public class LoginDAOimp implements LoginDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User returnUser(String userName, String password) {
		String sql = "SELECT u FROM User u WHERE u.username = :user AND u.password = :pass";
		User user = em.createQuery(sql, User.class).setParameter("user", userName)
				.setParameter("pass", password).getResultList().get(0);
		return user;
	}

	

}
