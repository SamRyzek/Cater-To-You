package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Company {
	
	
	//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="menu_id")
	@OneToOne(mappedBy="Company")
	private int menuID;
	
	@Column(name="company_address")
	private int companyAddress;
	
	@Column(name="company_image")
	private int companyImage;
	
	//gets and sets
	public int getCompanyImage() {
		return companyImage;
	}
	public void setCompanyImage(int companyImage) {
		this.companyImage = companyImage;
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
				+ ", companyImage=" + companyImage + "]";
	}

	
	
	
	
	
	

}
