package states;

import events.Zone1UnreadyEvent;

/**
 * Represents the Zone 1 state is ready to arm
 * 
 * @author Luan Nguyen
 *
 */
public class Zone1ReadyState extends SecuritySystemState {
	private static Zone1ReadyState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Zone1ReadyState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static Zone1ReadyState instance() {
		if (instance == null) {
			instance = new Zone1ReadyState();
		}
		return instance;
	}

	/**
	 * handle zone 1 ready event
	 */
	@Override
	public void handleEvent(Zone1UnreadyEvent event) {
		SecuritySystemContext.instance().changeState(Zone1UnreadyState.instance());
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
