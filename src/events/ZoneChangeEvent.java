package events;

/**
 * Represents the Zone change status
 *
 */
public class ZoneChangeEvent extends SecuritySystemEvent {
	private int zoneNumber;

	/**
	 * Constructor
	 * 
	 * @param zoneNumber
	 */
	public ZoneChangeEvent(int zoneNumber) {
		this.zoneNumber = zoneNumber;
	}

	/**
	 * Getter method
	 * 
	 * @return zoneNumber
	 */
	public int getZoneNumber() {
		return zoneNumber;
	}

}
