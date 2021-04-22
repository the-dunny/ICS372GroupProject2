package events;

/**
 * Represents the disarmed request
 * 
 *
 */
public class CancelEvent extends SecuritySystemEvent {
	private static CancelEvent instance;

	/**
	 * private for singleton
	 */

	private CancelEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @Return the only instance
	 */

	public static CancelEvent instance() {
		if (instance == null) {
			instance = new CancelEvent();
		}
		return instance;
	}

}
