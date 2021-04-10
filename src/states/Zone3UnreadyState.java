package states;

import events.Zone3ReadyEvent;

/**
 * Represents the Zone3 is unready for arming
 * 
 * @author Luan Nguyen
 */
public class Zone3UnreadyState  extends SecuritySystemState{
	private static Zone3UnreadyState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Zone3UnreadyState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static Zone3UnreadyState instance() {
		if (instance == null) {
			instance = new Zone3UnreadyState();
		}
		return instance;
	}

	@Override
	public void handleEvent(Zone3ReadyEvent event) {
		SecuritySystemContext.instance().changeState(Zone3UnreadyState.instance());
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
