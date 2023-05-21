package starter.web.wikipedia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import starter.web.wikipedia.ui.WikipediaArticle;

public class AnswerSearchSuccessfully implements Question<Boolean> {

    private String strQuestion;


    public AnswerSearchSuccessfully(String strQuestion) {
        this.strQuestion = strQuestion;
    }

    public static AnswerSearchSuccessfully toThe(String strQuestion) {
        return new AnswerSearchSuccessfully(strQuestion);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String strSuccessfullySignUp= Text.of(WikipediaArticle.HEADING).answeredBy(actor);
        return (strQuestion.equals(strSuccessfullySignUp)) ? true : false;
    }

    
}
