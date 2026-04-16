package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import java.util.Locale;

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

    }

    @Test
    void successfulFillFormTest_with_utils() {
        String userNameU = getRandomString(10);
        String usEmailU = getRandomEmail();
        String curAddressU = getRandomString(100);
        String permAddressU = getRandomString(90);

        textBoxPage.openPage()
                .typeUserName(userNameU)
                .typeUsEmail(usEmailU)
                .typeCurAddress(curAddressU)
                .typePermAddress(permAddressU)
                .submitForm()
                .checkField("name", userNameU)
                .checkField("email", usEmailU)
                .checkField("currentAddress", curAddressU)
                .checkField("permanentAddress", permAddressU);

    }


    String userNameEach;
    String usEmailEach;
    String curAddressEach;
    String permAddressEach;

    @BeforeEach
    void prepareRandomData() {
        userNameEach = getRandomString(10);
        usEmailEach = getRandomEmail();
        curAddressEach = getRandomString(100);
        permAddressEach = getRandomString(80);
    }

    @Test
    void successfulFillFormTest_with_utils_with_before_each() {
        textBoxPage.openPage()
                .typeUserName(userNameEach)
                .typeUsEmail(usEmailEach)
                .typeCurAddress(curAddressEach)
                .typePermAddress(permAddressEach)
                .submitForm()
                .checkField("name", userNameEach)
                .checkField("email", usEmailEach)
                .checkField("currentAddress", curAddressEach)
                .checkField("permanentAddress", permAddressEach);
    }
}



