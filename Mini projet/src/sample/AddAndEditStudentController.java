package sample;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.time.LocalDate;
import java.util.Optional;


/**
 * Class which allows to edit details of a student
 * @author Florimel Flotté, Salomé Rebours, Enola Roudaut
 * @version 30/04/2021
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
    private void handleModify() {

        if (isInputValid()) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Are you sure want to validate ? The information will be saved.");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == ButtonType.OK) {
                okClicked = true;
            }
            if (okClicked) {

                student.setFirstName(firstNameField.getText());
                student.setLastName(lastNameField.getText());
                student.setYearOfBirth(yearOfBirthField.getText());

                RadioButton selectedRadioButton = (RadioButton) Promo.getSelectedToggle();
                String PromoGroupValue = selectedRadioButton.getText();

                if (PromoGroupValue == L3promotionField.getText()) {
                    student.setPromotion("L3");
                } else if (PromoGroupValue == M1promotionField.getText()) {
                    student.setPromotion("M1");
                } else if (PromoGroupValue == M2promotionField.getText()) {
                    student.setPromotion("M2");
                }
                RadioButton selectedRadioButton2 = (RadioButton) Spe.getSelectedToggle();
                if (selectedRadioButton2 != null) {
                    String SpeGroupValue = selectedRadioButton2.getText();

                    if (SpeGroupValue == BiotechnologySpecialisationField.getText()) {
                        student.setSpecialisation("Biotechnology");
                    } else if (SpeGroupValue == PhysiologySpecialisationField.getText()) {
                        student.setSpecialisation("Physiology");
                    } else if (SpeGroupValue == ImagingSpecialisationField.getText()) {
                        student.setSpecialisation("Imaging");
                    }
                } else {
                    student.setSpecialisation(null);
                }

                mainApp.showPersonOverview();
            }

        }
    }
    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleAdd() {
        if (isInputValid()) {
            Student student = new Student();
            student.setFirstName(firstNameField.getText());
            student.setLastName(lastNameField.getText());
            student.setYearOfBirth(yearOfBirthField.getText());

            RadioButton selectedRadioButton = (RadioButton) Promo.getSelectedToggle();
            String PromoGroupValue = selectedRadioButton.getText();

            if (PromoGroupValue == L3promotionField.getText()) {
                student.setPromotion("L3");
            } else if (PromoGroupValue == M1promotionField.getText()) {
                student.setPromotion("M1");
            } else if (PromoGroupValue == M2promotionField.getText()) {
                student.setPromotion("M2");
            }
            RadioButton selectedRadioButton2 = (RadioButton) Spe.getSelectedToggle();
            if (selectedRadioButton2!=null) {
                String SpeGroupValue = selectedRadioButton2.getText();

                if (SpeGroupValue == BiotechnologySpecialisationField.getText()) {
                    student.setSpecialisation("Biotechnology");
                } else if (SpeGroupValue == PhysiologySpecialisationField.getText()) {
                    student.setSpecialisation("Physiology");
                } else if (SpeGroupValue == ImagingSpecialisationField.getText()) {
                    student.setSpecialisation("Imaging");
                }
            }
            else {
                student.setSpecialisation(null);
            }

            okClicked = true;
            mainApp.addStud(student);

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

        if (errorMessage == "") {
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
     * Sets the main app reference
     * @param mainApp the mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Redirection to the page where there is the student list
     */

    @FXML
    private void redirectStudentList() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Are you sure want to quit ? The information will not be saved.");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK) {
            mainApp.showPersonOverview();
        }
    }
}
