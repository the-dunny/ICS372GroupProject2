package events;

/**
 * Represents the Zone change status
 *
 */
public class ZoneChangeEvent extends SecuritySystemEvent {
	private int zoneNumber;

	/**
	 * Constructor, this will create a instance of ZoneChangeEvent
	 * and store the zone number in the zoneNumber field
	 * 
	 * @param zoneNumber
	 */
	public ZoneChangeEvent(int zoneNumber) {
		this.zoneNumber = zoneNumber;
	}

	/**
	 * Getter method, will get the value of the zone stored in zoneNumber
	 * field
	 * 
	 * @return zoneNumber
	 */
	public int getZoneNumber() {
		return zoneNumber;
	}

}
