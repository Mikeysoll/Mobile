package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.FormScreen;
import screens.LoginScreen;
import screens.RegistrationScreen;
import screens.components.Footer;

import static io.qameta.allure.Allure.step;
@Tag("emulator")
public class WdioTests extends TestBase {

    private static final Faker faker = new Faker();
    private final LoginScreen loginScreen = new LoginScreen();
    private final RegistrationScreen registrationScreen = new RegistrationScreen();
    private final Footer footer = new Footer();
    FormScreen formScreen = new FormScreen();

    @Test
    void registrationTest() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        footer.clickLoginButton();

        loginScreen.clickSignUp();

        registrationScreen
                .enterEmail(email)
                .enterPassword(password)
                .confirmPassword(password)
                .clickSignUp()
                .verifySuccessfulRegistration();
    }

    @Test
    void loginTest() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        footer.clickLoginButton();

        loginScreen
                .enterEmail(email)
                .enterPassword(password)
                .clickLogin()
                .verifySuccessfulLogin();
    }

    @Test
    void componentsFormTest() {
        footer.clickFormButton();
        formScreen.setInputValue("TestString")
                .clickToggleSwitch()
                .clickDropdown()
                .selectDropdownValue()
                .clickButtonActive();

    }
}
