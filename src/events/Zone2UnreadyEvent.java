package events;

/**
 * Represents zone 2 is unready to arm
 * 
 * @author Luan Nguyen
 *
 */
public class Zone2UnreadyEvent extends SecuritySystemEvent {
	private static Zone2UnreadyEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private Zone2UnreadyEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static Zone2UnreadyEvent instance() {
		if (instance == null) {
			instance = new Zone2UnreadyEvent();
		}
		return instance;
	}
}
