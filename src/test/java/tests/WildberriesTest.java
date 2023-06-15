package tests;

import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WildberriesTest {

    @Test
    public void findProduct(){
        open("https://www.wildberries.by/");

        $(By.xpath("//button[@class='header__hamburger']")).click();

        $(withText("Женщинам")).shouldBe(visible);
    }
}
