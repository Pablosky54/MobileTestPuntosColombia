package com.pablosky.factory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static AndroidDriver<MobileElement> createDriver() {
        String apkPath = System.getenv().getOrDefault("FRISBY_APK_PATH", "frisby_v128.apk");
        String appiumServer = System.getenv().getOrDefault("APPIUM_SERVER", "http://localhost:4723/wd/hub");
        String deviceName = System.getenv().getOrDefault("DEVICE_NAME", "AndroidEmulator");
        String platformVersion = System.getenv().getOrDefault("PLATFORM_VERSION", "");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", deviceName);
        if (!platformVersion.isEmpty()) {
            caps.setCapability("platformVersion", platformVersion);
        }
        caps.setCapability("app", apkPath);
        caps.setCapability("noReset", true);

        try {
            return new AndroidDriver<>(new URL(appiumServer), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL inválida: " + appiumServer, e);
        }
    }
}