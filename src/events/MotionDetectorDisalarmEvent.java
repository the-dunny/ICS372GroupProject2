package events;

/**
 * Represents the motion detector is quiet/disalarm when it does not detect any
 * motion
 * 
 * @author Luan Nguyen
 *
 */
public class MotionDetectorDisalarmEvent {
	private static MotionDetectorDisalarmEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private MotionDetectorDisalarmEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static MotionDetectorDisalarmEvent instance() {
		if (instance == null) {
			instance = new MotionDetectorDisalarmEvent();
		}
		return instance;
	}

}
