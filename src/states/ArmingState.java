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
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Armed");
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		SecuritySystemContext.instance().showTimeLeft(0, "Armed");
		if (SecuritySystemContext.instance().readyCheck()) {
			if (SecuritySystemContext.instance().getArmingFrom() == 0) {
				SecuritySystemContext.instance().changeState(StayState.instance());
			} else {
				SecuritySystemContext.instance().changeState(AwayState.instance());
			}
		} else {
			SecuritySystemContext.instance().changeState(DisarmedState.instance());
		}
	}

	@Override
	public void enter() {
		timer = new TimeTracker(10, this);
		SecuritySystemContext.instance().showArming();
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Armed");

	}

	@Override
	public void leave() {
		timer = null;
		SecuritySystemContext.instance().showTimeLeft(0, "Armed");
		SecuritySystemContext.instance().showAway();
	}

}