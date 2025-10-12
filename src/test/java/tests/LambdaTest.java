package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static tests.TestData.ISSUES_TAB_TEXT;
import static tests.TestData.REPO_LINK;

public class LambdaTest extends TestBase {
    @Test
    public void checkIssueSelenideTest() {

        final SelenideElement searchBtn = $(".header-search-button");
        final SelenideElement searchInput = $("#query-builder-test");
        final SelenideElement repoLink = $(linkText(REPO_LINK));

        step("Открыть главную страницу", () -> {
            open("");
        });

        step("Раскрыть поисковую строку", () -> {
            searchBtn
                    .shouldBe(visible)
                    .click();
        });

        step("Найти репозиторий по названию " + REPO_LINK, () -> {
            searchInput.sendKeys(REPO_LINK);
            searchInput.submit();
        });

        step("Перейти в репозиторий " + REPO_LINK, () -> {
            repoLink
                    .should(exist)
                    .click();
        });

        step("Таб " + ISSUES_TAB_TEXT + " отображается", () -> {
            $(withText(ISSUES_TAB_TEXT)).should(exist);
        });
    }
}
