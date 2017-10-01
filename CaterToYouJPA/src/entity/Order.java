package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="orders")
public class Order {
	
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="total")
	private int total;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	@Column(name="delivery_date_time")
	private Date deliveryDateTime;
	
	@ManyToOne
	@JoinColumn(name="delivery_address")
	private Address address;
	
	@OneToMany(mappedBy="order")
	private List<OrderHasItems> orderHasItemsList;
	
	
	//gets and sets
	
	
	public List<OrderHasItems> getOrderHasItemsList() {
		return orderHasItemsList;
	}
	public void setOrderHasItemsList(List<OrderHasItems> orderHasItemsList) {
		this.orderHasItemsList = orderHasItemsList;
	}
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
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getDeliveryDateTime() {
		return deliveryDateTime;
	}
	public void setDeliveryDateTime(Date deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
