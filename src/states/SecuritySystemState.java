package states;

import events.ArmingRequestEvent;
import events.DisarmEvent;
import events.MotionDetectedEvent;
import events.StayRequestEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import events.ZoneUnreadyEvent;

/**
 * Super class for all states
 * 
 * @author Luan Nguyen
 *
 */
public abstract class SecuritySystemState {

	/**
	 * Initializes the state
	 */
	public abstract void enter();

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public abstract void leave();

	/**
	 * Specifies action when the arming button will be pressed (away)
	 * 
	 * @param event
	 */
	public void handleEvent(ArmingRequestEvent event) {

	}

	/**
	 * Specifies action when the stay button will be pressed
	 * 
	 * @param event
	 */
	public void handleEvent(StayRequestEvent event) {

	}

	/**
	 * Specifies action when the disarming button will be pressed (stay)
	 * 
	 * @param event
	 */
	public void handleEvent(DisarmEvent event) {

	}

	/**
	 * Specifies action when the motion detector button will be pressed (alarm)
	 * 
	 * @param event
	 */
	public void handleEvent(MotionDetectedEvent event) {

	}

	/**
	 * Specifies action when zone 1 buttons are unclear (unready)
	 * 
	 * @param event
	 */
	public void handleEvent(ZoneUnreadyEvent event) {

	}

	/**
	 * Process clock tick Generates the timer runs out event
	 */
	public void handleEvent(TimerTickedEvent event) {
		
	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void handleEvent(TimerRanOutEvent event) {

	}

}
