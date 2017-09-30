package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Item {
	
	
	//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(mappedBy="item_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="calories")
	private int calories;
	
	@Column(name="desc")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="availability")
	private int availability;
	
	@Column(name="menu_id")
	private int menuID;
	
	@Column(name="item_image")
	@ManyToOne
	@JoinColumn(name="item_image")
	private int itemImage;
	
	@ManyToMany
	@JoinTable(name="order_has_item", 
	joinColumns=@JoinColumn(name="id"), 
	inverseJoinColumns=@JoinColumn(name="id")
	)
	private List<Orders> orders;
	
	
	//gets and sets
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public int getMenuID() {
		return menuID;
	}
	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}
	public int getItemImage() {
		return itemImage;
	}
	public void setItemImage(int itemImage) {
		this.itemImage = itemImage;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", calories=" + calories + ", description=" + description
				+ ", price=" + price + ", availability=" + availability + ", menuID=" + menuID + ", itemImage="
				+ itemImage + "]";
	}
	
	
	
	
	

}
