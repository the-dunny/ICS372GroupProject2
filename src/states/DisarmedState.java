package states;

import events.ArmingRequestEvent;
import events.StayRequestEvent;

/**
 * Represent the system is disarmed
 * 
 * @author Luan Nguyen
 *
 */
public class DisarmedState extends SecuritySystemState {
	private static DisarmedState instance;

	private DisarmedState() {

	}

	public static DisarmedState instance() {
		if (instance == null) {
			instance = new DisarmedState();
		}
		return instance;
	}

	@Override
	public void handleEvent(ArmingRequestEvent event) {
		SecuritySystemContext.instance().changeState(ArmingState.instance());
	}

	@Override
	public void handleEvent(StayRequestEvent event) {
		SecuritySystemContext.instance().changeState(StayState.instance());
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
