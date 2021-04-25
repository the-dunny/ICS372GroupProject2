package events;

/**
 * Represent the motion detector alarm when it detect the motion.
 * 
 *
 */
public class MotionDetectedEvent {
	private static MotionDetectedEvent instance;

	/**
	 * Private for singleton, constructor class cannot be called from outside
	 * of this class
	 * 
	 */
	private MotionDetectedEvent() {

	}

	/**
	 * For the singleton pattern, if the instance hasn't been used yet, it will make a new 
	 * one, if it has, it will return the singleton instance of
	 * MotionDetectedEvent
	 * 
	 * @return the only instance of MotionDetectedEvent
	 */
	public static MotionDetectedEvent instance() {
		if (instance == null) {
			instance = new MotionDetectedEvent();
		}
		return instance;
	}

}
