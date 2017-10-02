package cater.data;

import java.util.List;

import javax.persistence.criteria.Order;

import entity.Cart;
import entity.Customer;
import entity.Item;

public interface CustomerDAO {

	// add item to cart
	public void addItemToCart(Item i, Cart cart);

	// update cart
	public void updateQuantityInCart(Item i);

	// checkout cart
	// need to include functionality to update order history
	// may need to take in customer cart
	public void emptyCart();

	// delete item from cart
	public void removeItemFromCart(Item i);

	// enter shipping address

	// update personal information, and when we create a customer object he'll
	// automatically have all null shit, therefore we don't need an add customer
	// information
	public Customer updatePersonalInfo(Customer c, int id);

	public Item returnItemToScreen(String title); // take in the title of the item off a drop down, go pull it out of
													// the db, and return it back to the controller, it gets put on a
													// jsp for the customer

	public void showCartWithAllItems();

	//get cart and return all items within the cart
	
	public void cartEditOrder();
	
	//get cart and allow for orders to be edited, think cart update
	
	public void addItemsBasedOnQuantityByItemID();
	
	//take in items by id and add items based on quantity
	
	public void checkoutEmptiesCart();
	
	//cart check out with total and cart is emptied
	
	public void calculateCartTotal();

	List<Item> showMenu(int id);

	List<Order> findOrderHistory(int id);
	
	//takes all items in the cart and adds their prices
	
	
}
