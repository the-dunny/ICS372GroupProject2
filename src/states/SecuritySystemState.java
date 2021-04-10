package states;

import events.ArmingRequestEvent;
import events.DisarmedRequestEvent;
import events.MotionDetectorAlarmEvent;
import events.MotionDetectorDisalarmEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import events.Zone1ReadyEvent;
import events.Zone1UnreadyEvent;
import events.Zone2ReadyEvent;
import events.Zone2UnreadyEvent;
import events.Zone3ReadyEvent;
import events.Zone3UnreadyEvent;

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
	 * Specifies action when the disarming button will be pressed (stay)
	 * 
	 * @param event
	 */
	public void handleEvent(DisarmedRequestEvent event) {

	}

	/**
	 * Specifies action when the motion detector button will be pressed (alarm)
	 * 
	 * @param event
	 */
	public void handleEvent(MotionDetectorAlarmEvent event) {

	}

	/**
	 * Specifies action when the motion detector button will be pressed (not alarm)
	 * 
	 * @param event
	 */
	public void handleEvent(MotionDetectorDisalarmEvent event) {

	}

	/**
	 * Specifies action when zone 1 buttons are clear (ready)
	 * 
	 * @param event
	 */
	public void handleEvent(Zone1ReadyEvent event) {

	}

	/**
	 * Specifies action when zone 1 buttons are unclear (unready)
	 * 
	 * @param event
	 */
	public void handleEvent(Zone1UnreadyEvent event) {

	}

	/**
	 * Specifies action when zone 2 buttons are clear (ready)
	 * 
	 * @param event
	 */
	public void handleEvent(Zone2ReadyEvent event) {

	}

	/**
	 * Specifies action when zone 2 buttons are unclear (unready)
	 * 
	 * @param event
	 */
	public void handleEvent(Zone2UnreadyEvent event) {

	}

	/**
	 * Specifies action when zone 3 buttons are clear (ready)
	 * 
	 * @param event
	 */
	public void handleEvent(Zone3ReadyEvent event) {

	}

	/**
	 * Specifies action when zone 3 buttons are unclear (unready)
	 * 
	 * @param event
	 */
	public void handleEvent(Zone3UnreadyEvent event) {

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
