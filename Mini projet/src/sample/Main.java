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
        StudentData.add(new Student("Edouard", "Cullen", "1888", "m1", "Biotechnology"));

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

