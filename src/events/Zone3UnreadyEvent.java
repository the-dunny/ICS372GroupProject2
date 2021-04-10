package events;

/**
 * Represents zone 3 is unready to arm
 * 
 * @author Luan Nguyen
 *
 */
public class Zone3UnreadyEvent extends SecuritySystemEvent {
	private static Zone3UnreadyEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private Zone3UnreadyEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static Zone3UnreadyEvent instance() {
		if (instance == null) {
			instance = new Zone3UnreadyEvent();
		}
		return instance;
	}
}
