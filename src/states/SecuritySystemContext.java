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

	public void handleEvent(ZoneUnreadyEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(CancelEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(MotionDetectedEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PasswordEnteredEvent event) {
		currentState.handleEvent(event);
	}

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

	public void handleEvent(ArmingRequestEvent event) {
		armingFrom = event.getArmingFrom();
		currentState.handleEvent(event);
	}

	public void handleEvent(StayRequestEvent event) {
		currentState.handleEvent(event);
	}

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

	private boolean changeBoolean(Boolean valueToChange) {
		if (valueToChange) {
			return false;
		}
		return true;
	}

	public boolean readyCheck() {
		return zoneOneReady && zoneTwoReady && zoneThreeReady;
	}

	public void showZoneStatus() {
		if (!readyCheck()) {
			showUnready();
		} else {
			showReady();
		}
	}

	public int getArmingFrom() {
		return armingFrom;
	}

	public void clearPasswordEntered() {
		passwordEntered.clear();
		stringPassword = "";
	}

	public boolean passwordCheck() {
		for (int index = 0; index < 4; index++) {
			if (password[index] != passwordEntered.get(index)) {
				return false;
			}
		}
		return true;
	}

	public String getPasswordEntered() {
		return stringPassword;
	}

	public void showUnready() {
		display.showUnready();
	}

	public void showReady() {
		display.showReady();
	}

	public void showTimeLeft(int time, String state) {
		display.showTimeLeft(time, state);
	}

	public void showAway() {
		display.showAway();
	}

	public void showStay() {
		display.showStay();
	}

	public void showArming() {
		display.showArming();
	}

	public void showDisarmed() {
		display.showDisarmed();
	}

	public void showBreach() {
		display.showBreach();
	}

	public void showTriggered() {
		display.showTriggered();

	}

	public void showPasswordPrompt() {
		display.showPasswordPrompt();

	}

	public void showNumeric(String stringPassword) {
		display.showNumeric(stringPassword);
	}

}
