package events;

public class NumericEnteredEvent {
	private static NumericEnteredEvent instance;

	/**
	 * private for singleton
	 */

	private NumericEnteredEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @Return the only instance
	 */

	public static NumericEnteredEvent instance() {
		if (instance == null) {
			instance = new NumericEnteredEvent();
		}
		return instance;
	}
}
