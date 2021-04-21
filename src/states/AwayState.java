package states;

import events.MotionDetectedEvent;
import events.ZoneUnreadyEvent;

/**
 * Represents the away state
 *
 */
public class AwayState extends SecuritySystemState {
	private static AwayState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private AwayState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static AwayState instance() {
		if (instance == null) {
			instance = new AwayState();
		}
		return instance;
	}

	/**
	 * Process the motion detect event
	 */
	@Override
	public void handleEvent(MotionDetectedEvent event) {
		SecuritySystemContext.instance().changeState(TriggeredState.instance());
	}

	/**
	 * Handle the zone unready event
	 */
	@Override
	public void handleEvent(ZoneUnreadyEvent event) {
		SecuritySystemContext.instance().changeState(TriggeredState.instance());
	}

	/**
	 * Initializes state
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showAway();
	}

	@Override
	public void leave() {
		// do nothing

	}

}
