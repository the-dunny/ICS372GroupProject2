package events;

/**
 * Represents the arming request
 *
 */
public class ArmingRequestEvent extends SecuritySystemEvent {
	private int armingFrom;

	/**
	 * Constructor
	 * 
	 * @param armingFrom
	 */
	public ArmingRequestEvent(int armingFrom) {
		this.armingFrom = armingFrom;
	}

	/**
	 * Getter method
	 * 
	 * @return armingFrom
	 */
	public int getArmingFrom() {
		return armingFrom;
	}

}
