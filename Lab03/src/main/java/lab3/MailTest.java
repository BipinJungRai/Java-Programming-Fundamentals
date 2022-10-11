/**
 * 
 */
package lab3;

/**
 * @author br00419
 *
 */
public class MailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
		MailSimple ms = new MailSimple("sender@surrey.ac.uk", "recipient@surrey.ac.uk", "Hello");
		
		
		ms.print();
		
		private static final String DEFAULT_ADDRESS = "unknown@unknown";
		private String emailAddress = DEFAULT_ADDRESS;
	}

}
