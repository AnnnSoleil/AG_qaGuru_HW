package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.DemoqaRegFormTestPage;
import testdata.TestDataU;

import java.util.stream.Stream;

public class DemoqaRegFormParamTest extends TestBase {
    TestDataU data;
    DemoqaRegFormTestPage demoqaRegFormTestPage = new DemoqaRegFormTestPage();

    @BeforeEach
    void prepareData() {
        data = new TestDataU();
    }

    private void successFillRequiredFields() {

        demoqaRegFormTestPage
                .openPage()
                .banerRemover()
                .formHavText("Student Registration Form")
                .typeFirstName(data.firstNameU)
                .typeLastName(data.lastNameU)
                .setGender(data.genderU)
                .typeUserNumber(data.userNumberU);
    }

    @ParameterizedTest(name = "Проверка регистрации с хобби {0}")
    @ValueSource(strings = {"Sports", "Reading", "Music"})
    void hobbyParameterizedTest(String hobbyP) {
        successFillRequiredFields();
        demoqaRegFormTestPage
                .setHobby(hobbyP)
                .submitRegForm()
                .checkFormField("Hobbies", hobbyP);
    }

    @ParameterizedTest(name = "Проверка регистрации State/City: {0} / {1}")
    @CsvSource({
            "NCR, Delhi",
            "NCR, Gurgaon",
            "NCR, Noida",
            "Uttar Pradesh, Agra",
            "Uttar Pradesh, Lucknow",
            "Uttar Pradesh, Merrut",
            "Haryana, Karnal",
            "Haryana, Panipat",
            "Rajasthan, Jaipur",
            "Rajasthan, Jaiselmer"
    })
    void stateCityParameterizedTest(String stateP, String stateCityP) {
        successFillRequiredFields();
        demoqaRegFormTestPage
                .setStateAndCity(stateP, stateCityP)
                .submitRegForm()
                .checkFormField("State and City", stateP + " " + stateCityP);
    }

    @ParameterizedTest(name = "Проверка предмета: {0}")
    @MethodSource("subjectProvider")
    void subjectParameterizedTest(String subjectP) {
        successFillRequiredFields();
        demoqaRegFormTestPage
                .setSubject(subjectP)
                .submitRegForm()
                .checkFormField("Subjects", subjectP);
    }

    static Stream<String> subjectProvider() {
        return Stream.of(
                "Maths",
                "Physics",
                "English",
                "Computer Science",
                "Biology"
        );
    }
}
