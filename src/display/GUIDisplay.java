package display;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIDisplay extends Application implements SecuritySystemDisplay {

	public static SecuritySystemDisplay display;

	public static SecuritySystemDisplay getInstance() {
		return display;
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent fxmlRoot = FXMLLoader
				.load(getClass().getResource("../display/fxml/security_system_display.fxml"));
		stage.setTitle("Security System");
		stage.setScene(new Scene(fxmlRoot));
		stage.show();
	}

	@Override
	public void showTimeLeft(int time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void showReady() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showUnready() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showArmed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDisarmed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showBreach() {
		// TODO Auto-generated method stub

	}

}
