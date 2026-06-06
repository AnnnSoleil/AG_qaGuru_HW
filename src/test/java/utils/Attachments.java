package utils;

import io.qameta.allure.Attachment;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

    public class Attachments {

        @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
        public static byte[] takeScreenshot() {
            return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }
    }

