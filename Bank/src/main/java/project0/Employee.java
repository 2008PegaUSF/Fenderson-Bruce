package project0;
import java.io.Serializable;


public class Employee implements Serializable {
	
	protected String username;
	protected String password;
	
	public Employee(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public Customer getCustomerInfo(Customer c1) {
		return c1;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
	
	
	
	

}
