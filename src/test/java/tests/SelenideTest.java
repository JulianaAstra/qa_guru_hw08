package tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import static tests.TestData.ISSUES_TAB_TEXT;
import static tests.TestData.REPO_LINK;

public class SelenideTest extends TestBase {
    @Test
    public void checkIssueSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        final SelenideElement searchBtn = $(".header-search-button");
        final SelenideElement searchInput = $("#query-builder-test");
        final SelenideElement repoLink = $(linkText(REPO_LINK));

        open("");
        searchBtn
                .shouldBe(visible)
                .click();
        searchInput.sendKeys(REPO_LINK);
        searchInput.submit();

        repoLink
                .should(exist)
                .click();
        $(withText(ISSUES_TAB_TEXT)).should(exist);
    }
}