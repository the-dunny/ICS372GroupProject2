package events;

/**
 * Represent a clock tick for people go away from the house. The object contains
 * the amount of time left in the timer.
 * 
 *
 */
public class TimerTickedEvent extends SecuritySystemEvent {
	private int timeLeft;

	/**
	 * Stores the amount of time left in the Timer.  It stores the
	 * passed value in the timeLeft field
	 * 
	 * @param value the amount of time left
	 */
	public TimerTickedEvent(int value) {
		this.timeLeft = value;
	}

	/**
	 * Needed for display purposes, it will return the value
	 * of timeLeft.
	 */
	public int getTimeLeft() {
		return timeLeft;
	}

}
