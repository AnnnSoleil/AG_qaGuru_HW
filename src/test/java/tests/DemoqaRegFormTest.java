package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
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
    }

    @Test
    void successfillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
//        executeJavaScript("$('#fixedban').remove()"); //выполняем скрипт на стороне браузера (у меня отсутствовал, закомментирован для истории)
//        executeJavaScript("$('#footer  ').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Fedorov");
        $("#userEmail").setValue("fedorov@bk.ru");
//        $("#gender-radio-1").parent().click();
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1983");
        $(".react-datepicker__day--002:not(react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/IMG_5828.JPG");
//        $("#Select picture").uploadFile(new File("src/test/resources/img/IMG_5828.JPG");
        $("#currentAddress").setValue("Novaya street 100");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $(byId("submit")).click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan"), text("Fedorov"), text("fedorov@bk.ru"),
                text("Female"), text("1234567890"), text("02 July,1983"), text("Maths"), text("Music"),
                text("IMG_5828.JPG"), text("Novaya street 100"), text("Haryana"), text("Karnal"));


    }
}

