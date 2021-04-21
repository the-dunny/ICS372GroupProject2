package events;

/**
 * Represents the number entered from the keypad
 *
 */
public class NumericEnteredEvent {
	private int numeric;

	/**
	 * Contructor
	 * 
	 * @param numeric
	 */
	public NumericEnteredEvent(int numeric) {
		this.numeric = numeric;
	}

	/**
	 * Getter method
	 * 
	 * @return numeric
	 */
	public int getNumeric() {
		return numeric;
	}

}
