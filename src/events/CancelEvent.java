package events;

/**
 * Represents the disarmed request
 * 
 *
 */
public class CancelEvent extends SecuritySystemEvent {
	private static CancelEvent instance;

	/**
	 * private for singleton, this conrtuctor does not set any fields,
	 * if the public instance method is called, it will be called but only from
	 * within the class.
	 */

	private CancelEvent() {

	}

	/**
	 * For the singleton pattern, this is the public method that allows outside classes,
	 * to have a Cancel Event
	 * 
	 * @Return the only instance
	 */

	public static CancelEvent instance() {
		if (instance == null) {
			instance = new CancelEvent();
		}
		return instance;
	}

}
