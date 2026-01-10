package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class LoginScreen {

    private final SelenideElement
            emailField = $("[text=Email]"),
            passwordField = $("[text=Password]"),
            loginConfirmButton = $("[content-desc=button-LOGIN]"),
            signUpButton = $("[content-desc=button-sign-up-container]"),
            successMessage = $("[text=\"You are logged in!\"]"),
            okButton = $("[text=OK]");

    @Step("Enter email: {email}")
    public LoginScreen enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Enter password: {password}")
    public LoginScreen enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click Login button")
    public LoginScreen clickLogin() {
        loginConfirmButton.click();
        return this;
    }

    @Step("Click Sign Up button")
    public LoginScreen clickSignUp() {
        signUpButton.click();
        return this;
    }

    @Step("Verify successful login message")
    public LoginScreen verifySuccessfulLogin() {
        successMessage.shouldBe(visible);
        okButton.click();
        return this;
    }
}
