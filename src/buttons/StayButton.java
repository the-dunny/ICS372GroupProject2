package buttons;

import events.StayRequestEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecuritySystemContext;

//TODO - adding appropriate methods for stay button
public class StayButton implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(StayRequestEvent.instance());

	}
}
