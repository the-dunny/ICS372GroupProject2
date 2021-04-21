package states;

import events.ArmingRequestEvent;
import events.ZoneChangeEvent;

/**
 * Represent the system is disarmed
 * 
 * @author Luan Nguyen
 *
 */
public class DisarmedState extends SecuritySystemState {
	private static DisarmedState instance;

	private DisarmedState() {

	}

	public static DisarmedState instance() {
		if (instance == null) {
			instance = new DisarmedState();
		}
		return instance;
	}

	@Override
	public void handleEvent(ArmingRequestEvent event) {
		if (SecuritySystemContext.instance().readyCheck()) {
			SecuritySystemContext.instance().changeState(ArmingState.instance());
		}
	}

	@Override
	public void handleEvent(ZoneChangeEvent event) {
		SecuritySystemContext.instance().showZoneStatus();
	}

	@Override
	public void enter() {
		SecuritySystemContext.instance().showZoneStatus();

	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().showZoneStatus();
	}

}
