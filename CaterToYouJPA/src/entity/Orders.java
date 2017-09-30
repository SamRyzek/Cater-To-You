package entity;

import java.util.Date;

public class Orders {
	
	//field
	private int id;
	private int total;
	private int customerID;
	private Date deliveryDateTime;
	private int deliveryAddress;
	
	//gets and sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public Date getDeliveryDateTime() {
		return deliveryDateTime;
	}
	public void setDeliveryDateTime(Date deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}
	public int getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(int deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	//toString
	@Override
	public String toString() {
		return "Orders [id=" + id + ", total=" + total + ", customerID=" + customerID + ", deliveryDateTime="
				+ deliveryDateTime + ", deliveryAddress=" + deliveryAddress + "]";
	}
	
	
	
	
	

}
