package cater.data;

import java.util.Date;
import java.util.List;

import entity.Address;
import entity.Cart;
import entity.Company;
import entity.Customer;
import entity.Image;
import entity.Item;
import entity.Menu;
import entity.Order;
import entity.User;

public interface CustomerDAO {


	public void addItemToCart(int item, Cart cart, int count);// add item to cart
	public void emptyCart(Cart cart); // checkout cart
	public void removeItemFromCart(int i, Cart cart); // delete item from cart
	public void updateQuantityInCart(int id, int quantity);// update cart
	public Cart showCartWithAllItems(Customer customer);
	public double calculateCartTotal(Cart c);
	public Customer createAddressForCustomer(Customer customer);
	public Customer getCustomerById(int id);

	public List<Address> getPreviousAddress(Customer customer);

	public Address getAddressById(int addId);
	public User persistUserNamePassword(int id, String userName, String password);

//***** New User Method
	public User createUser(User user);
	public Customer usersCustomer(User user);
	public Cart usersCart();

	
//******* Image methods
	public Customer createImageForCustomer(Customer customer);
	public Image updateImage(Customer customer);
	
	public User getUserById(int id);




//************************Chris's methods

	public User updateEmail(User user);
	public Address updateAddress(Address address);

	public Menu returnMenuByCompanyId(Company c); //put an m.getId and then do the find

	public List<Item> returnItemsFromMenu(Menu m); //m.getId eager load in the list of items it has. With menu obj, we don't need to reorganize shit if we decide to search on other stuff

	public Item returnItemById(int id);

	public List<Item> returnItemsInOrderById(Order order);

	public List<Menu> populateMenuList();


	public List<Order> returnOrdersForCustomer(Customer c);


	public Item returnItemToScreen(Item i); // take in the title of the item off a drop down, go pull it out of
													// the db, and return it back to the controller, it gets put on a
//********************Chris's methods													 jsp for the customer


	//get cart and return all items within the cart



	//take in items by id and add items based on quantity

	public void checkoutEmptiesCartMovesToOrder(int id, Address address, String time, String date);
	public Date conveStringToDateTime(String time, String date);

	//cart check out with total and cart is emptied


	public List<Item> showMenu(int id);


	//takes all items in the cart and adds their prices


}
