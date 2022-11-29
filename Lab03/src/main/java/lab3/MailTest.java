/**
 * 
 */
package lab3;

/**
 * @author bipinrai
 *
 */
public class MailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();

		Email senderEmail = new Email("s.kazamia@surrey.ac.uk");
		User sender = new User("Stella Kazamia", senderEmail);

		Email recipientEmail = new Email("unknown@surrey.ac.uk");
		User recipient = new User("Unknown Unknown", recipientEmail);

		String message = "Hello, This is an example of complex objects.";

		Mail emptyEmail = new Mail(sender, recipient, "");
		emptyEmail.print();

		System.out.println();

		Mail finalEmail = new Mail(sender, recipient, message);
		finalEmail.print();


	}

}
