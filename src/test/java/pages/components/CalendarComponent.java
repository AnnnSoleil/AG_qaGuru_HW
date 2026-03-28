package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static testdata.testData.dayForSelector;

public class CalendarComponent {
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private final SelenideElement daySelect = $(".react-datepicker__day--" + dayForSelector + ":not(react-datepicker__day--outside-month)");

    public void setDate(String dayForSelector, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect.click();

    }
}
