package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.awt.*;
import java.time.LocalDate;


/**
 * Class which allows to edit details of a student
 * @author Florimel Flotté, Salomé Rebours, Enola Roudaut
 * @version 17/03/2020
 */

public class AddAndEditStudentController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField yearOfBirthField;
    @FXML
    private Checkbox L3promotionField;
    @FXML
    private Checkbox M1promotionField;
    @FXML
    private Checkbox M2promotionField;
    @FXML
    private Checkbox BiotechnologySpecialisationField;
    @FXML
    private Checkbox PhysiologySpecialisationField;
    @FXML
    private Checkbox ImagingSpecialisationField;

    private Stage dialogStage;
    private Student student;
    private boolean okClicked = false;

    /**
     * Initialize the controller class.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage the dialog stage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited or added in the dialog.
     *
     * @param student the student to be edited or added
     */
    public void setStudent(Student student) {
        this.student = student;

        firstNameField.setText(student.getFirstName());
        firstNameField.setText("Enter first name");
        lastNameField.setText(student.getLastName());
        lastNameField.setText("Enter last name");

        if (student.getYearOfBirth() == "0") {
            yearOfBirthField.setText("");
        } else {
            yearOfBirthField.setText(student.getYearOfBirth());
        }
        yearOfBirthField.setText("yyyy");

    }

    /**
     *
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleAdd() {
        if (isInputValid()) {
            student.setFirstName(firstNameField.getText());
            student.setLastName(lastNameField.getText());
            student.setYearOfBirth(yearOfBirthField.getText());

            if (L3promotionField.getState()) {
                student.setPromotion("L3");
            } else if (M1promotionField.getState()) {
                student.setPromotion("M1");
            } else if (M2promotionField.getState()) {
                student.setPromotion("M2");
            }

            if (BiotechnologySpecialisationField.getState()) {
                student.setSpecialisation("Biotechnology");
            } else if (PhysiologySpecialisationField.getState()) {
                student.setSpecialisation("Physiology");
            } else if (ImagingSpecialisationField.getState()) {
                student.setSpecialisation("Imaging");
            }

            okClicked = true;
            dialogStage.close();

    }
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        LocalDate localDate = LocalDate.now();
        if (yearOfBirthField.getText() == null || yearOfBirthField.getText().length() != 4 || Integer.parseInt(yearOfBirthField.getText()) < 1900 || Integer.parseInt(yearOfBirthField.getText()) > localDate.getYear() ) {
            errorMessage += "No valid Year Of Birth!\n";
        }

        if (!L3promotionField.getState() && !M1promotionField.getState() && !M2promotionField.getState()) {
            errorMessage += "No valid promotion!\n";
        }

        if (!PhysiologySpecialisationField.getState() && !BiotechnologySpecialisationField.getState() && !ImagingSpecialisationField.getState()) {
            errorMessage += "No valid specialisation!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
