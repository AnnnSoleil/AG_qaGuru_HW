package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static testdata.testData.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;



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

    @Test
    void successfulFillFormTest_with_faker() {
        Faker faker = new Faker();
        Faker fakerRu = new Faker(new Locale("ru"));
        String userNameF = fakerRu.name().fullName();
        String usEmailF = faker.internet().emailAddress();
        String curAddressF = fakerRu.address().fullAddress();
        String permAddressF = fakerRu.address().fullAddress();


        textBoxPage.openPage()
                .typeUserName(userNameF)
                .typeUsEmail(usEmailF)
                .typeCurAddress(curAddressF)
                .typePermAddress(permAddressF)
                .submitForm()
                .checkField("name", userNameF)
                .checkField("email", usEmailF)
                .checkField("currentAddress", curAddressF)
                .checkField("permanentAddress", permAddressF);

        textBoxPage.checkField("name", userNameF);
        textBoxPage.checkField("email", usEmailF);
        $("[id=output] [id=currentAddress]").shouldHave(text(curAddressF));
        $("[id=output] [id=permanentAddress]").shouldHave(text(permAddressF));
    }

    @Test
    void successfulFillFormTest_with_utils() {
        String userNameU = getRandomString(10);
        String usEmailU = getRandomEmail();
        String curAddressU = getRandomString(100);
        String permAddressU = getRandomString(90);

        textBoxPage.openPage();
        textBoxPage.typeUserName(userNameU);
        textBoxPage.typeUsEmail(usEmailU);
        $("[id=currentAddress]").setValue(curAddressU);
        $("[id=permanentAddress]").setValue(permAddressU);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userNameU);
        textBoxPage.checkField("email", usEmailU);
        $("[id=output] [id=currentAddress]").shouldHave(text(curAddressU));
        $("[id=output] [id=permanentAddress]").shouldHave(text(permAddressU));
    }

    String userNameU;
    String userEmailU;
    String currentAddressU;
    String permanentAddressU;
    }

//
//@Test
//void successfulFillFormTest_with_utils_with_before_each() {
//    textBoxPage.openPage();
//    textBoxPage.typeUserName(userNameU);
//    textBoxPage.typeUserEmail(userEmailU);
//    $("[id=currentAddress]").setValue(currentAddressU);
//    $("[id=permanentAddress]").setValue(permanentAddressU);
//    textBoxPage.submitForm();
//
//    textBoxPage.checkField("name", userNameU);
//    textBoxPage.checkField("email", userEmailU);
//    $("[id=output] [id=currentAddress]").shouldHave(text(currentAddressU));
//    $("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddressU));
//}
//
//
//@Test
//void successfulFillFormWithoutAddressTest_old() {
//    open("/text-box");
//    $("[id=userName]").setValue(userName);
//    $("[id=userEmail]").setValue(userEmail);
//    $("[id=submit]").click();
//
//    $("[id=output] [id=name]").shouldHave(text(userName));
//    $("[id=output] [id=email]").shouldHave(text(userEmail));
//}
//


