package display.controller;

import events.ArmingRequestEvent;
import events.CancelEvent;
import events.MotionDetectedEvent;
import events.NumericEnteredEvent;
import events.ZoneChangeEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import states.SecuritySystemContext;

/**
 * 
 * Represents the controller functionality
 *
 */
public class DisplayController {
	@FXML
	private CheckBox zoneOneRadio;
	@FXML
	private CheckBox zoneTwoRadio;
	@FXML
	private CheckBox zoneThreeRadio;
	@FXML
	private Button stayButton;
	@FXML
	private Button awayButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Label readyStatusLabel;
	@FXML
	private Button motionDetectorButton;
	@FXML
	private TextArea statusDisplay;
	@FXML
	private Button oneButton;
	@FXML
	private Button twoButton;
	@FXML
	private Button threeButton;
	@FXML
	private Button fourButton;
	@FXML
	private Button fiveButton;
	@FXML
	private Button sixButton;
	@FXML
	private Button sevenButton;
	@FXML
	private Button eightButton;
	@FXML
	private Button nineButton;
	@FXML
	private Button zeroButton;

	/**
	 * The arming is requested when the Away button is pressed
	 * 
	 * @param event represent the press on the Away button
	 */
	@FXML
	void handleAwayButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new ArmingRequestEvent(1));
	}

	/**
	 * The cancel event is requested when the cancel button is pressed
	 * 
	 * @param event represent the press on the cancel button
	 */
	@FXML
	void handleCancelButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(CancelEvent.instance());
	}

	/**
	 * The number 8 is entered when the number 8 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 8 button
	 */
	@FXML
	void handleEightButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(8));
	}

	/**
	 * The number 5 is entered when the number 5 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 5 button
	 */
	@FXML
	void handleFiveButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(5));
	}

	/**
	 * The number 4 is entered when the number 4 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 4 button
	 */
	@FXML
	void handleFourButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(4));
	}

	/**
	 * The motion detected is request when the motion detector button is pressed
	 * 
	 * @param event represent the press on the motion detector button
	 */
	@FXML
	void handleMotionDetectorButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(MotionDetectedEvent.instance());
	}

	/**
	 * The number 9 is entered when the number 9 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 9 button
	 */
	@FXML
	void handleNineButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(9));
	}

	/**
	 * The number 1 is entered when the number 1 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 1 button
	 */
	@FXML
	void handleOneButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(1));
	}

	/**
	 * The number 7 is entered when the number 7 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 7 button
	 */
	@FXML
	void handleSevenButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(7));
	}

	/**
	 * The number 6 is entered when the number 6 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 6 button
	 */
	@FXML
	void handleSixButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(6));
	}

	/**
	 * The arming is request when the stay button is pressed
	 * 
	 * @param event represent the press on the stay button
	 */
	@FXML
	void handleStayButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new ArmingRequestEvent(0));
	}

	/**
	 * The number 3 is entered when the number 3 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 3 button
	 */
	@FXML
	void handleThreeButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(3));
	}

	/**
	 * The number 2 is entered when the number 2 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 2 button
	 */
	@FXML
	void handleTwoButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(2));
	}

	/**
	 * The number 0 is entered when the number 0 button on the keypad is pressed
	 * 
	 * @param event represent the press on the number 0 button
	 */
	@FXML
	void handleZeroButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new NumericEnteredEvent(0));
	}

	/**
	 * The zone 1 change is request when zone 1 button is pressed
	 * 
	 * @param event represent the press on the zone 1 button
	 */
	@FXML
	void handleZoneOneRadio(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new ZoneChangeEvent(1));
	}

	/**
	 * The zone 3 change is request when zone 3 button is pressed
	 * 
	 * @param event represent the press on the zone 3 button
	 */
	@FXML
	void handleZoneThreeRadio(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new ZoneChangeEvent(3));
	}

	/**
	 * The zone 2 change is request when zone 2 button is pressed
	 * 
	 * @param event represent the press on the zone 2 button
	 */
	@FXML
	void handleZoneTwoRadio(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(new ZoneChangeEvent(2));
	}

	/**
	 * Display the system status when the system status is change
	 * 
	 * @param event
	 */
	@FXML
	public void statusDisplayChange(String string) {
		statusDisplay.setText(string);
	}

}
