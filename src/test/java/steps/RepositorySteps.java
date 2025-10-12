package steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.AttachmentHelper;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class RepositorySteps {
    final SelenideElement searchBtn = $(".header-search-button");
    final SelenideElement searchInput = $("#query-builder-test");

    AttachmentHelper attachmentHelper = new AttachmentHelper();

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("");
    }

    @Step("Раскрыть поисковую строку")
    public void searchButtonClick() {
        searchBtn
                .shouldBe(visible)
                .click();
        attachmentHelper.takeScreenshot();
    }

    @Step("Найти репозиторий {repo}")
    public void findRepository(String repo) {
        searchInput.sendKeys(repo);
        attachmentHelper.takeScreenshot();
        searchInput.submit();
    }

    @Step("Перейти в репозиторий {repo}")
    public void checkoutRepository(String repo) {
        $(linkText(repo))
                .should(exist)
                .click();
    }

    @Step("Таб {tab} отображается")
    public void checkTabExist(String tab) {
        $(withText(tab)).should(exist);
    }
}
