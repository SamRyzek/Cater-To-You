package cater.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Cart;
import entity.CartHasItem;
import entity.Customer;
import entity.Item;
import entity.Menu;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public void addItemToCart(Item i, Cart cart) {

		String sql = "SELECT ci FROM CartHasItem ci WHERE ci.item.id = :id AND ci.cart.id = :cart";
		CartHasItem chi = em.createQuery(sql, CartHasItem.class)
				.setParameter("id", i.getId())
				.setParameter("cart", cart.getId())
				.getResultList().get(0);
		
		if (chi == null) {

			chi = new CartHasItem();
			chi.setCart(cart);
			chi.setCount(1);
			chi.setItem(i);
			em.persist(chi);
		} 
		else {
			chi.setCount(chi.getCount() + 1);
		}

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
		if (cust != null) {

			cust.setAddress(c.getAddress());
			cust.setImage(c.getImage());

		}

		return null;

	}

	@Override
	public Item returnItemToScreen(String title) {

		return null;
	}

	@Override
	public void updateQuantityInCart(Item i) {

	}

	@Override
	public void showCartWithAllItems() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cartEditOrder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addItemsBasedOnQuantityByItemID() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkoutEmptiesCart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void calculateCartTotal() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Item> showMenu(int id) {
		String sql = "SELECT i FROM item i where i.menu.company.id = :id ";
	    List<Item> menuItems = em.createQuery(sql, Menu.class).setParameter("id", id).getResultList().get(0).getItemList();
	    return menuItems;
	}

	@Override
	public List<Order> findOrderHistory(int id) {
		String sql = "SELECT o FROM order o where o.customer.id = :id ";
	    List<Order> orderHistory = em.createQuery(sql, Order.class).setParameter("id", id).getResultList();
	    return orderHistory;
	}

}
