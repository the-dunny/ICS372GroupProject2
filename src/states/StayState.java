package states;

import events.CancelEvent;
import events.NumericEnteredEvent;
import events.PasswordEnteredEvent;
import events.ZoneUnreadyEvent;

/**
 * Represents the stay state
 *
 */
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

	/**
	 * Handle the zone unready event
	 */
	@Override
	public void handleEvent(ZoneUnreadyEvent event) {
		SecuritySystemContext.instance().changeState(BreachedState.instance());
	}

	/**
	 * Handle cancel event
	 */
	@Override
	public void handleEvent(CancelEvent event) {
		SecuritySystemContext.instance().showPasswordPrompt();
		cancelPressed = true;
		SecuritySystemContext.instance().clearPasswordEntered();
	}

	/**
	 * Handle numeric entered event
	 */
	@Override
	public void handleEvent(NumericEnteredEvent event) {
		SecuritySystemContext.instance().showNumeric(SecuritySystemContext.instance().getPasswordEntered());
	}

	/**
	 * Handle password entered event
	 */
	@Override
	public void handleEvent(PasswordEnteredEvent event) {
		if (cancelPressed == true) {
			SecuritySystemContext.instance().changeState(DisarmedState.instance());
		}
	}

	/**
	 * Initializes state
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showStay();
		this.cancelPressed = false;

	}

	@Override
	public void leave() {
		// Do nothing

	}

}