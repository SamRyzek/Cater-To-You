package entity;

public class Item {
	
	
	//field
	private int id;
	private String name;
	private int calories;
	private String description;
	private double price;
	private int availability;
	private int menuID;
	private int itemImage;
	public int getId() {
		return id;
	}
	
	//gets and sets
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
