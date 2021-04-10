package states;

import events.Zone2ReadyEvent;

/**
 * Represents the Zone2 is unready for arming
 * 
 * @author Luan Nguyen
 */

public class Zone2UnreadyState extends SecuritySystemState {
	private static Zone2UnreadyState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Zone2UnreadyState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static Zone2UnreadyState instance() {
		if (instance == null) {
			instance = new Zone2UnreadyState();
		}
		return instance;
	}

	/**
	 * handle zone 2 ready event
	 */
	@Override
	public void handleEvent(Zone2ReadyEvent event) {
		SecuritySystemContext.instance().changeState(Zone2UnreadyState.instance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showUnready();

	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().showReady();

	}

}
