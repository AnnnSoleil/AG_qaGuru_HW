package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static testdata.testData.*;
//import static testdata.testData.userName;


public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

//    @Test
//    void successfulFillFormTest() {
//
//        textBoxPage.openPage()
//                .typeUserName(userName)
//                .typeUsEmail(usEmail)
//                .typeCurAddress(curAddress)
//                .typePermAddress(permAddress)
//                .submitForm()
//                .checkField("name", userName)
//                .checkField("email", usEmail)
//                .checkField("currentAddress", curAddress)
//                .checkField("permanentAddress", permAddress);
//        }
//
//
//    @Test
//    void successfulFillFormWithoutAddressTest() {
//
//        textBoxPage.openPage()
//                .typeUserName(userName)
//                .typeUsEmail(usEmail)
//                .submitForm()
//                .checkField("name", userName)
//                .checkField("email", usEmail);
//        }

    @Test
    void successfulFillFormTest_with_faker() {
        Faker faker = new Faker();
        Faker fakerRu = new Faker(new Locale("ru"));
        String userName = fakerRu.name().fullName();
        String usEmail = faker.internet().emailAddress();
        String curAddress = fakerRu.address().fullAddress();
        String permAddress = fakerRu.address().fullAddress();


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

}