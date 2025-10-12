package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {
    @Test
    public void checkIssueSelenideTest() {
        final String REPO_LINK = "JulianaAstra/qa_guru_hw08";
        final String ISSUES_TAB_TEXT = "Issues";
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