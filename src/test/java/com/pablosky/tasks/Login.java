package com.pablosky.tasks;

import com.pablosky.abilities.UseAndroidDevice;
import com.pablosky.pages.LoginPage;
import io.appium.java_client.MobileElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login withCredentials(String username, String password) {
        return Tasks.instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Extraer driver desde la habilidad del actor
        UseAndroidDevice ability = actor.abilityTo(UseAndroidDevice.class);
        io.appium.java_client.android.AndroidDriver<MobileElement> driver = ability.getDriver();

        MobileElement usernameField = (MobileElement) driver.findElementById(LoginPage.USERNAME_FIELD);
        MobileElement passwordField = (MobileElement) driver.findElementById(LoginPage.PASSWORD_FIELD);
        MobileElement loginButton = (MobileElement) driver.findElementById(LoginPage.LOGIN_BUTTON);

        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();

        // pequeña espera; ideal: reemplazar por esperas explícitas
        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}
    }
}