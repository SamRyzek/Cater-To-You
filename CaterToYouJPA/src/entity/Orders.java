package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Orders {
	
	//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(mappedBy="orders_id")
	private int id;
	
	@Column(name="total")
	private int total;
	
	@Column(name="customer_id")
	private int customerID;
	
	@Column(name="delivery_date_time")
	private Date deliveryDateTime;
	
	@ManyToOne
	@JoinColumn(name="id")
	@Column(name="delivery_address")
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
