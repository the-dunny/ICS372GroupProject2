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
	 * Private for the singleton pattern, this Constructor cannot
	 * be called from outside of this class, but will be called from the 
	 * instance method
	 */
	private ArmingState() {

	}

	/**
	 * For singleton, checks to see if current instance field is null. 
	 * if it is it will instantiate it and return
	 * 
	 * @return the ArmingState singleton object
	 */
	public static ArmingState instance() {
		if (instance == null) {
			instance = new ArmingState();
		}
		return instance;
	}

	/**
	 * Process the timer ticked event, it will take a TimerTicketEvent,
	 * , and set the Security System context to the updated time,
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Armed");
	}

	/**
	 * Process the timer ran out event, will set the SecuritySystemContext 
	 * to time 0 and "armed".  If the zones are ready, and arming from = 0, it will
	 * change the state to Stay, if it is 1, it will change the state to away.  If the
	 * zones are not ready it will change staye to Disarmed.
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
	 * Initializes the state, when a state is entered, a new time tracker is created with 10 second,
	 * sets the timer to be to be observed by this ArmingState.
	 * 
	 */
	@Override
	public void enter() {
		timer = new TimeTracker(10, this);
		SecuritySystemContext.instance().showArming();
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Armed");

	}
	
	/**
	 * When the arming state is leaving, it will set the time to 0, and show
	 * the state as Armed, and then show the away state.
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
		SecuritySystemContext.instance().showTimeLeft(0, "Armed");
		SecuritySystemContext.instance().showAway();
	}

}