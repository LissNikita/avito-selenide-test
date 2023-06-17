package tests;

import lombok.extern.log4j.Log4j2;
import org.avito.utils.JsonReader;
import org.avito.utils.RetryUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class AvitoTest extends BaseTest {

    @Test(retryAnalyzer = RetryUtils.class)
    public void findAudiCars() {

        log.info("Find Audi cars");
        $(By.xpath("//label"))
                .sendKeys("Audi", Keys.ENTER);
        $(By.xpath("//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']"))
                .shouldHave(text("Купить Audi"));
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkModelOfCars() {

        log.info("Check model of cars 'A4'");
        findAudiCars();
        $(By.xpath("//span[contains(text(), 'Модель')]//following::span[contains(text(), 'Любая')]"))
                .scrollTo()
                .click();

        $(By.xpath("//p[text() = 'A4']"))
                .scrollTo()
                .click();
        $(By.xpath("//div[@class = 'styles-gapContainer-_bE0D']"))
                .shouldBe(visible);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void selectFourWheelDriveCars() {

        log.info("Select four wheel driver cars");
        findAudiCars();
        $(By.xpath("//li[@title = 'полный']"))
                .scrollTo()
                .click();
        $(By.xpath("//button[@data-marker = 'search-filters/submit-button']"))
                .click();
        $(By.xpath("//h1[@class = 'page-title-text-tSffu page-title-inline-zBPFx']"))
                .scrollTo()
                .shouldHave(text(": полный привод"));
    }
}
