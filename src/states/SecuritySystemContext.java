package states;

import display.SecuritySystemDisplay;
import events.Zone1ReadyEvent;
import events.Zone1UnreadyEvent;
import events.Zone2ReadyEvent;
import events.Zone2UnreadyEvent;
import events.Zone3ReadyEvent;
import events.Zone3UnreadyEvent;

public class SecuritySystemContext {
	private SecuritySystemDisplay display;
	private SecuritySystemState currentState;
	private static SecuritySystemContext instance;

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

	public void handleEvent(Zone1ReadyEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(Zone1UnreadyEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(Zone2ReadyEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(Zone2UnreadyEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(Zone3ReadyEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(Zone3UnreadyEvent event) {
		currentState.handleEvent(event);
	}

	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

	public void showUnready() {
		display.showUnready();
	}

	public void showReady() {
		display.showReady();
	}

	public void showArmed() {
		display.showArmed();
	}

	public void showDisarmed() {
		display.showDisarmed();
	}

}
