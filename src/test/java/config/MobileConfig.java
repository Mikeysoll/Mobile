package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:mobile.properties",
})

public interface MobileConfig extends Config {

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("app")
    String app();

    @Key("appium:automationName")
    String appiumAutomationName();

    @Key("deviceName")
    String deviceName();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

}
