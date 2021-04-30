package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Class allow to view student in the table
 *
 * @author Salomé Rebours, Florimel Flotté, Enola Roudaut
 * @version 30/04/2021
 */
public class StudentOverviewController {
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> firstNameColumn;
    @FXML
    private TableColumn<Student, String> lastNameColumn;
    @FXML
    private TableColumn<Student, String> BirthNameColumn;
    @FXML
    private TableColumn<Student, String> PromotionColumn;
    @FXML
    private TableColumn<Student, String> SpeColumn;

    // Reference to the main application.
    private Main mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public StudentOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        BirthNameColumn.setCellValueFactory(cellData -> cellData.getValue().yearOfBirthProperty());
        PromotionColumn.setCellValueFactory(cellData -> cellData.getValue().promotionProperty());
        SpeColumn.setCellValueFactory(cellData -> cellData.getValue().specialisationProperty());
    }

    /**
     * Called when the user clicks the modify button. Opens a frame to edit details for the selected student.
     */
    @FXML
    private void handleEditPerson() {
        Student selectedPerson = studentTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            mainApp.showPersonModifyFrame(selectedPerson);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Student Selected");
            alert.setContentText("Please select a Student in the table.");

            alert.showAndWait();
        }
    }


    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp -
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        studentTable.setItems(mainApp.getStudentData());
    }
}

