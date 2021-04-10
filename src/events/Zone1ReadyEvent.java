package events;

/**
 * Represent for all zones are ready to arm
 * 
 * @author Luan Nguyen
 *
 */
public class Zone1ReadyEvent extends SecuritySystemEvent {
	private static Zone1ReadyEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private Zone1ReadyEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static Zone1ReadyEvent instance() {
		if (instance == null) {
			instance = new Zone1ReadyEvent();
		}
		return instance;
	}

}
