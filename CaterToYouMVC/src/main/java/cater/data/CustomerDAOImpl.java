package cater.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Cart;
import entity.Customer;
import entity.Item;


@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addItemToCart(Item i, Cart cart) {
		
		Cart c = em.find(Cart.class, 0);
		
		
	}

	@Override
	public void updateQuantity(Item i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emptyCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItemFromCart(Item i) {
		
		
	}

	@Override
	public Customer updatePersonalInfo(Customer c, int id) {
		
		Customer cust = em.find(Customer.class, id);
		if(cust != null) {
			
			cust.setAddress(c.getAddress());
			cust.setImage(c.getImage());
			
		}
		
		
		return null;
		
	}

	@Override
	public Item returnItemToScreen(String title) {
		
		return null;
	}

}
