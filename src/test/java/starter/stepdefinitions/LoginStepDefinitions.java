package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.navigation.OpenApp;
import starter.tasks.Login;
import starter.questions.TheLoginResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the Frisby Colombia app is launched")
    public void theFrisbyColombiaAppIsLaunched() {
        Actor user = OnStage.theActorCalled("User");
        user.attemptsTo(OpenApp.frisbyColombia());
    }

    @Given("the user is on the login screen")
    public void theUserIsOnTheLoginScreen() {
        // Assuming the app launches to the login screen
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        Actor user = OnStage.theActorCalled("User");
        user.attemptsTo(Login.withCredentials(username, password));
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        Actor user = OnStage.theActorCalled("User");
        user.should(seeThat(TheLoginResult.message(), equalTo("Welcome")));
    }
}