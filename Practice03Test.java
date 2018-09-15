import java.util.Random;


public class Practice03Test {

	protected int count = 0;
	protected double [] arr;


	/**
	 * Constructor
	 */
	public Practice03Test (String [] args) {
		try {
			count = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Defaulting array size to 20.");
			count = 20;
		}
		arr = new double[count];
		generate_array();
	}


	/**
	 * print_array: prints the array of doubles... formatted so it fits
	 * ... on many small screens.
	 */
	public void print_array() {
		System.out.println("------------------------------------");
		System.out.println("Array contains the values:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
			if (i > 0 && i % 9 == 0)
				System.out.println();
		}
		System.out.println("\n------------------------------------");
	}


	/**
	 * Fills the array with random double instances.
	 */
	public void generate_array() {
		Random rand = new Random();
		double min = 1.0;
		double max = 100.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + rand.nextDouble() * (max-min);
		}
	}


	public int find_min_iterative () {
		// TODO: Fill in this iterative function.
		int min = 0; 							// O(1)
		
		for(int i = 0; i < arr.length; i++) {	 // O(1)
			if(arr[i] < arr[min]) { 			//O(n)
				min = i; 						// O(1)
			}
		}
		return min; 							//O(1)
	}										// --------
									// Iterative is	O(n)


	public int find_min_recursive (int array_length) {
		// TODO: Fill in this recursive function.
		
		if(array_length == 0) {							// O(1)
			return 0; 									//O(1)
		}
		int min = find_min_recursive(array_length - 1); // O(n)
		
		if(arr[min] > arr[array_length]) { 				// O(1)
			return array_length; 						//O(1)
		}
		return min;										// O(1)
	}												// --------
										// Recursive is O(n)

	/**
	 * print_min: determines the min iteratively and recursively.
	 * ... and prints them both.
	 */
	public void print_min() {
		System.out.println("Iteratively determined min at index " + find_min_iterative());
		System.out.println("Recursively determined min at index " + find_min_recursive (arr.length-1));
		
	}


	/**
	 * main for Practice 03: print the array and determine the min.
	 */
	public static void main(String [] args) {
		Practice03Test test = new Practice03Test(args);
		test.print_array();
		test.print_min();
	}

}
