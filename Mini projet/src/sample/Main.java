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


public class Main extends Application {

    private ObservableList<Student> StudentData = FXCollections.observableArrayList();

    private Stage primaryStage;
    private BorderPane rootLayout;

    public Main() {
        StudentData.add(new Student("Etu1", "LastN1", "1990", "L3", null));
        StudentData.add(new Student("Etu2", "LastN2", "1991", "M1", "biotechnology"));
        StudentData.add(new Student("Etu3", "LastN3", "1992", "M1", "imaging"));
        StudentData.add(new Student("Etu4", "LastN4", "1993", "M1", "Physiology"));
        StudentData.add(new Student("Etu5", "LastN5", "1994", "M2", null));
    }

    /**
     * The main entry point
     * @param primaryStage the primary stage of the application
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
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
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            RootController controller = loader.getController();
            if (controller == null) {
                System.out.println("vide");
            }
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("HomePage.fxml"));
            AnchorPane StudentOverview = (AnchorPane) loader.load();

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
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param student the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonModifyFrame(Student student) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("ModifyPage.fxml"));
            AnchorPane StudentModify = (AnchorPane) loader.load();

            rootLayout.setCenter(StudentModify);

            // Set the person into the controller.
            AddAndEditStudentController controller = loader.getController();
            controller.setStudent(student);

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean showStudentAddFrame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("AddingPage.fxml"));
            AnchorPane StudentAdd = (AnchorPane) loader.load();

            rootLayout.setCenter(StudentAdd);

            AddAndEditStudentController controller = loader.getController();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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

