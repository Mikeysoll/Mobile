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






}
