package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class RepositorySteps {
    final SelenideElement searchBtn = $(".header-search-button");
    final SelenideElement searchInput = $("#query-builder-test");

    @Step("Открыть главную страницу")
    void openMainPage() {
        open("");
    }

    @Step("Раскрыть поисковую строку")
    void searchButtonClick() {
        searchBtn
                .shouldBe(visible)
                .click();
    }

    @Step("Найти репозиторий {repo}")
    void findRepository(String repo) {
        searchInput.sendKeys(repo);
        searchInput.submit();
    }

    @Step("Перейти в репозиторий {repo}")
    void checkoutRepository(String repo) {
        $(linkText(repo))
                .should(exist)
                .click();
    }

    @Step("Таб {tab} отображается")
    void checkTabExist(String tab) {
        $(withText(tab)).should(exist);
    }

}
