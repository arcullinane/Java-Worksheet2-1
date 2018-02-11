/**
 * This class contains the solution for Worksheet1
 * @author andrew cullinane 
 */

public class Worksheet1 {
	
	// Exercise 1
	/**
	 * Method to calculate m^n
	 * @param m as int for the base
	 * @param n as int for the exponent
	 * @return m^n as int
	 */
	public static int power(int m, int n) {
		if (n == 0) {
			return 1;
		} else {
			return m * power(m, n - 1);
		}
	}
	
	/**
	 * Faster method to calculate m^n
	 * @param m as int for the base
	 * @param n as int for the exponent
	 * @return m^n as int
	 */
	public static int fastPower(int m, int n) {
		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			return fastPower(m, n / 2) * fastPower(m, n / 2);
		} else {
			return m * fastPower(m, n - 1);
		}
	}

	// Exercise 2
	/**
	 * Method to negate all values in a List
	 * @param a List of Integers
	 * @return List of Integers
	 */
	public static List<Integer> negateAll(List<Integer> a) {
		if (a.isEmpty()) {
			return a;
		} else {
			return new List<Integer>(a.getHead() * -1, negateAll(a.getTail()));
		}
	}

	// Exercise 3
	/**
	 * Method to find if and where a value is in a List
	 * @param x as int for the value needed to be found
	 * @param a List of Integers
	 * @return position of x in List a as an int
	 * @throws IllegalArgumentException if x is not found
	 */
	public static int find(int x, List<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalArgumentException("Not found");
		} else {
			if (a.getHead() == x) {
				return 0;
			} else {
				return 1 + find(x, a.getTail());
			}
		}
	}

	// Exercise 4
	/**
	 * Method to check if all values in a list are positive
	 * @param a List of Integers
	 * @return true if all values are positive
	 */
	public static boolean allPositive(List<Integer> a) {
		if (a.isEmpty()) {
			return true;
		} else {
			if (a.getHead() < 0) {
				return false;
			} else {
				return allPositive(a.getTail());
			}
		}
	}

	// Exercise 5
	/**
	 * Method to create new list of positive integers from a given list of integers
	 * @param a List of integers
	 * @return List of positive integers from a
	 */
	public static List<Integer> positives(List<Integer> a) {
		if (a.isEmpty()) {
			return a;
		} else {
			if (a.getHead() >= 0) {
				return new List<Integer>(a.getHead(), positives(a.getTail()));
			} else {
				return positives(a.getTail());
			}
		}
	}

	// Exercise 6
	/**
	 * Method to check if a List is sorted
	 * @param a List of Integers
	 * @return true if List is sorted in ascending order (duplicates allowed)
	 */
	public static boolean sorted(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) {
			return true;
		} else {
			if (a.getHead() <= a.getTail().getHead()) {
				return sorted(a.getTail());
			} else {
				return false;
			}
		}
	}

	// Exercise 7
	/**
	 * Method to merge two Lists (allows duplicates)
	 * @param a List of Integers sorted in ascending order
	 * @param b List of Integers sorted in ascending order
	 * @return List of sorted Integers containing integers from a and b
	 */
	public static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if (a.isEmpty()) {
			return b;
		} else if (b.isEmpty()) {
			return a;
		} else {
			if (a.getHead() <= b.getHead()) {
				return new List<Integer>(a.getHead(), merge(a.getTail(), b));
			} else {
				return new List<Integer>(b.getHead(), merge(a, b.getTail()));
			}
		}
	}
	
	// Exercise 8
	/**
	 * Method to remove duplicates from a list of Integers
	 * @param a List of Integers sorted in ascending order
	 * @return List of Integers without duplicates sorted in ascending order
	 */
	static List<Integer> removeDuplicates(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) {
			return a;
		} else {
			if (a.getHead() == a.getTail().getHead()) {
				return removeDuplicates(a.getTail());
			} else {
				return new List<Integer>(a.getHead(), removeDuplicates(a.getTail()));
			}
		}
	}

}
