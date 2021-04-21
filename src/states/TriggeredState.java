package states;

import events.PasswordEnteredEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.TimeTracker;

/**
 * Represent the system is disarmed
 * 
 * @author Luan Nguyen
 *
 */
public class TriggeredState extends SecuritySystemState implements Notifiable {
	private static TriggeredState instance;
	private TimeTracker timer;

	private TriggeredState() {

	}

	public static TriggeredState instance() {
		if (instance == null) {
			instance = new TriggeredState();
		}
		return instance;
	}

	@Override
	public void handleEvent(PasswordEnteredEvent event) {
		timer.stop();
		SecuritySystemContext.instance().changeState(DisarmedState.instance());
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Breach");
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		SecuritySystemContext.instance().changeState(BreachedState.instance());
	}

	@Override
	public void enter() {
		timer = new TimeTracker(15, this);
		SecuritySystemContext.instance().showTriggered();
		SecuritySystemContext.instance().showTimeLeft(timer.getRemainingTime(), "Breach");

	}

	@Override
	public void leave() {
		timer = null;
		SecuritySystemContext.instance().showTimeLeft(0, "Breach");
	}

}
