package states;

import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.TimeTracker;

/**
 * Represent the system is disarmed
 * 
 * @author Luan Nguyen
 *
 */
public class ArmingState extends SecuritySystemState implements Notifiable {
	private static ArmingState instance;
	private TimeTracker timer;

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
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Arm");
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		SecuritySystemContext.instance().showTimeLeft(0, "Arm");
		SecuritySystemContext.instance().changeState(AwayState.instance());
	}

	@Override
	public void enter() {
		timer = new TimeTracker(10, this);
		SecuritySystemContext.instance().showArming();
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Arm");

	}

	@Override
	public void leave() {
		timer = null;
		SecuritySystemContext.instance().showTimeLeft(0, "Arm");

	}

}