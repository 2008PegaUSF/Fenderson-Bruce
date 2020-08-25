package corejavaassignment;

public class ConcreteStringTest {
	public static void main(String[] args) {
		ConcreteStringClass cs = new ConcreteStringClass();
		try {
			System.out.println(cs.anyUpper("brUce"));
			System.out.println(cs.lowertoUpper("bruce"));
			cs.convertString("70");
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid number entered for convertString method!!");	
		}
		
		
	}

}
