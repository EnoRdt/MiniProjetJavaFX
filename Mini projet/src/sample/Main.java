package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private ObservableList<Student> StudentData = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        primaryStage.setTitle("Mini projet JavaFX");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        StudentData.add(new Student("Edouard", "Cullen", 1888, "L3", null));
    }

    public static void main(String[] args) {
        launch(args);
           }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Student> getStudentData() {
        return StudentData;
    }

    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("HomePage.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            //rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            StudentOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

