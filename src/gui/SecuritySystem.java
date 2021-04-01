package gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class SecuritySystem extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Security System");

		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
