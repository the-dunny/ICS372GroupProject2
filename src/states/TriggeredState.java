package states;

import events.DisarmEvent;
import events.TimerRanOutEvent;

/**
 * Represent the system is disarmed
 * 
 * @author Luan Nguyen
 *
 */
public class TriggeredState extends SecuritySystemState {
	private static TriggeredState instance;

	private TriggeredState() {

	}

	public static TriggeredState instance() {
		if (instance == null) {
			instance = new TriggeredState();
		}
		return instance;
	}

	@Override
	public void handleEvent(DisarmEvent event) {
		SecuritySystemContext.instance().changeState(DisarmedState.instance());
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		SecuritySystemContext.instance().changeState(BreachedState.instance());
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
