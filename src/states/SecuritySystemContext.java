package states;

import java.util.ArrayList;
import java.util.List;

import display.SecuritySystemDisplay;
import events.ArmingRequestEvent;
import events.CancelEvent;
import events.MotionDetectedEvent;
import events.NumericEnteredEvent;
import events.PasswordEnteredEvent;
import events.StayRequestEvent;
import events.ZoneChangeEvent;
import events.ZoneUnreadyEvent;

/**
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class SecuritySystemContext {
	private SecuritySystemDisplay display;
	private SecuritySystemState currentState;
	private static SecuritySystemContext instance;
	private boolean zoneOneReady, zoneTwoReady, zoneThreeReady;
	private int armingFrom;
	private int[] password = new int[] { 1, 2, 3, 4 };
	private List<Integer> passwordEntered = new ArrayList<Integer>();
	private String stringPassword = "";

	/**
	 * Make a singleton
	 */
	private SecuritySystemContext() {
		instance = this;
		currentState = DisarmedState.instance();
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static SecuritySystemContext instance() {
		if (instance == null) {
			instance = new SecuritySystemContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get its refrence.
	 * 
	 * @param display The current display object
	 */
	public void setDisplay(SecuritySystemDisplay display) {
		this.display = display;
	}

	/**
	 * Lets the disarmed state be the starting state
	 */
	public void initialize() {
		instance.changeState(DisarmedState.instance());
		zoneOneReady = false;
		zoneTwoReady = false;
		zoneThreeReady = false;
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState the next state
	 */
	public void changeState(SecuritySystemState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Handle the zone unready event
	 * 
	 * @param event
	 */
	public void handleEvent(ZoneUnreadyEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Handle cancel event
	 * 
	 * @param event
	 */
	public void handleEvent(CancelEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Handle the motion detected event
	 * 
	 * @param event
	 */
	public void handleEvent(MotionDetectedEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Handle the password entered event
	 * 
	 * @param event
	 */
	public void handleEvent(PasswordEnteredEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Handle the numeric entered event
	 * 
	 * @param event
	 */
	public void handleEvent(NumericEnteredEvent event) {
		passwordEntered.add(event.getNumeric());
		stringPassword += event.getNumeric();
		currentState.handleEvent(event);
		if (passwordEntered.size() == 4) {
			if (passwordCheck()) {
				handleEvent(PasswordEnteredEvent.instance());
			}
			clearPasswordEntered();
		}

	}

	/**
	 * Process the arming request
	 * 
	 * @param event
	 */
	public void handleEvent(ArmingRequestEvent event) {
		armingFrom = event.getArmingFrom();
		currentState.handleEvent(event);
	}

	/**
	 * Process the stay request
	 * 
	 * @param event
	 */
	public void handleEvent(StayRequestEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Handle the zone change event
	 * 
	 * @param event
	 */
	public void handleEvent(ZoneChangeEvent event) {
		if (event.getZoneNumber() == 1) {
			zoneOneReady = changeBoolean(zoneOneReady);
		} else if (event.getZoneNumber() == 2) {
			zoneTwoReady = changeBoolean(zoneTwoReady);
		} else if (event.getZoneNumber() == 3) {
			zoneThreeReady = changeBoolean(zoneThreeReady);
		}
		if (!readyCheck()) {
			handleEvent(ZoneUnreadyEvent.instance());
		}
		currentState.handleEvent(event);
	}

	/**
	 * Supported method for handle zone change event
	 * 
	 * @param valueToChange
	 * @return boolean value
	 */
	private boolean changeBoolean(Boolean valueToChange) {
		if (valueToChange) {
			return false;
		}
		return true;
	}

	/**
	 * Supported method to check all zones's status
	 * 
	 * @return
	 */
	public boolean readyCheck() {
		return zoneOneReady && zoneTwoReady && zoneThreeReady;
	}

	/**
	 * Show the status of all zones
	 */
	public void showZoneStatus() {
		if (!readyCheck()) {
			showUnready();
		} else {
			showReady();
		}
	}

	/**
	 * Supported method to indicate arming from stay or away mode
	 * 
	 * @return
	 */
	public int getArmingFrom() {
		return armingFrom;
	}

	/**
	 * Clean up the password after the user input password/pin
	 */
	public void clearPasswordEntered() {
		passwordEntered.clear();
		stringPassword = "";
	}

	/**
	 * Check the password is correct or not
	 * 
	 * @return boolean
	 */
	public boolean passwordCheck() {
		for (int index = 0; index < 4; index++) {
			if (password[index] != passwordEntered.get(index)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Get the entered password
	 * 
	 * @return
	 */
	public String getPasswordEntered() {
		return stringPassword;
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showUnready() {
		display.showUnready();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showReady() {
		display.showReady();
	}

	/**
	 * Display the time remaining
	 * 
	 * @param time
	 * @param state
	 */
	public void showTimeLeft(int time, String state) {
		display.showTimeLeft(time, state);
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showAway() {
		display.showAway();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showStay() {
		display.showStay();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showArming() {
		display.showArming();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showDisarmed() {
		display.showDisarmed();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showBreach() {
		display.showBreach();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 */
	public void showTriggered() {
		display.showTriggered();

	}

	/**
	 * Prompt the password
	 * 
	 */
	public void showPasswordPrompt() {
		display.showPasswordPrompt();

	}

	/**
	 * Show the password string
	 * 
	 */
	public void showNumeric(String stringPassword) {
		display.showNumeric(stringPassword);
	}

}
