package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {

    private ConfigProvider() {}

    public static MobileConfig getConfig() {
        return ConfigFactory.create(MobileConfig.class);
    }
}
