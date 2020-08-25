package corejavaassignment;

public class ConcreteStringClass extends AbstractStringClass {
	
	public boolean anyUpper(String input) {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isUpperCase(ch)) {
				return true;
			}
		}
		return false;
	}
	
	public String lowertoUpper(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isLowerCase(ch)) {
				 ch = Character.toUpperCase(ch);
			}
			sb.append(ch);
			
		}
		return sb.toString();
	}
	
	public int convertString(String input) {
		int num = Integer.parseInt(input);
		return num + 10;
		
		
	}

}
