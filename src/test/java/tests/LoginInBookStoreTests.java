package tests;

import org.junit.jupiter.api.Test;


public class LoginInBookStoreTests extends TestBase {

    @Test
    void successfulLogin() {
        loginInBookStorePage.openPage()
                .setUserName("Chupakabra")
                .setPassword("Pass1234_*")
                .clickLogin()
                .checkRedirectToPage("Profile")
                .clickLogOut();

    }

    @Test
    void unsuccessfulLoginWithWrongUserName() {
        loginInBookStorePage.openPage()
                .setUserName("DWKLJDLK")
                .setPassword("Pass1234_*")
                .clickLogin()
                .checkMessageInvalidLogin();

    }

    @Test
    void unsuccessfulLoginWithWrongPassword() {
        loginInBookStorePage.openPage()
                .setUserName("Chupakabra")
                .setPassword("Bfghghjg1*23")
                .clickLogin()
                .checkMessageInvalidLogin();

    }

    @Test
    void unsuccessfulLoginWithEmptyFields() {
        loginInBookStorePage.openPage()
                .setUserName("")
                .setPassword("")
                .clickLogin()
                .checkInvalidUserName()
                .checkInvalidPassword();

    }

    @Test
    void unsuccessfulLoginWithEmptyUserName() {
        loginInBookStorePage.openPage()
                .setUserName("")
                .setPassword("Pass1234_*")
                .clickLogin()
                .checkInvalidUserName();

    }

    @Test
    void unsuccessfulLoginWithEmptyPassword() {
        loginInBookStorePage.openPage()
                .setUserName("Chupakabra")
                .setPassword("")
                .clickLogin()
                .checkInvalidPassword();
    }
}
