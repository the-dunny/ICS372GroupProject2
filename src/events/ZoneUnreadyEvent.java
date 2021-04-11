package events;

/**
 * Represents all zones are unready to arm
 * 
 * @author Luan Nguyen
 *
 */
public class ZoneUnreadyEvent extends SecuritySystemEvent {
	private static ZoneUnreadyEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private ZoneUnreadyEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static ZoneUnreadyEvent instance() {
		if (instance == null) {
			instance = new ZoneUnreadyEvent();
		}
		return instance;
	}

}
