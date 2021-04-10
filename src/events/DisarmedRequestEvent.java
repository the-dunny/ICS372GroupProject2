package events;

/**
 * Represents the disarmed request
 * 
 * @author Luan Nguyen
 *
 */
public class DisarmedRequestEvent extends SecuritySystemEvent {
	private static DisarmedRequestEvent instance;

	/**
	 * private for singleton
	 */

	private DisarmedRequestEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @Return the only instance
	 */

	public static DisarmedRequestEvent intance() {
		if (instance == null) {
			instance = new DisarmedRequestEvent();
		}
		return instance;
	}

}
