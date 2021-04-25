package states;

import events.PasswordEnteredEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.TimeTracker;

/**
 * Represents triggered state, this method will have a field to store a
 * TriggeredState object that will be used for Singleton pattern.  It will also
 * have a TimeTracker field that will store a timer used when the TriggeerState 
 * occurs.
 */
public class TriggeredState extends SecuritySystemState implements Notifiable {
	private static TriggeredState instance;
	private TimeTracker timer;

	/**
	 * Make it a singleton, Constructor cannot be called from outside of this class,
	 * but will be called from the instance() method
	 */
	private TriggeredState() {

	}

	/**
	 * Return the instance, this will check to see if the currenct instance field
	 * is null.  If it is, it will call the constructor, and then return the
	 * instance.  If not it just returns the instance
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
	 * Handle password entered event, will stop the current timer, and 
	 * move into the DisarmedState
	 * 
	 * @param a PasswordEnteredEven which denotes that a password has been
	 * entered corretly
	 */
	@Override
	public void handleEvent(PasswordEnteredEvent event) {
		timer.stop();
		SecuritySystemContext.instance().changeState(DisarmedState.instance());
	}

	/**
	 * Handle the timer ticked even, which happens when a second passed in the TimeTracker
	 * class. 
	 * 
	 * @param TimerTickedEvent - one second has passed
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Breach");
	}

	/**
	 * Handle the time ran out event, when the timer reaches 0.  If the timer
	 * runs out, the state of the SecuritySystemContext will be set to breached.
	 * 
	 * @param event - a TimerTickedEvent
	 */
	@Override
	public void handleEvent(TimerRanOutEvent event) {
		SecuritySystemContext.instance().changeState(BreachedState.instance());
	}

	/**
	 * Initializes state. When this state is called a new timer is created with 15
	 * seconds on the clock, and adds itself as a Notifiable. The
	 * SecuritySystemContext is set to triggered. The Context will also immediately
	 * show the time left. Clears the password entered.
	 */
	@Override
	public void enter() {
		timer = new TimeTracker(15, this);
		SecuritySystemContext.instance().showTriggered();
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Breach");
		SecuritySystemContext.instance().clearPasswordEntered();
	}

	/**
	 * Sets the timer to null, the time left is then 0, and the SecuritySystemContext will show
	 * as breached.
	 * 
	 */
	@Override
	public void leave() {
		timer = null;
		SecuritySystemContext.instance().showTimeLeft(0, "Breach");
	}

}
