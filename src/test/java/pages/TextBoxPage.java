package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxPage {
    //Elements
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement usEmailInput = $("#userEmail");
    private final SelenideElement curAddressInput = $("#currentAddress");
    private final SelenideElement permAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputResults = $("#output");

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
