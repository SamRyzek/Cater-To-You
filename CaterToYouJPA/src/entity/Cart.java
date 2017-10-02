package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy="cart")
	private List<CartHasItem> cartHasItemList;
	
	@OneToOne(mappedBy="cart")
	private Customer customer;

	public List<CartHasItem> getCartHasItemList() {
		return cartHasItemList;
	}

	public void setCartHasItemList(List<CartHasItem> cartHasItemList) {
		this.cartHasItemList = cartHasItemList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
