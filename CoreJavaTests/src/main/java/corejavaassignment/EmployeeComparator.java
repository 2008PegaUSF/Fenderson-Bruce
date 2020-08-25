package corejavaassignment;
import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		int nameComparison = a.getName().compareToIgnoreCase(b.getName());
		 if (nameComparison != 0) {
			 return nameComparison;
		 }
		 
		 int departmentComparison = a.getDepartment().compareToIgnoreCase(b.getDepartment());
		 if (departmentComparison != 0 ) {
			 return departmentComparison;
		 }
		 
		 int ageComparison = Integer.compare(a.getAge(), b.getAge());
		 return ageComparison;
	}

}

