package project0;
import java.io.Serializable;

public class Customer implements Serializable {
	protected String name;
	protected String username;
	protected String password;
	protected double balance;
	protected int creditScore;
	protected boolean approved;
	
	public Customer(String name, String username, String password, double balance, int creditScore) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.creditScore = creditScore;
		this.approved = false;
	}
	
	

	public String getName() {
		return name;
	}


	public String getUsername() {
		return username;
	}

	
	public String getPassword() {
		return password;
	}

	
	public double getBalance() {
		return balance;
	}
	

	public int getCreditScore() {
		return creditScore;
	}
	
	public boolean getApproved() {
		return this.approved;
	}
	
	public void setBalance(double amount) {
		this.balance = amount;
	}
	
	public void setApproved(boolean value) {
		this.approved = value;
	}
	
	public void withdraw(double amount) {
		if (balance >= amount) {
		  this.balance -= amount;
		  System.out.println(amount + " withdrawn successfully!");
		} else {
		   System.out.println("Not enough funds to withdraw");
		}
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println(amount + " deposited successfully!");
	}
	
	public void transfer (Customer c1, double amount) {
		if (this.balance >= amount) {
			c1.balance += amount;
			this.balance -= amount;
		} else {
			System.out.println("Transfer cannot be completed.");
		}
	}



	@Override
	public String toString() {
		return "Customer [name= " + name + ", username=" + username + ", password= " + password + ", balance= " + balance
				+ ", creditScore= " + creditScore + ", approved= " + approved + "]";
	}
	
	

	
	
	
	
	

}
