package pages;

import com.codeborne.selenide.SelenideElement;
import pages.cimponents.CalendarComponent;
import pages.cimponents.RegResultsComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.testData.*;

public class DemoqaRegFormTestPage {
    CalendarComponent calendar = new CalendarComponent();
    RegResultsComponents resultsForm = new RegResultsComponents();
    //Elements
    private SelenideElement formText = $(".practice-form-wrapper");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsContainer = $("#subjectsInput");
    private SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private SelenideElement submitRegButton = $("#submit");


    //Actions
    public DemoqaRegFormTestPage openPage() {
        open(formUrl);
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        return this;
    }

    public DemoqaRegFormTestPage formHavText(String value) {
        formText.shouldHave(text(value));

        return this;
    }

    public DemoqaRegFormTestPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public DemoqaRegFormTestPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public DemoqaRegFormTestPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public DemoqaRegFormTestPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public DemoqaRegFormTestPage typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public DemoqaRegFormTestPage setDateOfBirth(String dayForSelector, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(dayForSelector, month, year);

        return this;
    }

    public DemoqaRegFormTestPage setSubject(String value) {
        subjectsContainer.setValue(value);
        $(byText(value)).click();

        return this;
    }

    public DemoqaRegFormTestPage setHobby(String value) {
        hobbiesContainer.$(byText(value)).scrollTo().click();

        return this;
    }

    public DemoqaRegFormTestPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public DemoqaRegFormTestPage currentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public DemoqaRegFormTestPage setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public DemoqaRegFormTestPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public DemoqaRegFormTestPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public DemoqaRegFormTestPage submitRegForm() {
        submitRegButton.click();

        return this;
    }

    public DemoqaRegFormTestPage checkFormField(String key, String value) {

        resultsForm.formHasText();
        resultsForm.checkResult(key, value);


        return this;
    }
}
