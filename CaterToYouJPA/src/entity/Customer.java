package entity;

public class Customer {
	
	//field
	private int id;
	private int userID;
	private int cartID;
	private int billingAddress;
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
