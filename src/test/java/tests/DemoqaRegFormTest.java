package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaRegFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "144.0";
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.timeout = 10000; // default 4000
    }

    @Test
    void successfillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Fedorov");
        $("#userEmail").setValue("fedorov@bk.ru");
//        $("#gender-radio-1").parent().click();
        $("#genterWrapper").$(byText("Female")).click();
        $(byId("userNumber")).setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1983");
        $(".react-datepicker__day--002:not(react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $(byId("currentAddress")).setValue("Novaya street 100");


        $(byId("submit")).click();

//        $("[name=q]").setValue("selenide").pressEnter();
//        $("[id=search]").shouldHave(text("https://selenide.org"));



//        $("[id=output] [id=name]").shouldHave(text("Alex Black"));
//        $("[id=output] [id=email]").shouldHave(text("alex@black.com"));
//        $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
//        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));
    }
}

