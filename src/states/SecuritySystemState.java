package states;

import events.ArmingRequestEvent;
import events.CancelEvent;
import events.MotionDetectedEvent;
import events.NumericEnteredEvent;
import events.PasswordEnteredEvent;
import events.StayRequestEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import events.ZoneChangeEvent;
import events.ZoneUnreadyEvent;

/**
 * Super class for all states
 * 
 * @author Luan Nguyen
 *
 */
public abstract class SecuritySystemState {

	/**
	 * Initializes the state, called when a new state is just first being called
	 */
	public abstract void enter();

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public abstract void leave();

	/**
	 * Specifies action when the arming button will be pressed (away)
	 * 
	 * @param event - an ArmingRequestEvent
	 */
	public void handleEvent(ArmingRequestEvent event) {

	}

	/**
	 * Specifies action when the stay button will be pressed
	 * 
	 * @param event - a StayRequestEvent
	 */
	public void handleEvent(StayRequestEvent event) {

	}

	/**
	 * Specifies action when the disarming button will be pressed (stay)
	 * 
	 * @param event - Cancel Event
	 */
	public void handleEvent(CancelEvent event) {

	}

	/**
	 * Specifies action when the motion detector button will be pressed (alarm)
	 * 
	 * @param event - MotionDetectedEvent
	 */
	public void handleEvent(MotionDetectedEvent event) {

	}

	/**
	 * Specifies action when a number is pressed
	 * 
	 * @param event - a NumericEnteredEvent
	 */
	public void handleEvent(NumericEnteredEvent event) {

	}

	/**
	 * Specifies action when zone 1 buttons are unclear (unready)
	 * 
	 * @param event - ZoneUnreadyEvent
	 */
	public void handleEvent(ZoneUnreadyEvent event) {

	}

	/**
	 * Process clock tick Generates the timer runs out event, will caused
	 * when the TimeTracker fires a property change event
	 */
	public void handleEvent(TimerTickedEvent event) {

	}

	/**
	 * handles the event when the timer reaches 0
	 */
	public void handleEvent(TimerRanOutEvent event) {

	}

	/**
	 * Specifies what happens when a zone changes
	 */
	public void handleEvent(ZoneChangeEvent event) {

	}

	/**
	 * Specifies what happens when the password is entered only can be called
	 * if the password is entered correctly
	 */
	public void handleEvent(PasswordEnteredEvent event) {

	}

}
