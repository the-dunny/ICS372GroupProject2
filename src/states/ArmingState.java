package states;

import events.DisarmedRequestEvent;
import events.Zone1ReadyEvent;

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
	public void handleEvent(DisarmedRequestEvent event) {
		SecuritySystemContext.instance().changeState(ArmedState.instance());
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}