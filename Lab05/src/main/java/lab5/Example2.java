package lab5;

/**
 * A simple class used to demonstrate deficiencies in arrays.
 * 
 * @author Stella Kazamia
 * 
 */
public class Example2 {

	public static void main(String[] args) {

		// Add your code here
		
		for (int i = 1; i <= 6; i++) {
			int baby = i;
			String output = "" + i;
		
			for (int babycakes = 0; babycakes < 3; babycakes++) {
				baby = baby + 2;
				output = output + " " + (baby);
				
			}
			System.out.println(output);
		}
	}
}
