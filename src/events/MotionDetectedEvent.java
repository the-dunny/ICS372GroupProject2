package events;

/**
 * Represent the motion detector alarm when it detect the motion.
 * 
 * @author Luan Nguyen
 *
 */
public class MotionDetectorAlarmEvent {
	private static MotionDetectorAlarmEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private MotionDetectorAlarmEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static MotionDetectorAlarmEvent instance() {
		if (instance == null) {
			instance = new MotionDetectorAlarmEvent();
		}
		return instance;
	}

}
