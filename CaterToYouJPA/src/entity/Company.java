package entity;

public class Company {
	
	
	//field
	private int id;
	private String name;
	private int menuID;
	private int companyAddress;
	
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
	public int getMenuID() {
		return menuID;
	}
	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}
	public int getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(int companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", menuID=" + menuID + ", companyAddress=" + companyAddress
				+ "]";
	}
	
	
	
	
	
	
	

}
