package states;

import events.PasswordEnteredEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.TimeTracker;

/**
 * Represents triggered state
 * 
 *
 * 
 */
public class TriggeredState extends SecuritySystemState implements Notifiable {
	private static TriggeredState instance;
	private TimeTracker timer;

	/**
	 * Make it a singleton
	 */
	private TriggeredState() {

	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static TriggeredState instance() {
		if (instance == null) {
			instance = new TriggeredState();
		}
		return instance;
	}

	/**
	 * Handle password entered event
	 */
	@Override
	public void handleEvent(PasswordEnteredEvent event) {
		timer.stop();
		SecuritySystemContext.instance().changeState(DisarmedState.instance());
	}

	/**
	 * Handle the timer ticked event
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Breach");
	}

	/**
	 * Handle the time ran out event
	 */
	@Override
	public void handleEvent(TimerRanOutEvent event) {
		SecuritySystemContext.instance().changeState(BreachedState.instance());
	}

	/**
	 * Initializes state
	 */
	@Override
	public void enter() {
		timer = new TimeTracker(15, this);
		SecuritySystemContext.instance().showTriggered();
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Breach");

	}

	@Override
	public void leave() {
		timer = null;
		SecuritySystemContext.instance().showTimeLeft(0, "Breach");
	}

}
