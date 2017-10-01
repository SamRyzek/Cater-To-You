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
	@Column(name="employee_id")
	private int employeeID;
	
	@OneToOne
	@JoinColumn(name="user_id") //this tables column to join on
	private User user;
	
	@ManyToOne//owning table gets join column
	@JoinColumn(name="company_id")
	private Company company;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [employeeID=");
		builder.append(employeeID);
		builder.append(", user=");
		builder.append(user);
		builder.append(", company=");
		builder.append(company);
		builder.append("]");
		return builder.toString();
	}
	
	
}
