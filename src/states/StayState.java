package states;

import events.CancelEvent;
import events.NumericEnteredEvent;
import events.PasswordEnteredEvent;
import events.ZoneUnreadyEvent;

public class StayState extends SecuritySystemState {
	private static StayState instance;
	private boolean cancelPressed;

	/**
	 * Private constructor for the singleton pattern
	 */
	private StayState() {
		instance = this;

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static StayState instance() {
		if (instance == null) {
			instance = new StayState();
		}
		return instance;
	}

	@Override
	public void handleEvent(ZoneUnreadyEvent event) {
		SecuritySystemContext.instance().changeState(BreachedState.instance());
	}

	@Override
	public void handleEvent(CancelEvent event) {
		SecuritySystemContext.instance().showPasswordPrompt();
		cancelPressed = true;
		SecuritySystemContext.instance().clearPasswordEntered();
	}

	@Override
	public void handleEvent(NumericEnteredEvent event) {
		SecuritySystemContext.instance().showNumeric(SecuritySystemContext.instance().getPasswordEntered());
	}

	@Override
	public void handleEvent(PasswordEnteredEvent event) {
		if (cancelPressed == true) {
			SecuritySystemContext.instance().changeState(DisarmedState.instance());
		}
	}

	@Override
	public void enter() {
		SecuritySystemContext.instance().showStay();
		this.cancelPressed = false;

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}