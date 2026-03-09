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
import static tests.testdata.testData.*;

public class DemoqaRegFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void successfillFormTest() {
        open(formUrl);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("""
document.getElementById('fixedban')?.remove();
document.querySelector('footer')?.remove();
""");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--" + dayForSelector + ":not(react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(imgPath + img);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(stateCity)).click();
        $(byId("submit")).click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(modalWinTest));
        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(expectedDate));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text(hobby));
        $(".table-responsive").shouldHave(text(img));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state));
        $(".table-responsive").shouldHave(text(stateCity));
    }
}

