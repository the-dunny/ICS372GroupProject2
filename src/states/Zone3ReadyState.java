package states;

import events.Zone3UnreadyEvent;

/**
 * Represents the Zone3 is ready for arming
 * 
 * @author Luan Nguyen
 */
public class Zone3ReadyState extends SecuritySystemState{
	private static Zone3ReadyState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Zone3ReadyState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static Zone3ReadyState instance() {
		if (instance == null) {
			instance = new Zone3ReadyState();
		}
		return instance;
	}

	/**
	 * handle zone 2 unready event
	 */
	@Override
	public void handleEvent(Zone3UnreadyEvent event) {
		SecuritySystemContext.instance().changeState(Zone3UnreadyState.instance());
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
