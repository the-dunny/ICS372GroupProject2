package states;

import events.PasswordEnteredEvent;

/**
 * Represents the breached state
 *
 */
public class BreachedState extends SecuritySystemState {
	private static BreachedState instance;

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

	/**
	 * Handle password enter event
	 */
	@Override
	public void handleEvent(PasswordEnteredEvent event) {
		SecuritySystemContext.instance().changeState(DisarmedState.instance());
	}

	/**
	 * Initializes state. Clears the password entered.
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showBreach();
		SecuritySystemContext.instance().clearPasswordEntered();
	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().showDisarmed();
	}

}