package events;

public class ArmingRequestEvent extends SecuritySystemEvent {
	private static ArmingRequestEvent instance;

	/**
	 * private for singleton
	 */

	private ArmingRequestEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @Return the only instance
	 */

	public static ArmingRequestEvent intance() {
		if (instance == null) {
			instance = new ArmingRequestEvent();
		}
		return instance;
	}

}
