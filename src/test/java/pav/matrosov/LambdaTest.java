package pav.matrosov;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTest {

    private static final String URL = "https://github.com/Matrosov1811";
    private static final String REPOSITORY = "qa-guru.hw6";
    private static final int ISSUE_NUMBER = 1;

    @Test
    void issueLambdaTest (){

        step("Open the repository page", () -> {
            open(URL);
        });
        step("search repository", () -> {
            $(".UnderlineNav-body").$(byText("Repositories")).click();
            $("#your-repos-filter").setValue(REPOSITORY).pressEnter();
        });
        step("open repository", () -> {
            $(".source").$(byText(REPOSITORY)).click();
        });
        step("open the tab Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("check issue", () -> {
            $(".opened-by").shouldHave(text("#" + ISSUE_NUMBER));
        });
    }

}
