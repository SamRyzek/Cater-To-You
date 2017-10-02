package cater.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Address;
import entity.Cart;
import entity.CartHasItem;
import entity.Company;
import entity.Customer;
import entity.Item;
import entity.Menu;
import entity.Order;

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
	public void emptyCart(Item i, Cart cart) {

		String sql = "DELETE ci FROM CartHasItem ci WHERE ci.cart.id = :cart";
		em.createQuery(sql, CartHasItem.class)
				.setParameter("cart", cart.getId())
				.executeUpdate();

	}

	@Override
	public void removeItemFromCart(Item i, Cart cart) {

		String sql = "DELETE ci FROM CartHasItem ci WHERE ci.item.id = :id AND ci.cart.id = :cart";
		em.createQuery(sql, CartHasItem.class)
				.setParameter("id", i.getId())
				.setParameter("cart", cart.getId())
				.executeUpdate();
	}

	@Override
	public Item returnItemToScreen(Item i) {
		String queryString = "SELECT i FROM Item i WHERE i.name = :name";
		Item item = em.createQuery(queryString, Item.class)
				.setParameter("name", i.getName())
				.getSingleResult();

		return item;
	}

	@Override
	public void updateQuantityInCart(Item i, Cart cart, int quantity) {

		String sql = "SELECT ci FROM CartHasItem ci WHERE ci.item.id = :id AND ci.cart.id = :cart";
		CartHasItem chi = em.createQuery(sql, CartHasItem.class)
				.setParameter("id", i.getId())
				.setParameter("cart", cart.getId())
				.getResultList().get(0);

		if (chi != null) {

			chi.setCart(cart);
			chi.setCount(chi.getCount() + 1);
			chi.setItem(i);
			em.persist(chi);
		}
	}

	@Override
	public List<Item> showCartWithAllItems(Customer c) {
		int id = c.getCart().getId();
		String stringQuery = "SELECT i FROM Item i WHERE i.cartHasItemList.cart.id = :id";
		List<Item> itemList = em.createQuery(stringQuery, Item.class)
				.setParameter("id", id)
				.getResultList();

		return itemList;
	}

	@Override
	public void checkoutEmptiesCartMovesToOrder(Cart cart, Address address) {
		
		List<CartHasItem> chiList1 = cart.getCartHasItemList();
		List<Item> itemListToMove = new ArrayList<>();
		
		for(CartHasItem c : chiList1) {
			itemListToMove.add(c.getItem());
		}
		Order order = new Order();
		order.set(cart.getAddress());
		
		
		for(CartHasItem c : cart.getCartHasItemList()) {
			em.remove(c);
		}
	}
	
	

	@Override
	public void calculateCartTotal(Item i, Cart cart) {

		String sql = "SELECT ci FROM CartHasItem ci WHERE ci.item.id = :id AND ci.cart.id = :cart";
		CartHasItem chi = em.createQuery(sql, CartHasItem.class)
				.setParameter("id", i.getId())
				.setParameter("cart", cart.getId())
				.getResultList().get(0);

		if(chi != null) {

			chi.setCart(cart);
			chi.setItem(i);

		}

	}

	@Override
	public List<Item> showMenu(int id) {
		String sql = "SELECT i FROM Item i where i.menu.company.id = :id ";
	    List<Item> menuItems = em.createQuery(sql, Item.class)
	    		.setParameter("id", id)
	    		.getResultList();
	    return menuItems;
	}

	@Override
	public Customer updateEmail(Customer c) {

		int id = c.getId();
		Customer customer = em.find(Customer.class, id);
		String email = c.getUser().getEmail();

		customer.getUser().setEmail(email);

		return customer;
	}

	@Override
	public Customer updateAddress(Customer c, Address a) {
		
		int id = c.getId();
		
		Customer customer = em.find(Customer.class, id);
		customer.setAddress(a);
		return null;
	}

	@Override
	public Menu returnMenuByCompanyId(Company c) { //join fetch
		
		int id = c.getId();
		String queryString = "SELECT m FROM Menu m JOIN FETCH m.itemList WHERE m.company.id = :id";
		Menu menu = em.createQuery(queryString, Menu.class)
				.setParameter("id", id)
				.getSingleResult();
		
		return menu;
	}

	@Override
	public List<Item> returnItemsFromMenu(Menu m) {
		int id = m.getId();
		
		String queryString = "SELECT m FROM Menu m JOIN FETCH m.itemList WHERE m.id = :id";
		
		Menu menu = em.createQuery(queryString, Menu.class)
				.setParameter("id", id)
				.getSingleResult();
		return menu.getItemList();
	}

	@Override
	public Item returnItemById(Item i) {
	
		int id = i.getId();
		String queryString = "SELECT i from Item WHERE i.id = :id";
		
		Item item = em.createQuery(queryString, Item.class)
				.setParameter("id", id)
				.getSingleResult();
		
		return item;
	}

	@Override
	public List<Menu> populateMenuList() {
		
	String queryString = "SELECT m FROM Menu m JOIN FETCH m.itemList";
	List<Menu> menuList = em.createQuery(queryString, Menu.class)
			.getResultList();
		
		return menuList;
	}


	@Override
	public List<Order> returnOrdersForCustomer(Customer c) {
		int id = c.getId();
		String queryString = "SELECT o FROM Order o where o.customer.id = :id ";
	    List<Order> orderHistory = em.createQuery(queryString, Order.class)
	    		.setParameter("id", id)
	    		.getResultList();
	    return orderHistory;
	}

//	@Override
//	public List<Item> returnItemsInOrderById(Order order) {
//		
//		int id = order.getId();
//		String queryString = "SELECT ord FROM OrderHasItems ord WHERE ord.order.id = :id";
//		List<OrderHasItems> orderHasItemList = em.createQuery(queryString, OrderHasItems.class)
//				.setParameter("id", id)
//				.getResultList();
//		
//		List<Item> itemList = new ArrayList<>(); 
//		for (OrderHasItems i : orderHasItemList) {
//			itemList.add(i.getItem());	
//		}
//		
//		
//		return itemList;
//	}
	@Override
	public List<Item> returnItemsInOrderById(Order order) {
		int id = order.getId();
		String queryString = "SELECT i FROM Item i WHERE i.OrderHasItems.Order.id = :id";
		List<Item> items = em.createQuery(queryString, Item.class)
				.setParameter("id", id)
				.getResultList();
		return items;
	}



}
