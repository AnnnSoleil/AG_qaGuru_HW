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
                .checkFormField("Student Name", gender)
                .checkFormField("Student Name", userNumber)
                .checkFormField("Student Name", expectedDate)
                .checkFormField("Student Name", subject)
                .checkFormField("Student Name", hobby)
                .checkFormField("Student Name", img)
                .checkFormField("Student Name", currentAddress)
                .checkFormField("Student Name", state)
                .checkFormField("Student Name", stateCity);


    }
}

