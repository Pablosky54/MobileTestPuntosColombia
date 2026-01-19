package com.pablosky.stepdefinitions;

import com.pablosky.factory.DriverFactory;
import com.pablosky.tasks.Login;
import com.pablosky.questions.IsHomeDisplayed;
import com.pablosky.abilities.UseAndroidDevice;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginSteps {

    private Actor actor;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named(System.getenv().getOrDefault("TEST_ACTOR", "Pablo"));
        AndroidDriver<MobileElement> driver = DriverFactory.createDriver();
        actor.can(UseAndroidDevice.with(driver));
    }

    @After
    public void tearDown() {
        try {
            UseAndroidDevice ability = actor.abilityTo(UseAndroidDevice.class);
            if (ability != null && ability.getDriver() != null) {
                ability.getDriver().quit();
            }
        } catch (Exception ignored) {}
    }

    @Given("la aplicación está abierta en el emulador")
    public void laAplicacionEstaAbierta() {
        // Hook inicia la app; no-op aquí
    }

    @When("intento iniciar sesión con usuario {string} y contraseña {string}")
    public void intentoIniciarSesion(String usuario, String contrasena) {
        actor.attemptsTo(Login.withCredentials(usuario, contrasena));
    }

    @Then("debería ver la pantalla principal")
    public void deberiaVerPantallaPrincipal() {
        boolean displayed = actor.asksFor(IsHomeDisplayed.onScreen());
        assertThat(displayed, is(true));
    }
}