package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class RegistrationScreen {

    private final SelenideElement
            emailField = $("[text=Email]"),
            passwordField = $("[text=Password]"),
            confirmPasswordField = $("[content-desc=input-repeat-password]"),
            signUpButton = $("[content-desc=\"button-SIGN UP\"]"),
            successMessage = $("[text=\"You successfully signed up!\"]"),
            okButton = $("[text=OK]");

    @Step("Enter email: {email}")
    public RegistrationScreen enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Enter password: {password}")
    public RegistrationScreen enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Confirm password: {password}")
    public RegistrationScreen confirmPassword(String password) {
        confirmPasswordField.sendKeys(password);
        return this;
    }

    @Step("Click Sign Up button")
    public RegistrationScreen clickSignUp() {
        signUpButton.click();
        return this;
    }

    @Step("Verify successful registration message")
    public RegistrationScreen verifySuccessfulRegistration() {
        successMessage.shouldBe(visible);
        okButton.click();
        return this;
    }
}