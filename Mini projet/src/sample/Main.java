package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class of the project, allow all class to interact and made action
 * @author Florimel Flotté, Salomé Rebours, Enola Roudaut
 * @version 30/04/2021
 */
public class Main extends Application {

    private final ObservableList<Student> StudentData = FXCollections.observableArrayList();

    private Stage primaryStage;
    private BorderPane rootLayout;

    public Main() {
        StudentData.add(new Student("Etu1", "LastN1", "1990", "L3", null));
        StudentData.add(new Student("Etu2", "LastN2", "1991", "M1", "biotechnology"));
        StudentData.add(new Student("Etu3", "LastN3", "1992", "M1", "imaging"));
        StudentData.add(new Student("Etu4", "LastN4", "1993", "M1", "Physiology"));
        StudentData.add(new Student("Etu5", "LastN5", "1994", "M2", null));
    }

    public void addStud(Student student) {
        StudentData.add(student);
        showPersonOverview();
    }
    /**
     * The main entry point
     * @param primaryStage the primary stage of the application
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Mini projet JavaFX");
        initRootLayout();
        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            RootController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load the homepage
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("HomePage.fxml"));
            AnchorPane StudentOverview = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(StudentOverview);

            // Give the controller access to the main app.
            StudentOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load the modify page
     *
     * @param student the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonModifyFrame(Student student) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("ModifyPage.fxml"));
            AnchorPane StudentModify = loader.load();

            rootLayout.setCenter(StudentModify);

            // Set the person into the controller.
            AddAndEditStudentController controller = loader.getController();
            controller.setStudent(student);
            controller.setMainApp(this);
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  load the adding page
     */
    public void showStudentAddFrame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("AddingPage.fxml"));
            AnchorPane StudentAdd = loader.load();

            rootLayout.setCenter(StudentAdd);

            AddAndEditStudentController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Returns the main stage.
     * @return main stage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
           }

    /**
     * Returns the data as an observable list of Persons.
     * @return data
     */
    public ObservableList<Student> getStudentData() {
        return StudentData;
    }

}

