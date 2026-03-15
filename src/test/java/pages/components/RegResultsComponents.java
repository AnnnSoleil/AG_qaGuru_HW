package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static testdata.testData.modalWinTest;

public class RegResultsComponents {
    private final SelenideElement modalResult = $(".modal-dialog");
    private final SelenideElement titleResult = $("#example-modal-sizes-title-lg");
    private final SelenideElement tableResult = $(".table-responsive");

    public void formHasText() {
        modalResult.should(appear);
        titleResult.shouldHave(text(modalWinTest));
    }

    public void checkResult(String key, String value) {
        tableResult
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
    }

}


