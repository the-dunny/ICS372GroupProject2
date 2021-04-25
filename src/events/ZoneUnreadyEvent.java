package events;

/**
 * Represents zone is not ready to arm
 * 
 *
 */
public class ZoneUnreadyEvent extends SecuritySystemEvent {
	private static ZoneUnreadyEvent instance;

	/**
	 * Private for singleton, this Constructor cannot be called from
	 * outside of this class.
	 * 
	 */
	private ZoneUnreadyEvent() {

	}

	/**
	 * For the singleton pattern, this method will return instance, if the
	 * current instance is null, it will instantaite it and return
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
