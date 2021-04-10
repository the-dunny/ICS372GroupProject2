package events;

/**
 * Represent for zone 2 is ready to arm
 * 
 * @author Luan Nguyen
 *
 */
public class Zone2ReadyEvent extends SecuritySystemEvent {
	private static Zone2ReadyEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private Zone2ReadyEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static Zone2ReadyEvent instance() {
		if (instance == null) {
			instance = new Zone2ReadyEvent();
		}
		return instance;
	}

}
