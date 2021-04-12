package buttons;

import events.ArmingRequestEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecuritySystemContext;

//TODO - adding appropriate methods for away button
public class AwayButton implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(ArmingRequestEvent.instance());

	}

}
