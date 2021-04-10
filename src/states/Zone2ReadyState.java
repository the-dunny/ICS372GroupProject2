package states;

import events.Zone2UnreadyEvent;


/**
 * Represents the Zone2 is ready for arming
 * 
 * @author Luan Nguyen
 */
public class Zone2ReadyState extends SecuritySystemState {
	private static Zone2ReadyState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Zone2ReadyState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static Zone2ReadyState instance() {
		if (instance == null) {
			instance = new Zone2ReadyState();
		}
		return instance;
	}

	/**
	 * handle zone 2 unready event
	 */
	@Override
	public void handleEvent(Zone2UnreadyEvent event) {
		SecuritySystemContext.instance().changeState(Zone2UnreadyState.instance());
	}

	// TODO Do not know should handle arming request here or somewhere else

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showReady();

	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().showUnready();

	}

}
