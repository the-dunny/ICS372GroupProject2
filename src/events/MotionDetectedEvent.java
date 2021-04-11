package events;

/**
 * Represent the motion detector alarm when it detect the motion.
 * 
 * @author Luan Nguyen
 *
 */
public class MotionDetectedEvent {
	private static MotionDetectedEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private MotionDetectedEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static MotionDetectedEvent instance() {
		if (instance == null) {
			instance = new MotionDetectedEvent();
		}
		return instance;
	}

}
