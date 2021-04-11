package states;

import events.TimerRanOutEvent;

/**
 * Represent the system is disarmed
 * 
 * @author Luan Nguyen
 *
 */
public class ArmingState extends SecuritySystemState {
	private static ArmingState instance;

	private ArmingState() {

	}

	public static ArmingState instance() {
		if (instance == null) {
			instance = new ArmingState();
		}
		return instance;
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		SecuritySystemContext.instance().changeState(AwayState.instance());
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