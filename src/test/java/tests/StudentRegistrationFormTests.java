package tests;

import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void successfulRegistrationFillAllFieldsTest() {

        registrationFormPage.openPage()
                        .setFirstName("John")
                        .setLastName("Howard")
                        .setEmail("john@gmail.com")
                        .setGender("Other")
                        .setUserNumber("1234567890")
                        .setDateOfBirth("16", "April", "1983")
                        .setSubjects("History")
                        .setHobbies("Sports")
                        .uploadPicture("account.png")
                        .setAddress("Lenina str, 100-200")
                        .setState("Rajasthan")
                        .setCity("Jaipur")
                        .clickSubmit();

        registrationFormPage.checkResultModalTable("Student Name", "John Howard")
                .checkResultModalTable("Student Email", "john@gmail.com")
                .checkResultModalTable("Gender", "Other")
                .checkResultModalTable("Mobile", "1234567890")
                .checkResultModalTable("Date of Birth", "16 April,1983")
                .checkResultModalTable("Subjects", "History")
                .checkResultModalTable("Hobbies", "Sports")
                .checkResultModalTable("Picture", "account.png")
                .checkResultModalTable("Address", "Lenina str, 100-200")
                .checkResultModalTable("State and City", "Rajasthan Jaipur");

    }

    @Test
    void successfulRegistrationFillRequiredFieldsTest() {

        registrationFormPage.openPage()
                .setFirstName("John")
                .setLastName("Howard")
                .setEmail("john@gmail.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .clickSubmit();

        registrationFormPage.checkResultModalTable("Student Name", "John Howard")
                .checkResultModalTable("Student Email", "john@gmail.com")
                .checkResultModalTable("Gender", "Other")
                .checkResultModalTable("Mobile", "1234567890");
    }

    @Test
    void unsuccessfulRegistrationFillWrongEmailTest() {

        registrationFormPage.openPage()
                .setFirstName("John")
                .setLastName("Howard")
                .setEmail("john@gmail")
                .setGender("Other")
                .setUserNumber("1234567890")
                .clickSubmit();

        registrationFormPage.checkModalDialogHidden();
    }

    @Test
    void unsuccessfulRegistrationNotFillFormTest() {

        registrationFormPage.openPage()
                .clickSubmit();

        registrationFormPage.checkModalDialogHidden();
    }
}
