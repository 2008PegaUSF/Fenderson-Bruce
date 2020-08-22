package project0;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class BankApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<Admin> admins = new ArrayList<Admin>();
		ArrayList<Customer> appliedCustomers = new ArrayList<Customer>();

		Scanner s = new Scanner(System.in);

		Customer a = new Customer("Bob", "bob1", "12345", 0.0d, 514);
		Customer b = new Customer("Nick", "n112", "6789", 5.0d, 700);
		a.setApproved(true);
		b.setApproved(true);
		
		Customer ap1 = new Customer("Sam", "s4457", "4568", 0.0d, 423);
		
		customers.add(a);
		customers.add(b);
		
		appliedCustomers.add(ap1);

		Employee c = new Employee("j115", "233475");
		Employee d = new Employee("s133", "485773");
		employees.add(c);
		employees.add(d);

		Admin admin = new Admin("k457", "28990");
		admins.add(admin);

		try {
			ObjectOutputStream cos = new ObjectOutputStream(new FileOutputStream("customers.dat"));
			ObjectOutputStream apos = new ObjectOutputStream(new FileOutputStream("applicants.dat"));
			ObjectOutputStream eos = new ObjectOutputStream(new FileOutputStream("employees.dat"));
			ObjectOutputStream aos = new ObjectOutputStream(new FileOutputStream("admins.dat"));

			cos.writeObject(customers);
			apos.writeObject(appliedCustomers);
			eos.writeObject(employees);
			aos.writeObject(admins);
			cos.close();
			apos.close();
			eos.close();
			aos.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("customers.dat"));
			ArrayList<Customer> customers2 = (ArrayList<Customer>) in.readObject();
			customers = customers2;
			System.out.println(Arrays.toString(customers2.toArray()));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Welcome! Are you a customer, employee, admin, or appicant? ");
		String response = s.nextLine().trim();
		response = response.toLowerCase();
		if (response.equalsIgnoreCase("customer")) {
			boolean flag = true;
			System.out.println("Please enter your username: ");
			String username = s.nextLine().trim();
			System.out.println("Please enter your password: ");
			String password = s.nextLine();
			Customer signedCustomer = validateUser(customers, username, password);
			if (signedCustomer == null) {
				System.out.println("User not found. Would you like to create an account? ");
				String createAccount = s.nextLine().toLowerCase();
				if (createAccount.equalsIgnoreCase("yes")) {
					System.out.println("Is this an individual or joint account? ");
					String accountType = s.nextLine().toLowerCase();
					if (accountType.equalsIgnoreCase("individual")) {
						System.out.println("Please enter your name, username, password, balance, and credit score: ");
						String newName = s.next();
						String newUsername = s.next();
						String newPassword = s.next();
						double newBalance = s.nextDouble();
						int newCredit = s.nextInt();
						Customer newCustomer = new Customer(newName, newUsername, newPassword, newBalance, newCredit);
						appliedCustomers.add(newCustomer);

					} else if (accountType.equalsIgnoreCase("joint account")) {
						System.out
								.println("Please enter your names, usernames, passwords, balance, and credit score: ");
						String newName = s.next();
						String newName2 = s.next();
						String newUsername = s.next();
						String newUsername2 = s.next();
						String newPassword = s.next();
						String newPassword2 = s.next();
						double newBalance = s.nextDouble();
						int newCredit = s.nextInt();
						JointCustomer newCustomer = new JointCustomer(newName, newName2, newUsername, newUsername2,
								newPassword, newPassword2, newBalance, newCredit);
						appliedCustomers.add(newCustomer);
					}

				} else if (createAccount.equalsIgnoreCase("no")) {
					System.exit(0);
				}

			} else {
				while (flag) {

					System.out.println("Would you like to view your balance, withdraw, deposit, or transfer? ");
					System.out.println("Press q to quit the program");
					String validResponse = s.nextLine().toLowerCase();
					switch (validResponse) {
					case "balance":
						System.out.println(signedCustomer.getBalance());
						break;
					case "withdraw":
						System.out.println("How much would you like to withdraw? ");
						double validAmount = s.nextDouble();
						signedCustomer.withdraw(validAmount);
						break;
					case "deposit":
						System.out.println("How much would you like to deposit? ");
						double validDeposit = s.nextDouble();
						signedCustomer.deposit(validDeposit);
						break;
					case "transfer":
						System.out.println("Which customer would you like to transfer to and how much? ");
						String transferUser = s.next();
						double transferAmount = s.nextDouble();
						Customer transferRec = validateUser(customers, transferUser);
						if (transferRec == null) {
							System.out.println("That user does not exist.");
						} else {
							signedCustomer.transfer(transferRec, transferAmount);
						}
						break;
					case "q":
						saveBankCustomers(customers);
						System.exit(0);
						break;
					default:
						System.out.println("Please select a valid option.");
						break;
						

					}

				}
			}
		}

		else if (response.equalsIgnoreCase("employee")) {
			System.out.println("Please enter your username: ");
			String username = s.nextLine().trim();
			System.out.println("Please enter your password: ");
			String password = s.nextLine();
			Employee signedEmployee = validateEmployee(employees, username, password);
			if (signedEmployee == null) {
				System.out.println("Employee not found.");
			} else {
				while (true) {
				System.out.println("Would you like to view current customers or view applicants? ");
				System.out.println("Press q to quit the program");
				String validResponse = s.nextLine().toLowerCase();
				switch(validResponse) {
				case "view current":
					System.out.println("Please enter the name of the customer ");
					String validCustomer = s.nextLine().toLowerCase();
					Customer newCustomer = validateUser(customers, validCustomer);
					System.out.println(newCustomer);
					break;
				case "view applicants":
					System.out.println("Please enter the name of the customer ");
					String validApp = s.nextLine().toLowerCase();
					Customer newApp = validateUser(appliedCustomers, validApp);
					System.out.println(newApp);
					System.out.println("Approve or Deny Applicant? ");
					String employeeDecision = s.next();
					if (employeeDecision.equalsIgnoreCase("approve")) {
						int appIndex = appliedCustomers.indexOf(newApp);
						Customer approved = appliedCustomers.remove(appIndex);
						approved.setApproved(true);
						customers.add(approved);
						appliedCustomers.remove(approved);
					} else if (employeeDecision.equalsIgnoreCase("deny")) {
						appliedCustomers.remove(newApp);
						System.out.println("Applicant has been removed");	
					}
					break;
				case "q":
					saveBankCustomers(customers);
					saveBankApplicants(appliedCustomers);
					System.exit(0);
					break;
					
					}
			
					
		
				}
			}
			

		}

		else if (response.equalsIgnoreCase("admin")) {
			System.out.println("Please enter your username: ");
			String username = s.nextLine().trim();
			System.out.println("Please enter your password: ");
			String password = s.nextLine();
			Admin signedAdmin = validateAdmin( admins, username, password);
			if (signedAdmin == null) {
				System.out.println("Admin not found.");
			} else {
				while (true) {
				System.out.println("Would you like to view current customers, view applicants, withdraw, deposit, transfer, or cancel ? ");
				System.out.println("Press q to quit the program");
				String validResponse = s.nextLine().toLowerCase();
				switch(validResponse) {
				case "view current":
					System.out.println("Please enter the name of the customer ");
					String validCustomer = s.nextLine().toLowerCase();
					Customer newCustomer = validateUser(customers, validCustomer);
					System.out.println(newCustomer);
					break;
				case "view applicants":
					System.out.println("Please enter the name of the customer ");
					String validApp = s.nextLine().toLowerCase();
					Customer newApp = validateUser(appliedCustomers, validApp);
					System.out.println(newApp);
					System.out.println("Approve or Deny Applicant? ");
					String employeeDecision = s.next();
					if (employeeDecision.equalsIgnoreCase("approve")) {
						int appIndex = appliedCustomers.indexOf(newApp);
						Customer approved = appliedCustomers.remove(appIndex);
						approved.setApproved(true);
						customers.add(approved);
						appliedCustomers.remove(approved);
					} else if (employeeDecision.equalsIgnoreCase("deny")) {
						appliedCustomers.remove(newApp);
						System.out.println("Applicant has been removed");	
					}
					break;
				case "withdraw":
					System.out.println("Enter the name of the customer: ");
					String name = s.next();
					Customer customer = validateUser(customers, name);
					if (customer == null) {
						System.out.println("Customer does not exist.");
					} else {
						System.out.println("How much would you like to withdraw? ");
						double validAmount = s.nextDouble();
						customer.withdraw(validAmount);
					}
					break;
				case "deposit":
					System.out.println("Enter the name of the customer: ");
					String depositname = s.next();
					Customer depositcustomer = validateUser(customers, depositname);
					if (depositcustomer == null) {
						System.out.println("Customer does not exist.");
					} else {
						System.out.println("How much would you like to deposit? ");
						double depositAmount = s.nextDouble();
						depositcustomer.deposit(depositAmount);
					}
					break;
				case "transfer":
					Customer transferfromcustomer;
					Customer transfertocustomer;
					while (true) {
						System.out.println("Enter the name of the customer to transfer from: ");
						String transferfrom = s.next();
						transferfromcustomer = validateUser(customers, transferfrom);
						if (transferfromcustomer == null ) {
							System.out.println("Customer does not exist.");
						} else {
							break;
						}
					}
					while (true) {
						System.out.println("Enter the name of the customer to transfer to: ");
						String transferto = s.next();
						transfertocustomer = validateUser(customers, transferto);
						if (transfertocustomer == null ) {
							System.out.println("Customer does not exist.");
						} else {
							break;
						}
					}
					
					System.out.println("How much would you like to transfer? ");
					double validAmount = s.nextDouble();
					transferfromcustomer.transfer(transfertocustomer, validAmount);
				break;
				
				case "cancel account":
					while (true) {
						System.out.println("Enter the name of the account you want to cancel: ");
						String cancelname = s.next();
						Customer cancelcustomer = validateUser(customers, cancelname);
						if (cancelcustomer == null) {
							System.out.println("That customer does not exist.");
						} else {
							customers.remove(cancelcustomer);
							break;
						}
					}
				break;
				
				case "q":
					saveBankCustomers(customers);
					saveBankApplicants(appliedCustomers);
					System.exit(0);
					break;
					
					}
			
					
		
				}
			}
			
			
			

		}
	}

	public static Customer validateUser(ArrayList<Customer> customers, String username, String password) {
		String approvedUn;
		String approvedPw;
		for (Customer customer : customers) {
			approvedUn = customer.getUsername();
			approvedPw = customer.getPassword();
			if (username.equalsIgnoreCase(approvedUn) && password.equalsIgnoreCase(approvedPw)) {
				System.out.println("User logged in successfully!");
				return customer;
			}
		}
		return null;
	}

	public static Customer validateUser(ArrayList<Customer> customers, String name) {
		String approvedUn;
		for (Customer customer : customers) {
			approvedUn = customer.getName();
			if (name.equalsIgnoreCase(approvedUn)) {
				return customer;
			}
		}
		return null;
	}
	
	
	
	
	public static Employee validateEmployee(ArrayList<Employee> employees, String username, String password) {
		String approvedUn;
		for (Employee employee : employees) {
			approvedUn = employee.getUsername();
			if (username.equalsIgnoreCase(approvedUn)) {
				return employee;
			}
		}
		return null;
	}
	

	public static Admin validateAdmin(ArrayList<Admin> admins, String username, String password) {
		String approvedUn;
		for (Admin admin : admins) {
			approvedUn = admin.getUsername();
			if (username.equalsIgnoreCase(approvedUn)) {
				return admin;
			}
		}
		return null;
	}
	
	public static void saveBankCustomers(ArrayList<Customer> customers) {
		try {
			ObjectOutputStream cos = new ObjectOutputStream(new FileOutputStream("customers.dat"));
	

			cos.writeObject(customers);
			cos.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void saveBankApplicants(ArrayList<Customer> applicants) {
		try {
			ObjectOutputStream cos = new ObjectOutputStream(new FileOutputStream("applicants.dat"));

			cos.writeObject(applicants);
			cos.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
