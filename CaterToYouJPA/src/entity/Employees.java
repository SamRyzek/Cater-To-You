package entity;

public class Employees {
	
	//field
	private int employeeID;
	private int userID;
	private int companyID;
	
	
	
	
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
