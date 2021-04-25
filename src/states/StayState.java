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
	 * Private constructor for the singleton pattern, method
	 * will set the instance method to this.
	 */
	private StayState() {
		instance = this;

	}

	/**
	 * For the singleton pattern, if the instance field is null,
	 * it will create a new StayState and store it in the instance
	 * field
	 * 
	 * @return the StayState object from instance field
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
	 * Handle numeric entered event, will call showNumeric method
	 * of the SecuritSystemContext, and pass the String value of the password entered
	 * that is obtained by the getPasswordEntered method of SecuritySystemContext
	 */
	@Override
	public void handleEvent(NumericEnteredEvent event) {
		SecuritySystemContext.instance().showNumeric(SecuritySystemContext.instance().getPasswordEntered());
	}

	/**
	 * Handle password entered event, if cancel is pressed and password is entered
	 * correctly, the state is set to Disarmed.
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