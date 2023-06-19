package org.avito.utils;

import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForVisibility(SelenideElement selenideElement) {
        new WebDriverWait(WebDriverManager.chromedriver().create(), Duration.ofSeconds(13))
                .until(ExpectedConditions.visibilityOf(selenideElement));
    }

    public static void waitForClickable(SelenideElement selenideElement) {
        new WebDriverWait(WebDriverManager.chromedriver().create(), Duration.ofSeconds(13))
                .until(ExpectedConditions.elementToBeClickable(selenideElement));
    }
}
