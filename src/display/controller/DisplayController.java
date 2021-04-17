package display.controller;

import events.ArmingRequestEvent;
import events.CancelEvent;
import events.MotionDetectedEvent;
import events.NumericEnteredEvent;
import events.StayRequestEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import states.SecuritySystemContext;

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

    @FXML
    void handleAwayButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(ArmingRequestEvent.instance());
    }

    @FXML
    void handleCancelButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(CancelEvent.instance());
    }

    @FXML
    void handleEightButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleFiveButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleFourButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleMotionDetectorButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(MotionDetectedEvent.instance());
    }

    @FXML
    void handleNineButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleOneButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleSevenButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleSixButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleStayButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(StayRequestEvent.instance());
    }

    @FXML
    void handleThreeButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleTwoButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleZeroButton(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(NumericEnteredEvent.instance());
    }

    @FXML
    void handleZoneOneRadio(ActionEvent event) {

    }

    @FXML
    void handleZoneThreeRadio(ActionEvent event) {

    }

    @FXML
    void handleZoneTwoRadio(ActionEvent event) {

    }

	@FXML
	public void statusDisplayChange(String string) {
		statusDisplay.setText(string);
	}

}
