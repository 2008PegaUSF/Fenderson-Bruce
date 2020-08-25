import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import corejavaassignment.ConcreteStringClass;
import corejavaassignment.Employee;
import corejavaassignment.EmployeeComparator;
import corejavaassignment.JavaAssignment;
import corejavaassignment.MathClass;


public class CoreTests {
	
	//Q1
	@Test
	public void BubbleTest() {
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] result = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		Assertions.assertArrayEquals(result, JavaAssignment.BubbleSort(arr));
	}
	
	//Q2
	@Test
	public void fibTest() {
		int[] fibRes = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		Assertions.assertArrayEquals(fibRes, JavaAssignment.PrintFibNums(25));
	}
	
	//Q3
	@Test
	public void StringReverseTest() {
		Assertions.assertEquals("ecurB", JavaAssignment.reverseString("Bruce"));
	}
	
	//Q4
	@Test
	public void factorialTest() {
		Assertions.assertEquals(6, JavaAssignment.factorial(3));
		
	}
	
	//Q5
	@Test
	public void subStringTest() {
		Assertions.assertEquals("bru", JavaAssignment.SubString("bruce", 3));
	}
	
	//Q6
	@Test
	public void evenTest() {
		Assertions.assertFalse(JavaAssignment.isEven(7));
	}
	
	//Q7
	@Test
	public void sortTest() {
		Employee bruce = new Employee ("Bruce Fenderson", "Sales", 24);
		Employee bruce_2 = new Employee("Bruce Fenderson", "Sales", 30);
		Employee[] emps = {bruce_2, bruce};
		Employee[] sortedResult = {bruce, bruce_2};
		Arrays.sort(emps, new EmployeeComparator());
		Assertions.assertArrayEquals(sortedResult, emps);
	}
	
	//Q8
	@Test
	public void testpals() {
		String[] pals = {"madam", "civic", "radar", "kayak", "refer", "did"};
		Assertions.assertArrayEquals(pals, JavaAssignment.FindPals());
	}
	
	//Q9
	@Test
	public void testPrimes() {
		Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		Assertions.assertArrayEquals(primes, JavaAssignment.showPrimes());
		
	}
	
	//Q10
	@Test
	public void testMin() {
		Assertions.assertEquals(2, JavaAssignment.findMin(2, 5));
	}
	
	//Q11
	@Test
	public void accessTest() {
		float[] result = {4.0f, 5.0f};
		Assertions.assertArrayEquals(result, JavaAssignment.access());
	}
	
	//Q12
	@Test
	public void evensTest() {
		Integer[] evens = new Integer[50];
		int count = 0;
		for (int i = 0; i < evens.length; i++) {
			evens[i] = i + 2 + count;
			count++;
		}
		Assertions.assertArrayEquals(evens, JavaAssignment.getEvens());
	}
	
	//Q13
	@Test
	public void triangleTest() {
		Assertions.assertEquals("0 1 0 1", JavaAssignment.Triangle());
	}
	
	//Q14
	@Test
	public void caseTest() {
		LocalDate today = LocalDate.now();
		Assertions.assertEquals("Today's date is " + today.toString() , JavaAssignment.switchDemo("date"));
	}
	
	//Q15
	@Test
	public void MathTest() {
		MathClass mc = new MathClass();
		Assertions.assertEquals(7.0d, mc.addition(5.0d, 2.0d));
	}
	
	//Q16
	@Test
	public void wordTest() {
		Assertions.assertEquals(5, JavaAssignment.numchars("Hello"));
	}
	
	//Q17
	@Test 
	public void interestTest() {
		Assertions.assertEquals(1200d, JavaAssignment.FindInterestManual(10000, 3, 4));
	}
	
	//Q18
	@Test
	public void concreteTest() {
		ConcreteStringClass cs = new ConcreteStringClass();
		Assertions.assertTrue(cs.anyUpper("Bruce"));
	}
	
	//Q19
	@Test
	public void primesGone() {
		Integer[] result = {1, 4, 6, 8, 9, 10};
		Assertions.assertArrayEquals(result, JavaAssignment.ALDemo());
	}
	
	//Q20
	@Test
	public void personTest() {
		String[] test = {"Mickey", "Hulk", "Roger", "Wonder"};
		Assertions.assertArrayEquals(test, JavaAssignment.PersonInfo("Data.txt"));
		
	}

	
	
}
