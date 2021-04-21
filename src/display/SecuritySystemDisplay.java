package display;

// TODO - Check to see all methods are appropriate or not?
public interface SecuritySystemDisplay {
	/**
	 * Displays the time remaining to go out of the house
	 * 
	 * @param time remaining time, state state it is going into after time runs out
	 */
	public void showTimeLeft(int time, String state);

	/**
	 * Indicates that the system is in Away State
	 */
	public void showAway();

	/**
	 * Indicates that the system is in Stay State
	 */
	public void showStay();

	/**
	 * Indicate that the system is ready to arm
	 */
	public void showReady();

	/**
	 * Indicate that the system is unready to arm
	 */
	public void showUnready();

	/**
	 * Indicate that the system is arming
	 */
	public void showArming();

	/**
	 * Indicate that the system is disarmed
	 */
	public void showDisarmed();

	/**
	 * Indicate that the system is breach
	 */
	public void showBreach();

	/**
	 * Indicate that the system is triggered
	 */
	public void showTriggered();

	/**
	 * prompts user for password when cancel pressed
	 */
	public void showPasswordPrompt();

	/**
	 * shows number pressed
	 */
	public void showNumeric(String stringPassword);

}
