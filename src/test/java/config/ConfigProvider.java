package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {

    private static final MobileConfig CONFIG = ConfigFactory.create(
            MobileConfig.class, System.getProperties()
    );

    private ConfigProvider() {}

    public static MobileConfig getConfig() {
        return CONFIG;
    }
}