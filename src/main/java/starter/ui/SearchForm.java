package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchForm {
    public static Target SEARCH_FIELD = Target.the("search field").locatedBy("#searchInput");

    public static Target LOGIN_BUTTON = Target.the("button to submit search").located(By.xpath("//*[@type=\"submit\"]"));

}
