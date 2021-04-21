package events;

public class PasswordEnteredEvent {
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

	public static PasswordEnteredEvent instance() {
		if (instance == null) {
			instance = new PasswordEnteredEvent();
		}
		return instance;
	}
}
