package sample;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class RootController {


    private Main mainApp;

    public RootController() {}

    /**
     * Sets the main app reference
     * @param mainApp the mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

}
