package display;

import display.controller.DisplayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import states.SecuritySystemContext;

/**
 * GUI to implement the SecuritySystemDisplay interface A pretty elementary
 * interface
 *
 */
public class GUIDisplay extends Application implements SecuritySystemDisplay {

	public static SecuritySystemDisplay display;
	DisplayController controller;

	public static SecuritySystemDisplay getInstance() {
		return display;
	}

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage stage) throws Exception {
		SecuritySystemContext.instance().setDisplay(this);
		display = this;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../display/fxml/security_system_display.fxml"));
		stage.setScene(new Scene(loader.load()));

		controller = loader.getController();
		showUnready();
		stage.show();
	}

	/**
	 * Display the remaining time
	 * 
	 * @param the value remaining and the state of the system
	 */
	@Override
	public void showTimeLeft(int time, String state) {
		String stringTime = String.valueOf(time) + " seconds to " + state;
		controller.statusDisplayChange(stringTime);
	}

	/**
	 * Indicate that the system is armed in away mode
	 */
	@Override
	public void showAway() {
		controller.statusDisplayChange("Armed Away");

	}

	/**
	 * Indicate that the system is ready for arming
	 */
	@Override
	public void showReady() {
		controller.statusDisplayChange("Ready");

	}

	/**
	 * Indicate that the system is not ready for arming
	 */
	@Override
	public void showUnready() {
		controller.statusDisplayChange("Not Ready");

	}

	/**
	 * Indicate that the system is disarmed
	 */
	@Override
	public void showDisarmed() {
		controller.statusDisplayChange("Disarmed");

	}

	/**
	 * Indicate that the system is breached
	 */
	@Override
	public void showBreach() {
		controller.statusDisplayChange("Breached");

	}

	/**
	 * Indicate the system is armed in stay mode
	 */
	@Override
	public void showStay() {
		controller.statusDisplayChange("Armed Stay");
	}

	/**
	 * Indicate that the system is arming
	 */
	@Override
	public void showArming() {
		controller.statusDisplayChange("Arming");

	}

	/**
	 * Indicate the system is triggered
	 */
	@Override
	public void showTriggered() {
		controller.statusDisplayChange("Triggered");

	}

	/**
	 * The system asks for password to disarm
	 */
	@Override
	public void showPasswordPrompt() {
		controller.statusDisplayChange("Enter password to cancel");
	}

	/**
	 * Indicate the number that user input on the keypad
	 * 
	 * @param the password string
	 */
	@Override
	public void showNumeric(String stringPassword) {
		controller.statusDisplayChange(stringPassword);

	}

}
