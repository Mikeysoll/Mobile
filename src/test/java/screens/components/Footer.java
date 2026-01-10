package screens.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Footer {

    private final SelenideElement
            loginButton = $("[content-desc=Login]"),
            formsButton = $("[content-desc=Forms]");

    @Step("Click Login button in Footer")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Click Forms button in Footer")
    public void clickFormButton() {
        formsButton.click();
    }
}
