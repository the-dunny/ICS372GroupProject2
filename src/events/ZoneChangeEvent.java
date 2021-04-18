package events;

/**
 *
 *
 */
public class ZoneChangeEvent extends SecuritySystemEvent {
	private int zoneNumber;

	public ZoneChangeEvent(int zoneNumber) {
		this.zoneNumber = zoneNumber;
	}

	public int getZoneNumber() {
		return zoneNumber;
	}


}
