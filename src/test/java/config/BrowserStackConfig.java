package config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${envHost}.properties",
        "system:properties",
        "system:env",
})
public interface BrowserStackConfig extends Config {

    @Key("browserstackUser")
    String browserstackUser();

    @Key("browserstackKey")
    String browserstackKey();

    @Key("app")
    String app();

    @Key("appium.automationName")
    String appiumAutomationName();

    @Key("deviceName")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String deviceName();

    @Key("osVersion")
    @DefaultValue("12.0")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

}
