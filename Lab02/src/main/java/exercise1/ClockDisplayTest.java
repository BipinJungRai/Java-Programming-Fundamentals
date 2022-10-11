/**
 * 
 */
package exercise1;

/**
 * @author br00419
 *
 */
public class ClockDisplayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClockDisplay clock = new ClockDisplay(true);
		
		for (int i = 0; i < 100; i++) {
			// The next two lines of code will be executed 100 times.
			clock.timeTick();
			System.out.println(clock.toString());
			}
	}

}
