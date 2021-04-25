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
 * states.  It will hold values for the dipslay, current states, the state of the 
 * zones, password fields (including what is entered and correct password).  This method
 * adapts SecuritySystemDisplay and SecuritySystenStatem
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
	 * Make a singleton.  The current instance variable will be this current instance.
	 * The current state will be set to disarmed initially.
	 */
	private SecuritySystemContext() {
		instance = this;
		currentState = DisarmedState.instance();
	}

	/**
	 * Checks to see if the 'instance' field is null.  If it is
	 * null, it will call the constructor and instantiate the instance field.
	 * If will then return the current instance. 
	 * 
	 * @return an instance of SecuritySystemContext.
	 */
	public static SecuritySystemContext instance() {
		if (instance == null) {
			instance = new SecuritySystemContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get its reference.  This method
	 * will take an instance of type SecuritySystemDisplay and set the display
	 * field.
	 * 
	 * @param takes an instance of type SecuritySystemDisplay
	 * 
	 */
	public void setDisplay(SecuritySystemDisplay display) {
		this.display = display;
	}

	/**
	 * The initialize method can be called to reset or set the current state
	 * back to the default of Disarmed.  It will alse set all zones to false.
	 */
	public void initialize() {
		instance.changeState(DisarmedState.instance());
		zoneOneReady = false;
		zoneTwoReady = false;
		zoneThreeReady = false;
	}

	/**
	 * Called from the states to change the current state.  It will call the 
	 * leave method of the current state, update current state to the next state,
	 * and call the enter method of the new state
	 * 
	 * 
	 * @param nextState the next state
	 */
	public void changeState(SecuritySystemState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Handle the zone unready event.  It will call the current
	 * states method to handle a ZoneUnreadyEvent.
	 * 
	 * @param event - a ZoneUnreadyEvent
	 */
	public void handleEvent(ZoneUnreadyEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Handle cancel event, calls the handle method of the current state,
	 * with a CancelEvent
	 * 
	 * @param event -- a CancelEvent object
	 */
	public void handleEvent(CancelEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Handle a MotionDetectedEvent.  This method calls the handleEvent() 
	 * method of the current state, and pass a MotionDetectedEvent
	 * 
	 * @param event -  a MotionDetectedEvent
	 */
	public void handleEvent(MotionDetectedEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * HandleEvent method for a PasswordEnteredEvent.  This method calls the
	 * currentStates handleEvent() method for a PasswordEnteredEvent
	 * 
	 * @param event
	 */
	public void handleEvent(PasswordEnteredEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Handle the numeric entered event. This method will call the event
	 * to get the number that was entered and add it to the passWordEntered array.
	 * If the password size is 4, it will check the password, if correct it will call the 
	 * PasswordEnteredEvent 
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
	 * Process the arming request.  It will set the armingFrom, and
	 * call teh current state to handle the event.
	 * 
	 * @param event
	 */
	public void handleEvent(ArmingRequestEvent event) {
		armingFrom = event.getArmingFrom();
		currentState.handleEvent(event);
	}

	/**
	 * Process the stay request, it will call the current field wht 
	 * the event value
	 * 
	 * @param event
	 */
	public void handleEvent(StayRequestEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Handle the zone change event.  This method will handle when
	 * zone boolean values are changed.  It will update the current zone fields,
	 * if not all of the zones are ready, it will call the ZoneUnreadyEvent method.
	 * Then it will call the handleEvent method of the current state, with the updated values
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
	 * Supported method for handle zone change event, it will take the current boolean
	 * value, and reverse it
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
	 * Supported method to check all zones's status.  It will check the value of
	 * zone one, two and three.  If all zones are true(ready) it will return true;
	 * 
	 * @return boolean, true if all zones are true.  False if any are false
	 */
	public boolean readyCheck() {
		return zoneOneReady && zoneTwoReady && zoneThreeReady;
	}

	/**
	 * Show the status of all zones.  Method will call readyCheck() to see if all
	 * zones are true(ready).  If not ready, calls showUnready(), else calls showReady()
	 */
	public void showZoneStatus() {
		if (!readyCheck()) {
			showUnready();
		} else {
			showReady();
		}
	}

	/**
	 * Supported method to indicate arming from stay or away mode, if will return
	 * will return the armingFrom field
	 * 
	 * @return int - arrmingFrom field.
	 */
	public int getArmingFrom() {
		return armingFrom;
	}

	/**
	 * Clean up the password after the user input password/pin.  it will
	 * clear the  current password array, and String
	 */
	public void clearPasswordEntered() {
		passwordEntered.clear();
		stringPassword = "";
	}

	/**
	 * Check the password is correct or not
	 * 
	 * @return boolean - true if entered password is correct, false if 
	 * incorrect
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
	 * Get the entered password, 
	 * 
	 * @return String - the password entered by the user, stringPassword
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
	 * Display the time remaining, it calls the showTimeLeft method of the adaptee display
	 * field.
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
	 * Show the password string, will show the String version of the password through
	 * the showNumeric() method of display.
	 * 
	 */
	public void showNumeric(String stringPassword) {
		display.showNumeric(stringPassword);
	}

}
