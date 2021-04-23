package sample;

import javafx.collections.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    private ObservableList<Student> StudentData = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        primaryStage.setTitle("Hello World");
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
}
