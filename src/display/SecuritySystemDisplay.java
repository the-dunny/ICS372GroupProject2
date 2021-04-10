package display;

// TODO - Check to see all methods are appropriate or not?
public interface SecuritySystemDisplay {
	/**
	 * Displays the time remaining to go out of the house
	 * 
	 * @param time remaining time
	 */
	public void showTimeLeft(int time);

	/**
	 * Indicate that the system is ready to arm
	 */
	public void showReady();

	/**
	 * Indicate that the system is unready to arm
	 */
	public void showUnready();

	/**
	 * Indicate that the system is armed
	 */
	public void showArmed();

	/**
	 * Indicate that the system is disarmed
	 */
	public void showDisarmed();

	/**
	 * Indicate that the system is breach
	 */
	public void showBreach();

}
