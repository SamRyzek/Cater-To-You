package cater.data;

import java.util.List;

import entity.Address;
import entity.Cart;
import entity.Company;
import entity.Customer;
import entity.Item;
import entity.Menu;
import entity.Order;
import entity.User;

public interface CustomerDAO {


	public void addItemToCart(Item i, Cart cart);// add item to cart
	public void emptyCart(Cart cart); // checkout cart
	public void removeItemFromCart(Item i, Cart cart); // delete item from cart
	public void updateQuantityInCart(Item i, Cart cart, int quantity);// update cart
	public Cart getCartForCustomer(Customer customer);
	public double calculateCartTotal(Cart c);

	


	

//************************Chris's methods

	public User updateEmail(User user);
	public Customer updateAddress(Customer customer);

	public Menu returnMenuByCompanyId(Company c); //put an m.getId and then do the find

	public List<Item> returnItemsFromMenu(Menu m); //m.getId eager load in the list of items it has. With menu obj, we don't need to reorganize shit if we decide to search on other stuff

	public Item returnItemById(Item i);

	public List<Item> returnItemsInOrderById(Order order);

	public List<Menu> populateMenuList();


	public List<Order> returnOrdersForCustomer(Customer c);


	public Item returnItemToScreen(Item i); // take in the title of the item off a drop down, go pull it out of
													// the db, and return it back to the controller, it gets put on a
//********************Chris's methods													 jsp for the customer

	public List<Item> showCartWithAllItems(Customer c);

	//get cart and return all items within the cart



	//take in items by id and add items based on quantity

	public void checkoutEmptiesCartMovesToOrder(Cart cart, Address address);

	//cart check out with total and cart is emptied


	public List<Item> showMenu(int id);


	//takes all items in the cart and adds their prices


}
