package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull org.openqa.selenium.Capabilities ignored) {

        BrowserStackConfig config = ConfigFactory.create(
                BrowserStackConfig.class, System.getProperties()
        );

        MutableCapabilities caps = new MutableCapabilities();

        // ===== W3C BrowserStack options =====
        MutableCapabilities bstackOptions = new MutableCapabilities();
        bstackOptions.setCapability("userName", config.browserstackUser());
        bstackOptions.setCapability("accessKey", config.browserstackKey());
        bstackOptions.setCapability("deviceName", config.deviceName());
        bstackOptions.setCapability("osVersion", config.osVersion());
        bstackOptions.setCapability("projectName", config.project());
        bstackOptions.setCapability("buildName", config.buildName());
        bstackOptions.setCapability("sessionName", config.testName());

        // ===== base capabilities =====
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", config.app());
        caps.setCapability("appium:automationName", config.appiumAutomationName());

        // 🔑 ключевая строка
        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new RemoteWebDriver(
                    new URL("https://hub-cloud.browserstack.com/wd/hub"),
                    caps
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}