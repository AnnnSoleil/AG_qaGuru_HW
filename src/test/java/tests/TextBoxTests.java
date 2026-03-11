package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.testData.*;


public class TextBoxTests extends TestBase {

    @Test
    void successfulFillFormTest() {

        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue(usEmail);
        $("[id=currentAddress]").setValue(curAddress);
        $("[id=permanentAddress]").setValue(permAddress);
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text(userName));
        $("[id=output] [id=email]").shouldHave(text(usEmail));
        $("[id=output] [id=currentAddress]").shouldHave(text(curAddress));ъпше
        $("[id=output] [id=permanentAddress]").shouldHave(text(permAddress));
        }


    @Test
    void successfulFillFormWithoutAddressTest() {

        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue(usEmail);
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text(userName));
        $("[id=output] [id=email]").shouldHave(text(usEmail));
        }
    }