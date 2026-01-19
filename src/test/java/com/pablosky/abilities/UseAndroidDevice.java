package com.pablosky.abilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Ability;

public class UseAndroidDevice implements Ability {
    private final AndroidDriver<MobileElement> driver;

    public UseAndroidDevice(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public static UseAndroidDevice with(AndroidDriver<MobileElement> driver) {
        return new UseAndroidDevice(driver);
    }

    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }
}