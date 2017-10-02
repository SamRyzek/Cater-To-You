package cater.data;

import java.util.List;

import entity.Address;
import entity.Cart;
import entity.Customer;
import entity.Item;
import entity.Menu;

public interface CustomerDAO {

	// add item to cart
	public void addItemToCart(Item i, Cart cart);

	// update cart
	public void updateQuantity(Item i);

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
	
	public Customer updateEmail(Customer c, int id);
	
	public Customer updateAddress(Customer c, Address a, int id);
	
	public Menu returnMenuByCompanyId(Menu m); //put an m.getId and then do the find
	
	public List<Item> returnItemsFromMenu(Menu m); //m.getId eager load in the list of items it has. With menu obj, we don't need to reorganize shit if we decide to search on other stuff
	
	
	
	
	

	public Item returnItemToScreen(String title); // take in the title of the item off a drop down, go pull it out of
													// the db, and return it back to the controller, it gets put on a
													// jsp for the customer

	// enter billing address //these 2 might be same --> this might even just be
	// personal information
	// navigate items --> this wont be in arrows, but we could have drop tables and
	// make them select shit based on category, then we direct them to a jsp with a
	// list
	// --> of items in a for each loop for everything that was in that list of an
	// item category... good place to start --> can then move over into being able
	// to select shit based on other things.
	//
	//
	//
	//

}
