package states;

import events.DisarmedRequestEvent;
import events.Zone1ReadyEvent;

public class ArmedState extends SecuritySystemState {
	private static ArmedState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private ArmedState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static ArmedState instance() {
		if (instance == null) {
			instance = new ArmedState();
		}
		return instance;
	}

	@Override
	public void handleEvent(MotionDetectirAlarmEvent event) {
		SecuritySystemContext.instance().changeState(TriggeredState.instance());
	}
	@Override
	public void handleEvent(UnreadyEvent event) {
		SecuritySystemContext.instance().changeState(TriggeredState.instance());
	}
	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
