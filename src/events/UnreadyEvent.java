package events;

/**
 * Represents all zones are unready to arm
 * 
 * @author Luan Nguyen
 *
 */
public class Zone1UnreadyEvent extends SecuritySystemEvent {
	private static Zone1UnreadyEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private Zone1UnreadyEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static Zone1UnreadyEvent instance() {
		if (instance == null) {
			instance = new Zone1UnreadyEvent();
		}
		return instance;
	}

}
