package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AvitoTest {

    @Test
    public void findProduct() {

        open("https://www.avito.ru/");

        $(By.xpath("//label[@class='input-layout-input-layout-_HVr_ input-layout-size-s-COZ10 input-layout-text-align-left-U2OZJ width-width-12-_MkqF suggest-input-X6pqt js-react-suggest']"))
                .sendKeys("Audi", Keys.ENTER);
        $(By.xpath("//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']")).shouldHave(text("Купить Audi"));

    }
}
