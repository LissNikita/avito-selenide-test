package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AvitoTest extends BaseTest {

    @Test
    public void findAudiCars() {

        open("https://www.avito.ru/");

        $(By.xpath("//label"))
                .sendKeys("Audi", Keys.ENTER);
        $(By.xpath("//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']")).shouldHave(text("Купить Audi"));

    }

    @Test
    public void checkModelOfCars() {
        findAudiCars();
        $(By.xpath("//span[contains(text(), 'Модель')]//following::span[contains(text(), 'Любая')]")).scrollTo().click();

        $(By.xpath("//p[text() = 'A4']")).scrollTo().click();
        $(By.xpath("//div[@class = 'styles-gapContainer-_bE0D']"))
               .shouldBe(visible);
    }

    @Test
    public void selectFourWheelDriveCars(){
        findAudiCars();
        $(By.xpath("//li[@title = 'полный']")).scrollTo().click();
        $(By.xpath("//button[@data-marker = 'search-filters/submit-button']")).click();
        $(By.xpath("//h1[@class = 'page-title-text-tSffu page-title-inline-zBPFx']")).scrollTo().shouldHave(text(": полный привод"));
    }
}