package org.avito.utils;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class Waiter {

    public static void sleep() {
        log.info("Sleep");
        try {
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForVisibility(SelenideElement selenideElement) {
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(13))
                .until(ExpectedConditions.visibilityOf(selenideElement));
    }

    public static void waitForClickable(SelenideElement selenideElement) {
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(13))
                .until(ExpectedConditions.elementToBeClickable(selenideElement));
    }
}