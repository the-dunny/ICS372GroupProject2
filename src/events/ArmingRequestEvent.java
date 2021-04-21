package events;

public class ArmingRequestEvent extends SecuritySystemEvent {
	private int armingFrom;

	public ArmingRequestEvent(int armingFrom) {
		this.armingFrom = armingFrom;
	}

	public int getArmingFrom() {
		return armingFrom;
	}


}
