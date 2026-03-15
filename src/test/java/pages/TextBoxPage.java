package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.testData.userName;

public class TextBoxPage {
    //Elements
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement usEmailInput = $("#userEmail");
    private SelenideElement curAddressInput = $("#currentAddress");
    private SelenideElement permAddressInput = $("#permanentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#output");

    //Actions
    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage typeUsEmail(String value) {
        usEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage typeCurAddress(String value) {
        curAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage typePermAddress(String value) {
        permAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));

        return this;
    }
 //
}
