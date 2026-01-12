package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    public static String envHost = System.getProperty("envHost", "emulator");

    @BeforeAll
    static void beforeAll() {
        browser = getDriver().getClass().getName();
        browserSize = null;
        timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        if (envHost.equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            System.out.println("Browserstack session: " + sessionId);

            Attach.pageSource();
            closeWebDriver();

            Attach.addVideo(sessionId);
        } else {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            closeWebDriver();
        }
    }

    static WebDriverProvider getDriver() {
        return switch (envHost) {
            case "browserstack" -> new BrowserstackDriver();
            case "emulator" -> new EmulatorDriver();
            default -> throw new IllegalArgumentException("Unknown device: ");
        };
    }
}