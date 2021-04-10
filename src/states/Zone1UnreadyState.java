package states;

import events.Zone1ReadyEvent;

/**
 * Represents the Zone1 is unready for arming
 * 
 * @author Luan Nguyen
 */
public class Zone1UnreadyState extends SecuritySystemState {
	private static Zone1UnreadyState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Zone1UnreadyState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static Zone1UnreadyState instance() {
		if (instance == null) {
			instance = new Zone1UnreadyState();
		}
		return instance;
	}

	@Override
	public void handleEvent(Zone1ReadyEvent event) {
		SecuritySystemContext.instance().changeState(Zone1UnreadyState.instance());
	}

	@Override
	public void enter() {
		SecuritySystemContext.instance().showUnready();

	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().showReady();

	}

}
