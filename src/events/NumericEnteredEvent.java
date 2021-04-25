package events;

/**
 * Represents the number entered from the keypad
 *
 */
public class NumericEnteredEvent {
	private int numeric;

	/**
	 * Contructor takes an int called numeric and sets the numeric field
	 * 
	 * @param numeric
	 */
	public NumericEnteredEvent(int numeric) {
		this.numeric = numeric;
	}

	/**
	 * Getter method that returns the numeric  or number that
	 * was entered
	 * 
	 * @return numeric
	 */
	public int getNumeric() {
		return numeric;
	}

}
