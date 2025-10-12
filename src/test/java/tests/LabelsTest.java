package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Feature("Таб Issue в репозитории")
    @Story("Перейти в Issues репозитория")
    @Owner("julianaastra")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Проверка таба Issues в репозитории")
    public void testStaticLabels() {
    }
}