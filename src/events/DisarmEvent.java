package events;

/**
 * Represents the disarmed request, where the password is entered and then cancel is pressed
 * 
 * @author Luan Nguyen
 *
 */
public class PasswordEnteredEvent extends SecuritySystemEvent {
	private static PasswordEnteredEvent instance;

	/**
	 * private for singleton
	 */

	private PasswordEnteredEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @Return the only instance
	 */

	public static PasswordEnteredEvent intance() {
		if (instance == null) {
			instance = new PasswordEnteredEvent();
		}
		return instance;
	}

}
