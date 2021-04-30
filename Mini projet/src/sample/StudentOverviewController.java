package sample;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        BirthNameColumn.setCellValueFactory(cellData -> cellData.getValue().yearOfBirthProperty());
        PromotionColumn.setCellValueFactory(cellData -> cellData.getValue().promotionProperty());
        SpeColumn.setCellValueFactory(cellData -> cellData.getValue().specialisationProperty());
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

