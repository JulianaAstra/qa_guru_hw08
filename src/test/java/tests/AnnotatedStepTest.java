package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.RepositorySteps;

import static tests.TestData.ISSUES_TAB_TEXT;
import static tests.TestData.REPO_LINK;

public class AnnotatedStepTest extends TestBase{
    RepositorySteps steps = new RepositorySteps();

    @Feature("Таб Issue в репозитории")
    @Story("Перейти в Issues репозитория")
    @Owner("julianaastra")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Проверка таба Issues в репозитории")
    @Test
    public void annotatedStepTest() {
        steps.openMainPage();
        steps.searchButtonClick();
        steps.findRepository(REPO_LINK);
        steps.checkoutRepository(REPO_LINK);
        steps.checkTabExist(ISSUES_TAB_TEXT);
    }
}
