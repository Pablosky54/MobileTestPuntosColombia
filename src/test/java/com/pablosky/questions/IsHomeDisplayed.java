package com.pablosky.questions;

import com.pablosky.abilities.UseAndroidDevice;
import com.pablosky.pages.LoginPage;
import io.appium.java_client.MobileElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IsHomeDisplayed implements Question<Boolean> {

    public static IsHomeDisplayed onScreen() {
        return new IsHomeDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        UseAndroidDevice ability = actor.abilityTo(UseAndroidDevice.class);
        try {
            MobileElement home = (MobileElement) ability.getDriver().findElementById(LoginPage.HOME_WELCOME);
            return home != null && home.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}