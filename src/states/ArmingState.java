package states;

import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.TimeTracker;

/**
 * Represents the arming state
 * 
 *
 */
public class ArmingState extends SecuritySystemState implements Notifiable {
	private static ArmingState instance;
	private TimeTracker timer;

	/**
	 * Private for the singleton pattern
	 */
	private ArmingState() {

	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static ArmingState instance() {
		if (instance == null) {
			instance = new ArmingState();
		}
		return instance;
	}

	/**
	 * Process the timer ticked event
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Armed");
	}

	/**
	 * Process the timer ran out event
	 */
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

	/**
	 * Initializes the state
	 * 
	 */
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