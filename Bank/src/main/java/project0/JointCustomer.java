package project0;
import java.io.Serializable;

public class JointCustomer extends Customer implements Serializable {
	protected String name2;
	protected String username2;
	protected String password2;
	
	public JointCustomer(String name,  String name2, String username, String username2, String password, String password2, double balance, int creditScore) {
		super(name, username, password, balance, creditScore);
		this.name2 = name2;
		this.username2 = username2;
		this.password2 = password2;
	}
	
	public String getName2() {
		return this.name2;
	}
	
	public String getUsername2() {
		return this.username2;
	}
	
	public String getPassword2() {
		return this.password2;
	}

}
