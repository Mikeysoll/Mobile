package config;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${envHost}.properties",
        "system:properties",
        "system:env",
})
public interface EmulatorConfig extends Config {

    @Key("PlatformName")
    String PlatformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("DeviceName")
    String DeviceName();

    @Key("AppPath")
    String AppPath();

    @Key("AppPackage")
    @DefaultValue("com.wdiodemoapp")
    String AppPackage();

    @Key("AppActivity")
    @DefaultValue("com.wdiodemoapp.MainActivity")
    String AppActivity();

}
