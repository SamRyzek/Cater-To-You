package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_has_items")
public class OrderHasItems {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@ManyToOne
	@JoinColumn(name="id")
	private int id;
	
	private int count;
	
	@Column(name="item_id")
	@ManyToOne
	@JoinColumn(name="id")
	private int itemId;
	
	@Column(name="orders_id")
	private int ordersId;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Order order;
	
	
	

	//sets and gets
	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public int getOrdersId() {
		return ordersId;
	}
	
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	//toString
	@Override
	public String toString() {
		return "OrderHasItems [id=" + id + ", count=" + count + ", itemId=" + itemId + ", ordersId=" + ordersId + "]";
	}
	
	
	
	
}
