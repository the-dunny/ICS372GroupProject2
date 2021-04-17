package states;

import events.ArmingRequestEvent;
import events.CancelEvent;
import events.ZoneUnreadyEvent;

public class StayState extends SecuritySystemState {
	private static StayState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private StayState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static StayState instance() {
		if (instance == null) {
			instance = new StayState();
		}
		return instance;
	}

	@Override
	public void handleEvent(ArmingRequestEvent event) {
		SecuritySystemContext.instance().changeState(ArmingState.instance());
	}

	@Override
	public void handleEvent(ZoneUnreadyEvent event) {
		SecuritySystemContext.instance().changeState(TriggeredState.instance());
	}

	@Override
	public void handleEvent(CancelEvent event) {
		SecuritySystemContext.instance().changeState(DisarmedState.instance());
	}

	@Override
	public void enter() {
		SecuritySystemContext.instance().showStay();

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}