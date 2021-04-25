package events;

/**
 * Represents the stay request event
 *
 */
public class StayRequestEvent extends SecuritySystemEvent {
	private static StayRequestEvent instance;

	/**
	 * private for singleton, Constructor cannot be called
	 * from outside of this class
	 */

	private StayRequestEvent() {

	}

	/**
	 * For the singleton pattern, this method will return a new instance
	 * of StayRequestEvent if the instance field is null (hasn't been called yet)
	 * or return the instance method if it has.
	 * 
	 * @Return the only instance of StayRequestEvent
	 */

	public static StayRequestEvent instance() {
		if (instance == null) {
			instance = new StayRequestEvent();
		}
		return instance;
	}
}
