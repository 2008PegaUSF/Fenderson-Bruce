package corejavaassignment;

public class Employee {
	
	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setAge(int age) {
		this.age  = age;
	}
	@Override
	public String toString() {
		return "Name: " + this.name + ", " + "Department: " + this.department + ", " + "Age: " + this.age;
	}
	
	

}
