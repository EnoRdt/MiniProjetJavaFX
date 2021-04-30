package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;


public class RootController {


    private Main mainApp;

    @FXML
    private Menu student_list;
    @FXML
    private Menu student_add;

    /**
     * Initialize the controller class.
     */
    @FXML
    private void initialize() {

    }

    /**
     * Redirection to the page where a student can be added
     */
    @FXML
    private void redirectStudentAdd() {

    }

    /**
     * Redirection to the page where there is the student list
     */
    @FXML
    private void redirectStudentList() {

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
