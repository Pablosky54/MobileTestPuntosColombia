package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheLoginResult {

    public static Question<String> message() {
        return Text.of("//div[@id='result']").asString();
    }
}