package pav.matrosov;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.partialLinkText;

public class ListenerTest {

    private static final String URL = "https://github.com/Matrosov1811";
    private static final String REPOSITORY = "qa-guru.hw6";
    private static final int ISSUE_NUMBER = 1;

    @Test
    void issueTestListener () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(URL);
        $(".UnderlineNav-body").$(byText("Repositories")).click();
        $("#your-repos-filter").setValue(REPOSITORY).pressEnter();
        $(".source").$(byText(REPOSITORY)).click();
        $(partialLinkText("Issues")).click();
        $(".opened-by").shouldHave(text("#" + ISSUE_NUMBER));
    }

}
