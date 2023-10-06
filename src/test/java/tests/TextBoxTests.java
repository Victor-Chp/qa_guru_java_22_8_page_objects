package tests;

import org.junit.jupiter.api.Test;


public class TextBoxTests extends TestBase {

    @Test
    void successfulFillAllFields() {

        textBoxPage.openPage()
                .setUserName("Nicolay Tolstoy")
                .setUserEmail("tolstoy@gmail.com")
                .setCurrentAddress("Moscow Lenina str 200 300")
                .setPermanentAddress("Moscow Frunze str 33 28")
                .clickSubmit();

//        $("#output #name").shouldHave(exactText("Nicolay Tolstoy"));
        textBoxPage.checkResultOutput(
                        "Nicolay Tolstoy",
                        "tolstoy@gmail.com",
                        "Moscow Lenina str 200 300",
                        "Moscow Frunze str 33 28");

    }

    @Test
    void unsuccessfulFillWithWrongEmail() {
        textBoxPage.openPage()
                .setUserName("Nicolay Tolstoy")
                .setUserEmail("tolstoy@gmail")
                .setCurrentAddress("Moscow Lenina str 200 300")
                .setPermanentAddress("Moscow Frunze str 33 28")
                .clickSubmit();

        textBoxPage.checkInvalidEmail();
    }

    @Test
    void unsuccesfulEmptyFields() {
        textBoxPage.openPage()
                .setUserName("")
                .setUserEmail("")
                .setCurrentAddress("")
                .setPermanentAddress("")
                .clickSubmit();

        textBoxPage.checkOutputFieldIsEmpty();
    }
}
