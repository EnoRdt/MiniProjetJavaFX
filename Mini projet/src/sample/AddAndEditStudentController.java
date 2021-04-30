package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


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
    private RadioButton L3promotionField;
    @FXML
    private RadioButton M1promotionField;
    @FXML
    private RadioButton M2promotionField;
    @FXML
    private RadioButton BiotechnologySpecialisationField;
    @FXML
    private RadioButton PhysiologySpecialisationField;
    @FXML
    private RadioButton ImagingSpecialisationField;

    @FXML
    private ToggleGroup Promo;
    @FXML
    private ToggleGroup Spe;


    private Stage dialogStage;
    private Student student;
    private boolean okClicked = false;

    // Reference to the main application.
    private Main mainApp;

    public AddAndEditStudentController() {
    }

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
        if (student == null) {
            firstNameField.setText("Enter first name");
            lastNameField.setText("Enter last name");
            yearOfBirthField.setText("yyyy");
        }
        else {
            firstNameField.setText(student.getFirstName());
            lastNameField.setText(student.getLastName());
            yearOfBirthField.setText(student.getYearOfBirth());
            if (student.getPromotion()=="L3") {
                L3promotionField.setSelected(true);
            }
            else if (student.getPromotion()=="M1") {
                M1promotionField.setSelected(true);
                if (student.getSpecialisation() == "Biotechnology") {
                    BiotechnologySpecialisationField.setSelected(true);
                }
                else if (student.getSpecialisation() == "Physiology") {
                    PhysiologySpecialisationField.setSelected(true);
                }
                else {
                    ImagingSpecialisationField.setSelected(true);
                }
            }
            else {
                M2promotionField.setSelected(true);
            }

        }
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

            RadioButton selectedRadioButton = (RadioButton) Promo.getSelectedToggle();
            String PromoGroupValue = selectedRadioButton.getText();

            if (PromoGroupValue == L3promotionField.toString()) {
                student.setPromotion("L3");
            } else if (PromoGroupValue == M1promotionField.toString()) {
                student.setPromotion("M1");
            } else if (PromoGroupValue == M2promotionField.toString()) {
                student.setPromotion("M2");
            }
            RadioButton selectedRadioButton2 = (RadioButton) Spe.getSelectedToggle();
            if (selectedRadioButton2!=null) {
                String SpeGroupValue = selectedRadioButton2.getText();

                if (SpeGroupValue == BiotechnologySpecialisationField.toString()) {
                    student.setSpecialisation("Biotechnology");
                } else if (SpeGroupValue == PhysiologySpecialisationField.toString()) {
                    student.setSpecialisation("Physiology");
                } else if (SpeGroupValue == ImagingSpecialisationField.toString()) {
                    student.setSpecialisation("Imaging");
                }
            }
            else {
                student.setSpecialisation(null);
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
    /**
     * Redirection to the page where there is the student list
     */
    @FXML
    private void redirectStudentList() {
        mainApp.showPersonOverview();
    }


}
