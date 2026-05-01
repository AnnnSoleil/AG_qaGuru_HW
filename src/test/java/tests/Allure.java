package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Allure {
    @Test
    public void testIssueSearch() {
        open("https://github.com/");
        $(".header-search-button").click();
        $(".header-search-button").sendKeys("erodhenkoam/allure-example");
    }
}
