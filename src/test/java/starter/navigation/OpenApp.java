package starter.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenApp implements Task {

    public static OpenApp frisbyColombia() {
        return instrumented(OpenApp.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Serenity handles the Appium driver initialization based on serenity.conf
        // No additional action needed here as the app is launched via capabilities
    }
}