package project0;
import java.io.Serializable;

public class Admin extends Employee implements Serializable {
	
	public Admin(String username, String password) {
		super(username, password);
	}
	
	public void approveAccount(Customer c1) {
		if (c1.getCreditScore() > 500) {
			c1.setApproved(true);
		}
		
	}
	
	public void withdraw(Customer c1, double amount) {
		if (c1.getBalance() > amount) {
			c1.withdraw(amount);
		}
	}
	
	public void deposit(Customer c1, double amount) {
		c1.deposit(amount);
	}
	
	public void transfer(Customer c1, Customer c2, double amount) {
		if (c1.getBalance() >= amount) {
			c1.transfer(c2,  amount);
		}
	}
	
	
	
	

} 
