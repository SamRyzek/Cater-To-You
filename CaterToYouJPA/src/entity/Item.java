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
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="calories")
	private int calories;
	
	@Column(name="desc")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="availablity")
	private int availability;
	
	@ManyToOne
	@JoinColumn(name="menu_id")
	private Menu menu;
	
	@ManyToOne
	@JoinColumn(name="item_image")
	private Image image;
	
	@OneToMany(mappedBy="item")
	List<OrderHasItems> orderHasItemsList;
	
	
	@ManyToMany
	@JoinTable(name="item_has_category",
	joinColumns=@JoinColumn(name="item_id"),
	inverseJoinColumns=@JoinColumn(name="category_id")		
			)
	private List<Category> categoryList;
	
	@OneToMany(mappedBy="item")
	private List<CartHasItem> cartHasItemList;
	
	
	//gets and sets
	
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
	
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	public List<OrderHasItems> getOrderHasItemsList() {
		return orderHasItemsList;
	}
	public void setOrderHasItemsList(List<OrderHasItems> orderHasItemsList) {
		this.orderHasItemsList = orderHasItemsList;
	}
	
	public List<CartHasItem> getCartHasItemList() {
		return cartHasItemList;
	}
	public void setCartHasItemList(List<CartHasItem> cartHasItemList) {
		this.cartHasItemList = cartHasItemList;
	}

}
