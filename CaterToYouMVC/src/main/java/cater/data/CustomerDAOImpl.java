package cater.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import entity.Image;
import entity.Item;
import entity.Menu;
import entity.Order;
import entity.OrderHasItems;
import entity.User;
import entity.UserRoles;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	EntityManager em;
	
	public User createUser(User user) {
		user.setUserRoles(em.find(UserRoles.class, 1));
		em.persist(user);
		usersCustomer(user);
		return user;
	}
	
	public Customer createImageForCustomer(Customer customer) {
		Customer c = em.find(Customer.class, customer.getId());
		Image i = customer.getImage(); //creating image with no relation to customer here
		em.persist(i);
		c.setImage(i); //now we're returning the customer with the associated updated image
		return c;		
	}
	
	public Image updateImage(Customer customer) {
		Customer c = em.find(Customer.class, customer.getId());
		Image i = customer.getImage();
		em.persist(i);
		c.setImage(i);
		return i;
	}
	
	public User getUserById(int id) {
		
		return em.find(User.class, id);
		
	}
	
	
	public List<Address> getPreviousAddress(Customer customer) {

		Customer c = em.find(Customer.class, customer.getId());
		String queryString = "SELECT ord FROM Order ord WHERE ord.customer.id= :id";
		List<Order> orderList = em.createQuery(queryString, Order.class).setParameter("id", c.getId())
				.getResultList();
		List<Address> custAddresses = new ArrayList<>();
		for(Order o : orderList) {
			custAddresses.add(o.getAddress());
		}
		return custAddresses;
	}
	
	public Address getAddressById(int addId) {
		Address a = em.find(Address.class, addId);
		return a;
	}
	
	public Customer usersCustomer(User user) {
		Customer c = new Customer();
		Cart ca = usersCart();
		c.setUser(user);
		c.setCart(ca);
		em.persist(c);
		return c;	
	}
	
	public Cart usersCart() {
		Cart c = new Cart();
		em.persist(c);
		return c;
	}
	

	@Override
	public void addItemToCart(int itemId, Cart cart, int count) {

		String sql = "SELECT ci FROM CartHasItem ci WHERE ci.item.id = :id AND ci.cart.id = :cart";
		List<CartHasItem> chiList = em.createQuery(sql, CartHasItem.class).setParameter("id", itemId)
				.setParameter("cart", cart.getId()).getResultList();

		Item item = em.find(Item.class, itemId);
		if (chiList.size() == 0) {
			CartHasItem chi = new CartHasItem();
			chi = new CartHasItem();
			chi.setCart(cart);
			chi.setCount(count);
			chi.setItem(item);
			em.persist(chi);
		} else {
			CartHasItem chi = chiList.get(0);
			chi.setCount(chi.getCount() + count);
		}
	}
	
	

	@Override
	public void emptyCart(Cart cart) {
		String sql = "DELETE FROM CartHasItem ci WHERE ci.cart.id = :cart";
		em.createQuery(sql).setParameter("cart", cart.getId()).executeUpdate();
	}

	@Override
	public void removeItemFromCart(int i, Cart cart) {
		CartHasItem cartHas = em.find(CartHasItem.class, i);
		em.remove(cartHas);
	}

	@Override //if they update to 0, it removes it
	public void updateQuantityInCart(int id, int quantity) {
		CartHasItem cartHas = em.find(CartHasItem.class, id);
		
		if(quantity == 0) {
			em.remove(cartHas);
		}
		else {
		cartHas.setCount(quantity);
		}
	}

	@Override
	public Cart showCartWithAllItems(Customer customer) {
		String sql = "SELECT c FROM Cart c JOIN FETCH c.cartHasItemList WHERE c.customer.id = :id";
		List<Cart> cartList = em.createQuery(sql, Cart.class).setParameter("id", customer.getId()).getResultList();
		Cart cart = cartList.size() == 0 ? null : cartList.get(0);
		return cart;
	}

	@Override
	public double calculateCartTotal(Cart cart) {
		double total = 0.0;
		if (cart != null) {
			String sql = "SELECT ci FROM CartHasItem ci WHERE ci.cart.id = :cart";
			List<CartHasItem> cartHasList = em.createQuery(sql, CartHasItem.class).setParameter("cart", cart.getId())
					.getResultList();
			for (CartHasItem cartHasItem : cartHasList) {
				total += cartHasItem.getItem().getPrice() * cartHasItem.getCount();
			}
		}
		return total;
	}

	@Override
	public Item returnItemToScreen(Item i) {
		String queryString = "SELECT i FROM Item i WHERE i.name = :name";
		Item item = em.createQuery(queryString, Item.class).setParameter("name", i.getName()).getSingleResult();

		return item;
	}

	@Override
	public void checkoutEmptiesCartMovesToOrder(int id, Address address, String time, String date) {
		Cart cart = em.find(Cart.class, id);
		
		List<CartHasItem> chiList1 = cart.getCartHasItemList();
		List<OrderHasItems> orderHasList = new ArrayList<>();
		if(address.getId() == 0) {
			em.persist(address);
		}
		for (CartHasItem c : chiList1) {
			OrderHasItems orderHas = new OrderHasItems();
			orderHas.setCount(c.getCount());
			orderHas.setItem(c.getItem());
			orderHasList.add(orderHas);
		}
		Order order = new Order();
		order.setCustomer(cart.getCustomer());
		order.setAddress(address);
		order.setOrderHasItemsList(orderHasList);
		Date dt = conveStringToDateTime(time, date);
		System.out.println("date: "+dt +" :date");
		order.setDeliveryDateTime(dt);
		em.persist(order);
		emptyCart(cart);
	}
	
	public Date conveStringToDateTime(String time, String date) {
		String[] timeSections = time.split(" ");
		int pmNumber = timeSections[1].equals("PM") ? 12: 0;
		timeSections = timeSections[0].split(":");
		String newTime = Integer.parseInt(timeSections[0]) + pmNumber + ":" + timeSections[1];
		String dateTime = date + " " + newTime;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			return simpleDateFormat.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Item> showMenu(int id) {
		String sql = "SELECT i FROM Item i where i.menu.company.id = :id AND i.availability>0";
	    List<Item> menuItems = em.createQuery(sql, Item.class)
	    		.setParameter("id", id)
	    		.getResultList();
	    return menuItems;
	}

	@Override
	public User updateEmail(User user) {
		User userTracked = em.find(User.class, user.getId());
		userTracked.setEmail(user.getEmail());
		return userTracked;
		
	}
	
	@Override
	public User persistUserNamePassword(int id, String userName, String password) {
		User userTracked = em.find(User.class, id);
		userTracked.setUsername(userName);
		userTracked.setPassword(password);
		return userTracked;
		
	}
	
	@Override
	public Customer createAddressForCustomer(Customer customer) {
		Customer c = em.find(Customer.class, customer.getId());
		Address a = customer.getAddress(); //creating address with no relation to customer here
		em.persist(a);
		c.setAddress(a); //now we're returning the customer with the associated updated address
		return c;
	}
	

	@Override
	public Address updateAddress(Address address) {
		Address addressTracked = em.find(Address.class, address.getId());
		addressTracked.setCity(address.getCity());
		addressTracked.setState(address.getState());
		addressTracked.setStreet(address.getStreet());
		addressTracked.setStreet2(address.getStreet2());
		addressTracked.setZip(address.getZip());
		return addressTracked;
	}

	@Override
	public Menu returnMenuByCompanyId(Company c) { // join fetch

		int id = c.getId();
		String queryString = "SELECT m FROM Menu m JOIN FETCH m.itemList WHERE m.company.id = :id";
		Menu menu = em.createQuery(queryString, Menu.class).setParameter("id", id).getSingleResult();

		return menu;
	}

	@Override
	public List<Item> returnItemsFromMenu(Menu m) {
		int id = m.getId();

		String queryString = "SELECT m FROM Menu m JOIN FETCH m.itemList WHERE m.id = :id";

		Menu menu = em.createQuery(queryString, Menu.class).setParameter("id", id).getSingleResult();
		return menu.getItemList();
	}

	@Override
	public Item returnItemById(int id) {
		String queryString = "SELECT i from Item i WHERE i.id = :id";

		Item item = em.createQuery(queryString, Item.class).setParameter("id", id).getResultList().get(0);

		return item;
	}

	@Override
	public List<Menu> populateMenuList() {

		String queryString = "SELECT m FROM Menu m JOIN FETCH m.itemList";
		List<Menu> menuList = em.createQuery(queryString, Menu.class).getResultList();

		return menuList;
	}

	@Override
	public List<Order> returnOrdersForCustomer(Customer c) {
		int id = c.getId();
		String queryString = "SELECT o FROM Order o where o.customer.id = :id ";
		List<Order> orderHistory = em.createQuery(queryString, Order.class).setParameter("id", id).getResultList();
		return orderHistory;
	}

	@Override
	public List<Item> returnItemsInOrderById(Order order) {
		int id = order.getId();
		String queryString = "SELECT i FROM Item i WHERE i.OrderHasItems.Order.id = :id";
		List<Item> items = em.createQuery(queryString, Item.class).setParameter("id", id).getResultList();
		return items;
	}



	@Override
	public Customer getCustomerById(int id) {
		return em.find(Customer.class, id);
	}

}
