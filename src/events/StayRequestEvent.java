package events;

/**
 * Represents the stay request
 *
 */
public class StayRequestEvent extends SecuritySystemEvent {
	private static StayRequestEvent instance;

	/**
	 * private for singleton
	 */

	private StayRequestEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @Return the only instance
	 */

	public static StayRequestEvent instance() {
		if (instance == null) {
			instance = new StayRequestEvent();
		}
		return instance;
	}
}
