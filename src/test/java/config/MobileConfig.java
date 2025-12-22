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

    @Key("appium.automationName")
    String appiumAutomationName();

    @Key("deviceName")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String deviceName();

    @Key("os_version")
    @DefaultValue("12.0")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

}
