package states;

import events.DisarmedRequestEvent;
import events.Zone1ReadyEvent;

public class BreachedState extends SecuritySystemState {
	private static ArmedState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private BreachedState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static BreachedState instance() {
		if (instance == null) {
			instance = new BreachedState();
		}
		return instance;
	}

	@Override
	public void handleEvent( event) {
		SecuritySystemContext.instance().changeState(TriggeredState.instance());
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