package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        final MobileConfig config = ConfigFactory.create(
               MobileConfig.class, System.getProperties()
        );

        // Set your access credentials
        caps.setCapability("browserstack.user", config.browserstackUser());
        caps.setCapability("browserstack.key", config.browserstackKey());

        // Set URL of the application under test
        caps.setCapability("app", config.app());
        caps.setCapability("appium:automationName", config.appiumAutomationName());

        // Specify device and os_version for testing
        caps.setCapability("deviceName", config.deviceName());
        caps.setCapability("os_version", config.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", config.project());
        caps.setCapability("build", config.buildName());
        caps.setCapability("name", config.testName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub-cloud.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}