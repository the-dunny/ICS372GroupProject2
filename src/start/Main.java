package start;

import display.GUIDisplay;
import display.SecuritySystemDisplay;
import javafx.application.Application;
import states.SecuritySystemContext;
import timer.Timekeeper;

public class Main {
    public static void main(String[] args) {
        Timekeeper.instance();
        new Thread() {
            @Override
            public void run() {
                Application.launch(GUIDisplay.class, args);
            }
        }.start();


        try {
            while (GUIDisplay.getInstance() == null) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
        }
        SecuritySystemDisplay display = GUIDisplay.getInstance();
        SecuritySystemContext.instance().setDisplay(display);

    }
}
