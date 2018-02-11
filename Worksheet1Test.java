import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/** 
 * @author andrew cullinane
 * This class contains the test cases for Worksheet1 solutions.
 */

public class Worksheet1Test {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	//Exercise 1 power(2^4)
	@Test
	public void testEx1_1(){
		int expected = 16;
		int obtained = Worksheet1.power(2,4);
		assertEquals(expected, obtained);
	}
	
	//Exercise 1 power(5^0)
	@Test
	public void testEx1_2(){
		int expected = 1;
		int obtained = Worksheet1.power(5, 0);
		assertEquals(expected, obtained);
	}

	//Exercise 1 fastPower(2^4) even exponent
	@Test
	public void testEx1_3(){
		int expected = Worksheet1.power(2,4);
		int obtained = Worksheet1.fastPower(2,4);
		assertEquals(expected, obtained);
	}
	
	//Exercise 1 fastPower(5,5) odd exponent
	@Test
	public void testEx1_4(){
		int expected = 3125;
		int obtained = Worksheet1.fastPower(5,5);
		assertEquals(expected, obtained);
	}
	
	//Exercise 1 fastPower(5^0)
	@Test
	public void testEx1_5(){
		int expected = 1;
		int obtained = Worksheet1.fastPower(5,0);
		assertEquals(expected, obtained);
	}
	
	//Exercise 2 [2,-5,8,0]
	@Test
	public void testEx2_1(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(0, L);
		L = new List<Integer>(8, L);
		L = new List<Integer>(-5, L);
		L = new List<Integer>(2, L);
		
		String expected = "[-2, 5, -8, 0]";
		String obtained = Worksheet1.negateAll(L).toString();
		assertEquals(expected, obtained);
	}
	
	//Exercise 2 []
	@Test
	public void testEx2_2(){
		List<Integer> L = new List<Integer>();
		List<Integer> test = Worksheet1.negateAll(L);
		assertEquals(L.toString(),test.toString());
	}
	
	
	//Exercise 3 find 3 in [7,5,3,8]
	@Test
	public void testEx3_1(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(8, L);
		L = new List<Integer>(3, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(7, L);
		int expected = 2;
		int obtained = Worksheet1.find(3, L);
		assertEquals(expected, obtained);
	}
	
	//Exercise 3 find 3 in [7,5,3,3,8] find first
	@Test
	public void testEx3_2(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(8, L);
		L = new List<Integer>(3, L);
		L = new List<Integer>(3, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(7, L);
		int expected = 2;
		int obtained = Worksheet1.find(3, L);
		assertEquals(expected, obtained);
	}
	
	
	//Exercise 3 x not found
	@Test
	public void testEx3_3(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(8, L);
		L = new List<Integer>(3, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(7, L);
		exception.expect(IllegalArgumentException.class);
		Worksheet1.find(2, L);
	}
	
	//Exercise 4 [2,5,8,0] +> true
	@Test
	public void testEx4_1(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(0, L);
		L = new List<Integer>(8, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(2, L);
		boolean obtained = Worksheet1.allPositive(L);
		assertTrue(obtained);
	}
	
	//Exercise 4 [2,-5,8,0] => false
	@Test
	public void testEx4_2(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(0, L);
		L = new List<Integer>(8, L);
		L = new List<Integer>(-5, L);
		L = new List<Integer>(2, L);
		boolean obtained = Worksheet1.allPositive(L);
		assertFalse(obtained);
	}
	
	//Exercise 4 empty List
	@Test
	public void testEx4_3(){
		List<Integer> L = new List<Integer>();
		boolean obtained = Worksheet1.allPositive(L);
		assertTrue(obtained);
	}
	
	//Exercise 5 [2,3,-5,8,-2]
	@Test
	public void testEx5_1(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(-2, L);
		L = new List<Integer>(8, L);
		L = new List<Integer>(-5, L);
		L = new List<Integer>(3, L);
		L = new List<Integer>(2, L);
		List<Integer> test = Worksheet1.positives(L);
		String expected = "[2, 3, 8]";
		String obtained = test.toString();
		assertEquals(expected, obtained);
	}
	
	//Exercise 5 [-2,-3,-5,-8,-2] => all negative numbers
	@Test
	public void testEx5_2(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(-2, L);
		L = new List<Integer>(-8, L);
		L = new List<Integer>(-5, L);
		L = new List<Integer>(-3, L);
		L = new List<Integer>(-2, L);
		String expected = new List<Integer>().toString();
		String obtained = Worksheet1.positives(L).toString();
		assertEquals(expected, obtained);
	}
	
	//Exercise 5 []
	@Test
	public void testEx5_3(){
		List<Integer> L = new List<Integer>();
		List<Integer> test = Worksheet1.positives(L);
		assertEquals(L,test);
	}
	
	//Exercise 6 [2,3,5,8]
	@Test
	public void testEx6_1(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(8, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(3, L);
		L = new List<Integer>(2, L);
		assertTrue(Worksheet1.sorted(L));
	}
	
	//Exercise 6 [2,3,3,5,8]
	@Test
	public void testEx6_2(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(8, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(3, L);
		L = new List<Integer>(3, L);
		L = new List<Integer>(2, L);
		assertTrue(Worksheet1.sorted(L));
	}
	
	//Exercise 6 [2,8,3,5]
	@Test
	public void testEx6_3(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(5, L);
		L = new List<Integer>(3, L);
		L = new List<Integer>(8, L);
		L = new List<Integer>(2, L);
		assertFalse(Worksheet1.sorted(L));
	}
	
	//Exercise 6 empty List
	@Test
	public void testEx6_4(){
		List<Integer> L = new List<Integer>();
		assertTrue(Worksheet1.sorted(L));
	}
	
	//Exercise 6 [2]
	@Test
	public void testEx6_5(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(2, L);
		assertTrue(Worksheet1.sorted(L));
	}
	
	//Exercise 7 [2,5,5,8] + [5,7,8,9]
	@Test
	public void testEx7_1(){
		List<Integer> a = new List<Integer>();
		a = new List<Integer>(8, a);
		a = new List<Integer>(5, a);
		a = new List<Integer>(5, a);
		a = new List<Integer>(2, a);
		List<Integer> b = new List<Integer>();
		b = new List<Integer>(9, b);
		b = new List<Integer>(8, b);
		b = new List<Integer>(7, b);
		b = new List<Integer>(5, b);
		String expected = "[2, 5, 5, 5, 7, 8, 8, 9]";
		String obtained = Worksheet1.merge(a, b).toString();
		assertEquals(expected, obtained);
	}
	
	//Exercise 7 [2,5,5,8] + [9]
	@Test
	public void testEx7_2(){
		List<Integer> a = new List<Integer>();
		a = new List<Integer>(8, a);
		a = new List<Integer>(5, a);
		a = new List<Integer>(5, a);
		a = new List<Integer>(2, a);
		List<Integer> b = new List<Integer>();
		b = new List<Integer>(9, b);
		String expected = "[2, 5, 5, 8, 9]";
		String obtained = Worksheet1.merge(a, b).toString();
		assertEquals(expected, obtained);
	}
	
	//Exercise 7 [2,5,5,8] + []
	@Test
	public void testEx7_3(){
		List<Integer> a = new List<Integer>();
		a = new List<Integer>(8, a);
		a = new List<Integer>(5, a);
		a = new List<Integer>(5, a);
		a = new List<Integer>(2, a);
		List<Integer> b = new List<Integer>();
		List<Integer> test = Worksheet1.merge(a, b);
		assertEquals(a, test);
	}

	//Exercise 7 [] + [5,7,8,9]
	@Test
	public void testEx7_4(){
		List<Integer> a = new List<Integer>();
		List<Integer> b = new List<Integer>();
		b = new List<Integer>(9, b);
		b = new List<Integer>(8, b);
		b = new List<Integer>(7, b);
		b = new List<Integer>(5, b);
		List<Integer> test = Worksheet1.merge(a, b);
		assertEquals(b, test);
	}

	//Exercise 7 [] + []
	@Test
	public void testEx7_5(){
		List<Integer> a = new List<Integer>();
		List<Integer> b = new List<Integer>();
		List<Integer> test = Worksheet1.merge(a, b);
		assertTrue(test.isEmpty());
	}
	
	//Exercise 8 [2,5,5,5,7,8,8,9]
	@Test
	public void testEx8_1(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(9, L);
		L = new List<Integer>(8, L);
		L = new List<Integer>(8, L);
		L = new List<Integer>(7, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(2, L);
		String expected = "[2, 5, 7, 8, 9]";
		String obtained = Worksheet1.removeDuplicates(L).toString();
		assertEquals(expected, obtained);
	}
	
	//Exercise [-5,-5,-2,-2,2,2,5,5] negative numbers
	@Test
	public void testEx8_2(){
		List<Integer> L = new List<Integer>();
		L = new List<Integer>(5, L);
		L = new List<Integer>(5, L);
		L = new List<Integer>(2, L);
		L = new List<Integer>(2, L);
		L = new List<Integer>(-2, L);
		L = new List<Integer>(-2, L);
		L = new List<Integer>(-5, L);
		L = new List<Integer>(-5, L);
		String expected = "[-5, -2, 2, 5]";
		String obtained = Worksheet1.removeDuplicates(L).toString();
		assertEquals(expected, obtained);
	}
	
	//Exercise 8 [2]
	@Test
	public void testEx8_3(){
		List<Integer> L = new List<Integer>();
		L= new List<Integer>(2,L);
		List<Integer> test = Worksheet1.removeDuplicates(L);
		int expected = 2;
		int obtained = test.getHead();
		assertEquals(expected, obtained);
	}
	
	//Exercise 8 []
	@Test
	public void testEx8_4(){
		List<Integer> L = new List<Integer>();
		List<Integer> test = Worksheet1.removeDuplicates(L);
		assertEquals(L,test);
	}
	
}
