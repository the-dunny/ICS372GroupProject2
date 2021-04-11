package events;

/**
 * Represents the disarmed request, where the password is entered and then cancel is pressed
 * 
 * @author Luan Nguyen
 *
 */
public class DisarmEvent extends SecuritySystemEvent {
	private static DisarmEvent instance;

	/**
	 * private for singleton
	 */

	private DisarmEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @Return the only instance
	 */

	public static DisarmEvent intance() {
		if (instance == null) {
			instance = new DisarmEvent();
		}
		return instance;
	}

}
