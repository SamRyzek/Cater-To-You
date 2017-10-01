package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
	//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeID;
	
	@Column(name="user_id")
	private int userID;
	
	@Column(name="company_id")
	private int companyID;
	
	@OneToOne
	@JoinColumn(name="user_id") //this tables column to join on
	private User user;
	
	@ManyToOne//owning table gets join column
	@JoinColumn(name="company_id")
	private Company company;
	
	
	
	
	//gets and sets
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	
	
	
	//toString
	@Override
	public String toString() {
		return "Employees [employeeID=" + employeeID + ", userID=" + userID + ", companyID=" + companyID + "]";
	}
	
	
	
	

}
