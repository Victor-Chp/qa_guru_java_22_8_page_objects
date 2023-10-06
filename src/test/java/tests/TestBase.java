package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginInBookStorePage;
import pages.StudentRegistrationFormPage;
import pages.TextBoxPage;

public class TestBase {

    StudentRegistrationFormPage registrationFormPage = new StudentRegistrationFormPage();
    LoginInBookStorePage loginInBookStorePage = new LoginInBookStorePage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

}
