package pav.matrosov.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.partialLinkText;

public class Steps {

    @Step
    public void openRepositoryPage (String url) {
        open(url);
    }

    @Step
    public void searchRepo (String repository) {
        $(".UnderlineNav-body").$(byText("Repositories")).click();
        $("#your-repos-filter").setValue(repository).pressEnter();
    }

    @Step
    public void openRepo (String repository) {
        $(".source").$(byText(repository)).click();
    }

    @Step
    public void openTab (String name) {
        $(partialLinkText(name)).click();
    }

    @Step
    public void checkIssue (int number) {
        $(".opened-by").shouldHave(text("#" + number));
    }


}
