package tests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    public void testIssueSearch() {
        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys("AG_qaGuru_HW");
        $("#query-builder-test").pressEnter();


        $(linkText("AnnnSoleil/AG_qaGuru_HW")).click();
        $("#issues-tab").click();
        $(withText("#80")).should(Condition.exist);
    }
}
