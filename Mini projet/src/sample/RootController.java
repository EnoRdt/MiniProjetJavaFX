package sample;

import javafx.fxml.FXML;

/**
 * Class which managed the root layer with the menu
 * @author Florimel Flotté, Salomé Rebours, Enola Roudaut
 * @version 30/04/2020
 */
public class RootController {


    private Main mainApp;

    /**
     * Redirection to the page where a student can be added
     */
    @FXML
    private void redirectStudentAdd() {
        mainApp.showStudentAddFrame();
    }

    /**
     * Redirection to the page where there is the student list
     */
    @FXML
    private void redirectStudentList() {
        mainApp.showPersonOverview();
    }
    public RootController() {}

    /**
     * Sets the main app reference
     * @param mainApp the mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

}
