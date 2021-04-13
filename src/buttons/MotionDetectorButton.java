package buttons;

import events.MotionDetectedEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecuritySystemContext;

//TODO - adding appropriate methods for motion detector button
public class MotionDetectorButton implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(MotionDetectedEvent.instance());

	}
}
