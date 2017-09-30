package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int userID;
	
	@Column(name="cart_id")
	@OneToOne(mappedBy="cart")
	@ManyToOne
	@JoinColumn(name="cart_id")
	private int cartID;
	
	@Column(name="billing_address")
	private int billingAddress;
	
	@Column(name="customer_imagel")
	private int customerImage;
	
	//gets and sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public int getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(int billingAddress) {
		this.billingAddress = billingAddress;
	}
	public int getCustomerImage() {
		return customerImage;
	}
	public void setCustomerImage(int customerImage) {
		this.customerImage = customerImage;
	}
	
	//toString
	@Override
	public String toString() {
		return "Customer [id=" + id + ", userID=" + userID + ", cartID=" + cartID + ", billingAddress=" + billingAddress
				+ ", customerImage=" + customerImage + "]";
	}
	
	
	
	

}
