package display;

import display.controller.DisplayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import states.SecuritySystemContext;

public class GUIDisplay extends Application implements SecuritySystemDisplay {

	public static SecuritySystemDisplay display;
	DisplayController controller;

	public static SecuritySystemDisplay getInstance() {
		return display;
	}

	@Override
	public void start(Stage stage) throws Exception {
//		Parent fxmlRoot = FXMLLoader
//				.load(getClass().getResource("../display/fxml/security_system_display.fxml"));
//		stage.setTitle("Security System");
//		stage.setScene(new Scene(fxmlRoot));
//		stage.show();
		SecuritySystemContext.instance().setDisplay(this);
		display = this;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../display/fxml/security_system_display.fxml"));
		stage.setScene(new Scene(loader.load()));

		controller = loader.getController();
		showUnready();
		stage.show();
	}

	@Override
	public void showTimeLeft(int time, String state) {
		String stringTime = String.valueOf(time) + " seconds to " + state;
		controller.statusDisplayChange(stringTime);
	}

	@Override
	public void showAway() {
		controller.statusDisplayChange("Away");

	}

	@Override
	public void showReady() {
		controller.statusDisplayChange("Ready");

	}

	@Override
	public void showUnready() {
		controller.statusDisplayChange("Not Ready");

	}

	@Override
	public void showDisarmed() {
		controller.statusDisplayChange("Disarmed");

	}

	@Override
	public void showBreach() {
		controller.statusDisplayChange("Breached");

	}

	@Override
	public void showStay() {
		controller.statusDisplayChange("Stay");
	}

	@Override
	public void showArming() {
		controller.statusDisplayChange("Arming");

	}

	@Override
	public void showTriggered() {
		controller.statusDisplayChange("Triggered");

	}

}
