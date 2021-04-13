package states;

import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Timer;

/**
 * Represent the system is disarmed
 * 
 * @author Luan Nguyen
 *
 */
public class ArmingState extends SecuritySystemState {
	private static ArmingState instance;
	private Timer timer;

	private ArmingState() {

	}

	public static ArmingState instance() {
		if (instance == null) {
			instance = new ArmingState();
		}
		return instance;
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		SecuritySystemContext.instance().changeState(AwayState.instance());
	}

	@Override
	public void enter() {
		SecuritySystemContext.instance().showArming();

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}