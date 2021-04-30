package sample;
import javafx.beans.property.*;

/**
 * Class used to represent a student.
 * A student has a first name, a last name, a year of birth, a promotion and a specialisation.
 *
 * @author Salomé Rebours, Florimel Flotté, Enola Roudaut
 * @version 30/04/2021
 */
public class Student {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty yearOfBirth;
    private final StringProperty promotion;
    private final StringProperty specialisation;

    /**
     * Student constructor.
     * @param firstName the first name of the student
     * @param lastName the last name of the student
     * @param yearOfBirth the year of birth of the student
     * @param promotion the promotion of the student
     * @param specialisation the specialisation of the student
     */
    public Student(String firstName, String lastName, String yearOfBirth, String promotion, String specialisation) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.yearOfBirth = new SimpleStringProperty(yearOfBirth);
        this.promotion = new SimpleStringProperty(promotion);
        this.specialisation = new SimpleStringProperty(specialisation);

    }
    /**
     * Student constructor.
     * Initialize the fields to default values.
     */
    public Student() {
        this("", "", "0", "", "");
    }

    /**
     * @return the first name of the student
     */
    public String getFirstName() {
        return firstName.get();
    }

    /**
     * @return the firstNameProperty
     */
    public StringProperty firstNameProperty() {
        return firstName;
    }

    /**
     * Sets the first name of the student
     * @param firstName the student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    /**
     * @return the last name of the student
     */
    public String getLastName() {
        return lastName.get();
    }

    /**
     * @return the lastNameProperty
     */
    public StringProperty lastNameProperty() {
        return lastName;
    }

    /**
     * Sets the last name of the student
     * @param lastName the student's last name
     */
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    /**
     * @return the year of birth of the student
     */
    public String getYearOfBirth() {
        return yearOfBirth.get();
    }

    /**
     * @return the yearOfBirthProperty
     */
    public StringProperty yearOfBirthProperty() {
        return yearOfBirth;
    }

    /**
     * Sets the year of birth of the student
     * @param yearOfBirth the student's year of birth
     */
    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth.set(yearOfBirth);
    }

    /**
     * @return the promotion of the student
     */
    public String getPromotion() {
        return promotion.get();
    }

    /**
     * @return the promotionProperty
     */
    public StringProperty promotionProperty() {
        return promotion;
    }

    /**
     * Sets the promotion of the student
     * @param promotion the student's promotion
     */
    public void setPromotion(String promotion) {
        this.promotion.set(promotion);
    }

    /**
     * @return the specialisation of the student
     */
    public String getSpecialisation() {
        return specialisation.get();
    }

    /**
     * @return the specialisationProperty
     */
    public StringProperty specialisationProperty() {
        return specialisation;
    }

    /**
     * Sets the specialisation of the student
     * @param specialisation the student's specialisation
     */
    public void setSpecialisation(String specialisation) {
        this.specialisation.set(specialisation);
    }
}
