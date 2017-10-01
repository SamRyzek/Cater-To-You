package entity;

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
	private int id;
	
	private int count;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Order order;

	//sets and gets
	
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
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHasItems [id=");
		builder.append(id);
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}
	
}
