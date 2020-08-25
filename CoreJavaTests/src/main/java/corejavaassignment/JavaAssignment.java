package corejavaassignment;


import accessPackage.AccessClass;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.File;
import java.io.FileNotFoundException;
public class JavaAssignment {
	
	public static void main(String[] args) {
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		BubbleSort(arr);
		System.out.println("Question 1: " + Arrays.toString(arr));
		System.out.print("Question 2: ");
		PrintFibNums(25);
		String original = "Bruce";
		String result = reverseString(original);
		System.out.println("Question 3: " + "Original: " + original + "     Result: " + result);
		System.out.println("Question 4: " + "The factorial of 4 is " + factorial(4));
		String sub = SubString(original, 3);
		System.out.println("Question 5: " + "Original: " + original + "     First three characters: " + sub);
		System.out.println("Question 6: " + "Is 50 an even number? " + isEven(50));
		Employee[] sortedEmps = showEmployees();
		System.out.println("Question 7: " + "Sorted Employees: " + Arrays.toString(sortedEmps));
		System.out.println("Question 8: " + "Sorted Employees: " + Arrays.toString(sortedEmps));
		String[] pals = FindPals();
		System.out.println("Question 9: " + Arrays.toString(pals));
		System.out.println("Question 10: " + "The minimum of 3 and 5 is " + findMin(3, 5));
		float[] ac = access();
		System.out.println("Question 11: " + Arrays.toString(ac));
		System.out.println("Question 12: " + Arrays.toString(getEvens()));
		System.out.println("Question 13: ");
		Triangle();
		//Enter a number to continue the main method
		System.out.println("Question 14 Case 1: " + switchDemo("root"));
		System.out.println("Question 14 Case 2: " + switchDemo("date"));
		System.out.println("Question 14 Case 3: " + switchDemo("split"));
		System.out.println("Question 15: ");
		MathTest();
		int wordLength = numchars(args[0]);
		System.out.println("Question 16: " + "The length of " + args[0] + " is " + wordLength);
		//Enter principal amount, interest percentage and number of years
		System.out.println("Question 17: ");
		FindInterest();
		System.out.println("Question 18: ");
		ConcreteStringDemo();
		System.out.println("Question 19: ");
		ALDemo();
		System.out.println("Question 20: ");
		System.out.print("\n");
		PersonInfo("Data.txt");
		
		
	}
	
	//Q1
	public static int[] BubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length - 1; j++) {
				if ( arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
	
	private static int fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
			
		
	}
	
	//Q2
	public static int[]  PrintFibNums(int n) {
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = fib(i);
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	//Q3
	public static String reverseString(String input) {
		String result = input;
		for (int i = 0; i < result.length()/ 2 ; i++) {
			result = swapchars(result, i, result.length() - 1 - i);
		}
		return result;
	}
	
	private static String swapchars(String input, int a, int b) {
		char[] ch_arr = input.toCharArray();
		char temp = ch_arr[a];
		ch_arr[a] = ch_arr[b];
		ch_arr[b] = temp;
		return String.valueOf(ch_arr);
		
	}
	
	//Q4
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {
			return n * factorial(n -1);
		}
	}
	
	
	//Q5
	public static String SubString(String s, int idx) {
		String result = "";
		for (int i = 0; i < idx; i++) {
			char c = s.charAt(i);
			String letter = Character.toString(c);
			result = result + letter;
		}
		return result;
	}
	
	//Q6
	public static boolean isEven(int n) {
		int test = n / 2;
		if (test * 2 != n) {
			return false;
		}
		return true;
	}
	
	//Q7 
	public static Employee[] showEmployees() {
		Employee bruce = new Employee ("Bruce Fenderson", "Sales", 24);
		Employee bruce_2 = new Employee("Bruce Fenderson", "Sales", 30);
		Employee[] emps = {bruce_2, bruce};
		Employee[] sortedResult = {bruce, bruce_2};
		Arrays.sort(emps, new EmployeeComparator());
		return emps;
	}
	
	//Q8
	public static String[] FindPals() {
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> pals = new ArrayList<String>();
		al.add("karan");
		al.add("madam");
		al.add("tom");
		al.add("civic");
		al.add("radar");
		al.add("jimmy");
		al.add("kayak");
		al.add("john");
		al.add("refer");
		al.add("billy");
		al.add("did");
		for (int i = 0; i < al.size(); i++) {
			StringBuilder temp = new StringBuilder();
			temp.append(al.get(i));
			temp = temp.reverse();
			String newtemp = temp.toString();
			if (al.get(i).equals(newtemp)) {
				pals.add(newtemp);
			}
		}
		return pals.toArray(new String[pals.size()]);
	}
	
	//Q9
	public static Integer[] showPrimes() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			al.add(i);
			if (isPrime(i)) {
				primes.add(i);
			}
			
		}
		System.out.println(Arrays.toString(primes.toArray()));	
		return primes.toArray(new Integer[0]);
	}
	
	private static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = n - 1; i > 1; i--) {
			if (n % i == 0) {
				return false;
	           }
	       }
	       return true;
	}
	
	//Q10
	public static int findMin(int o1, int o2) {
		return o1 < o2 ? o1 : o2;
	}
	
	//Q11
	public static float[] access() {
		float[] floats = new float[2];
		AccessClass ac = new AccessClass(4.0f, 5.0f);
		floats[0] = ac.getValue1();
		floats[1] = ac.getValue2();
		System.out.println(Arrays.toString(floats));
		return floats;
	}
	
	//Q12
	public static Integer[] getEvens() {
		int[] nums = new int[100];
		ArrayList<Integer> evens = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			nums[i-1] = i;
		}
		for (int e : nums) {
			if (isEven(e)) {
				evens.add(e);
			}
		}
		return evens.toArray(new Integer[0]);
		
		
	}
	
	//Q13
	public static String Triangle() {
		StringBuilder sb = new StringBuilder();
		sb.append("0");
		System.out.println(sb.toString());
		for (int i = 1; i <= 3; i++) {
			if (i == 1) {
				sb.insert(0, "1 ");
				System.out.print(sb.toString());
				System.out.print("\n");
			} else if (i == 2) {
				sb.append(" 1");
				System.out.print(sb.toString());
				System.out.print("\n");
			} else {
				sb.insert(0, "0 ");
				System.out.print(sb.toString());
				System.out.print("\n");
			}
	
			
			
		}
		return sb.toString();
	}
	
	//Q14
	public static String switchDemo(String input) {
		
		input = input.toLowerCase();
		switch (input) {
			
		case "root":
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a number: ");
			int n = scanner.nextInt();
			double root = Math.sqrt(n);
			return "The square root of that number is " + String.valueOf(root);
		
		case "date":
			LocalDate today = LocalDate.now();
			return "Today's date is " + today.toString();
			
		case "split":
			String sentence = "I am learning Core Java";
			String[] strArr = sentence.split(" ");
			return "The string has been split into " + Arrays.toString(strArr);
			
		default:
			return "No valid argument entered!";
			
		}
	}
	
	//Q15
	public static void MathTest() {
		MathClass ms = new MathClass();
		System.out.println("Additon of 5 and 2: " + ms.addition(5,  2));
		System.out.println("Subtraction of 5 and 2: " + ms.subtraction(5,  2));
		System.out.println("Multiplication of 5 and 2: " + ms.multiplication(5,  2));
		System.out.println("Division of 5 and 2: " + ms.division(5,  2));
	}
	
	//Q16
	public static int numchars(String input) {
		char[] ch = input.toCharArray();
		return ch.length;
		
	}
	
	//Q17
	public static double FindInterest() {
		Scanner s = new Scanner(System.in);
		System.out.println("Interest Calculator");
		System.out.print("Enter Principal Amount: ");
		double p = s.nextDouble();
		System.out.print(" \n");
		System.out.print("Enter Rate of Interest: ");
		double r = s.nextDouble() / 100;
		System.out.print("\n");
		System.out.print("Enter Time (Years): ");
		double t = s.nextDouble();
		System.out.print("\n");
		double interest = p * r * t;
		System.out.println("The Interest is " + interest);
		s.close();
		return interest;
		
	}
	//This method is for JUnit testing purposes!
	public static double FindInterestManual(double principal, double percentage, int years) {
		double p = principal;
		double r = percentage / 100;
		double t = years;
		double interest = p * r * t;
		return interest;
		
	}
	
	//Q18
	public static void ConcreteStringDemo() {
		ConcreteStringClass cs = new ConcreteStringClass();
		try {
			boolean result = cs.anyUpper("brUce");
			System.out.println("Does the string brUce have any uppercase letters? " + result);
			String result2 = cs.lowertoUpper("bruce");
			System.out.println("The string bruce to all uppercase is? " + result2);
			int result3 = cs.convertString("70");
			System.out.println("70 plus 10 is " + result3);
		} catch (NumberFormatException e) {
			System.out.println("Invalid number entered for convertString method!!");	
		}
	}
	
	//Q19
	public static Integer[] ALDemo() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			al.add(i);
		}
		System.out.println("ArayList: " + Arrays.toString(al.toArray()));
		
		int evensum = 0;
		int oddsum = 0;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (Integer e : al) {
			if (isEven(e)) {
				evensum += e;
			} else if (e % 2 != 0) {
				oddsum += e;
			}
		}
		for (Integer e : al) {
			if(isPrime(e)) {
				primes.add(e);
			}
		}
		al.removeAll(primes);
		System.out.println("Sum of even numbers: " + evensum);
		System.out.println("Sum of odd numbers: " + oddsum);
		System.out.println("Primes removed: " + Arrays.toString(al.toArray()));
		return al.toArray(new Integer[0]);
	}
	
	//Q20
	public static String[] PersonInfo(String input) {
		ArrayList<String> names = new ArrayList<String>();
		try {
			File f = new File(input);
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] word_arr = line.split(":");
				System.out.println("Name: " + word_arr[0] + " " + word_arr[1]);
				System.out.println("Age: " + word_arr[2] + " years");
				System.out.println("State: " + word_arr[3] + " State");
				System.out.print("\n");
				names.add(word_arr[0]);
			}
		s.close();	
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		return names.toArray(new String[names.size()]);
	}
	
}
	


