package cater.data;

import java.util.List;

import javax.persistence.criteria.Order;

import entity.Address;
import entity.Cart;
import entity.Customer;
import entity.Item;
import entity.Menu;
import entity.Order;

public interface CustomerDAO {

	// add item to cart
	public void addItemToCart(Item i, Cart cart);

	// update cart
	public void updateQuantityInCart(Item i, Cart cart);

	// checkout cart
	// need to include functionality to update order history
	// may need to take in customer cart
	public void emptyCart(Item i, Cart cart);

	// delete item from cart
	public void removeItemFromCart(Item i, Cart cart);

	// enter shipping address

	// update personal information, and when we create a customer object he'll
	// automatically have all null shit, therefore we don't need an add customer
	// information


//************************Chris's methods

	public Customer updateEmail(Customer c, int id);

	public Customer updateAddress(Customer c, Address a, int id);

	public Menu returnMenuByCompanyId(Menu m); //put an m.getId and then do the find

	public List<Item> returnItemsFromMenu(Menu m); //m.getId eager load in the list of items it has. With menu obj, we don't need to reorganize shit if we decide to search on other stuff

	public Item returnItemById(Item i);

	public List<Item> returnItemsInOrderById(Order order);

	public List<Menu> populateMenuList();


	public List<Order> returnOrdersForCustomer(Customer c);


	public Item returnItemToScreen(String title); // take in the title of the item off a drop down, go pull it out of
													// the db, and return it back to the controller, it gets put on a
//********************Chris's methods													 jsp for the customer

	public void showCartWithAllItems();

	//get cart and return all items within the cart


	//get cart and allow for orders to be edited, think cart update


	//take in items by id and add items based on quantity

	public void checkoutEmptiesCartMovesToOrder();

	//cart check out with total and cart is emptied

	public void calculateCartTotal();

	List<Item> showMenu(int id);



}
