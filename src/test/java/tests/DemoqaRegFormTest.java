package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DemoqaRegFormTestPage;


import static testdata.testData.*;
import static utils.RandomUtils.*;

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

    String firstNameU;
    String lastNameU;
    String userEmailU;
    String genderU;
    String userNumberU;
    String subjectU;
    String hobbyU;
    String currentAddressU;


    @BeforeEach
    void prepareRandomData() {
        firstNameU = getRandomString(10);
        lastNameU = getRandomString(10);
        userEmailU = getRandomEmail();
        genderU = getRandomGender();
        userNumberU = getRandomPhone();
        subjectU = getRandomItemFromStringArray(new String[]{"Maths", "Physics", "English"});
        hobbyU = getRandomItemFromStringArray(new String[]{"Sports", "Reading", "Music"});
        currentAddressU = getRandomString(100);

    }

    @Test
    void successfulFill_DMQ_Test_with_utils_with_before_each() {

        demoqaRegFormTestPage
                .openPage()
                .banerRemover()
                .formHavText("Student Registration Form")
                .typeFirstName(firstNameU)
                .typeLastName(lastNameU)
                .typeUserEmail(userEmailU)
                .setGender(genderU)
                .typeUserNumber(userNumberU)
                .setDateOfBirth(dayForSelector, month, year)
                .setSubject(subjectU)
                .setHobby(hobbyU)
                .uploadPicture(imgPath + img)
                .currentAddress(currentAddressU)
                .setStateAndCity(state, stateCity)
                .submitRegForm();

    }
}