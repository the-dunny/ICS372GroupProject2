package events;

/**
 * Represents the password input
 *
 */
public class PasswordEnteredEvent {
	private static PasswordEnteredEvent instance;

	/**
	 * private for singleton, constructor cannot be called from
	 * outside of this class
	 */

	private PasswordEnteredEvent() {

	}

	/**
	 * For the singleton pattern, it no instance exists, then call constructor
	 * to instantiate the instance, otherwise return the existing PasswordEnteredEvent
	 * 
	 * @Return the only instance pf PasswordEnteredEvent
	 */

	public static PasswordEnteredEvent instance() {
		if (instance == null) {
			instance = new PasswordEnteredEvent();
		}
		return instance;
	}
}
