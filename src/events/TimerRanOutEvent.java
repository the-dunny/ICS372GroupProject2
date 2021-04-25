package events;

/**
 * Represent the time ran out event
 * 
 *
 */
public class TimerRanOutEvent extends SecuritySystemEvent {
	private static TimerRanOutEvent instance;

	/**
	 * Private for singleton, Constructor can not be called from outside of this
	 * class
	 * 
	 */
	private TimerRanOutEvent() {

	}

	/**
	 * For the singleton pattern, returns the instance field.  If the field
	 * is null, it instantiates it by called the Constructor, and then returns
	 * the instance field
	 * 
	 * @return the only instance
	 */
	public static TimerRanOutEvent instance() {
		if (instance == null) {
			instance = new TimerRanOutEvent();
		}
		return instance;
	}

}
