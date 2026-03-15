package tests;

import org.junit.jupiter.api.Test;
import pages.DemoqaRegFormTestPage;


import static testdata.testData.*;

public class DemoqaRegFormTest extends TestBase {
    DemoqaRegFormTestPage demoqaRegFormTestPage = new DemoqaRegFormTestPage();

    @Test
    void successFillFormTest() {
        demoqaRegFormTestPage
                .openPage()
                .banerRemover()
                .formHavText("Student Registration Form")
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(dayForSelector, month, year)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(imgPath + img)
                .currentAddress(currentAddress)
                .setStateAndCity(state, stateCity)
                .submitRegForm();

        demoqaRegFormTestPage
                .checkFormField("Student Name", firstName + " " + lastName)
                .checkFormField("Student Email", userEmail)
                .checkFormField("Gender", gender)
                .checkFormField("Mobile", userNumber)
                .checkFormField("Date of Birth", expectedDate)
                .checkFormField("Subjects", subject)
                .checkFormField("Hobbies", hobby)
                .checkFormField("Picture", img)
                .checkFormField("Address", currentAddress)
                .checkFormField("State and City", state + " " + stateCity);


    }
}