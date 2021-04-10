package events;

/**
 * Repreesent a clock tick for people go away from the house. The object
 * contains the amount of time left in the timer.
 * 
 * @author Luan Nguyen
 *
 */
public class TimerTickedEvent extends SecuritySystemEvent {
	private int timeLeft;

	/**
	 * Stores the amount of time left in the Timer.
	 * 
	 * @param value the amount of time left
	 */
	public TimerTickedEvent(int value) {
		this.timeLeft = value;
	}

	/**
	 * Needed for display purposes
	 */
	public int getTimeLeft() {
		return timeLeft;
	}

}
