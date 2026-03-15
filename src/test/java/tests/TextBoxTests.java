package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.testData.*;


public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillFormTest() {

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUsEmail(usEmail)
                .typeCurAddress(curAddress)
                .typePermAddress(permAddress)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", usEmail)
                .checkField("currentAddress", curAddress)
                .checkField("permanentAddress", permAddress);
        }


    @Test
    void successfulFillFormWithoutAddressTest() {

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUsEmail(usEmail)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", usEmail);
        }
    }