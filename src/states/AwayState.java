package states;

import events.MotionDetectedEvent;
import events.ZoneUnreadyEvent;

public class AwayState extends SecuritySystemState {
	private static AwayState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private AwayState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static AwayState instance() {
		if (instance == null) {
			instance = new AwayState();
		}
		return instance;
	}

	@Override
	public void handleEvent(MotionDetectedEvent event) {
		SecuritySystemContext.instance().changeState(TriggeredState.instance());
	}
	@Override
	public void handleEvent(ZoneUnreadyEvent event) {
		SecuritySystemContext.instance().changeState(TriggeredState.instance());
	}

	@Override
	public void enter() {
		SecuritySystemContext.instance().showAway();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
