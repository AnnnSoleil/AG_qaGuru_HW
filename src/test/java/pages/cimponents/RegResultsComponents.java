package pages.cimponents;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static testdata.testData.modalWinTest;

public class RegResultsComponents {
    public void formHasText() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(modalWinTest));
    }

    public void checkResult(String key, String value) {
        $(".table-responsive").shouldHave(text(key));
        $(".table-responsive").shouldHave(text(value));
    }

}


