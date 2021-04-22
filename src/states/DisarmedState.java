package states;

import events.ArmingRequestEvent;
import events.ZoneChangeEvent;

/**
 * Represent disarmed state
 * 
 *
 */
public class DisarmedState extends SecuritySystemState {
	private static DisarmedState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private DisarmedState() {

	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static DisarmedState instance() {
		if (instance == null) {
			instance = new DisarmedState();
		}
		return instance;
	}

	/**
	 * Process arming request
	 */
	@Override
	public void handleEvent(ArmingRequestEvent event) {
		if (SecuritySystemContext.instance().readyCheck()) {
			SecuritySystemContext.instance().changeState(ArmingState.instance());
		}
	}

	/**
	 * Handle zone change event
	 */
	@Override
	public void handleEvent(ZoneChangeEvent event) {
		SecuritySystemContext.instance().showZoneStatus();
	}

	/**
	 * Initializes state
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showZoneStatus();

	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().showZoneStatus();
	}

}
