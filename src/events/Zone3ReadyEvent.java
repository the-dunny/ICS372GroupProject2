package events;

/**
 * Represent for zone 3 is ready to arm
 * 
 * @author Luan Nguyen
 *
 */
public class Zone3ReadyEvent extends SecuritySystemEvent {
	private static Zone3ReadyEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private Zone3ReadyEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static Zone3ReadyEvent instance() {
		if (instance == null) {
			instance = new Zone3ReadyEvent();
		}
		return instance;
	}
}
