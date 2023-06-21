package org.avito.steps;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.avito.pages.MainPage;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;

@Data
@Log4j2
public class CoreSteps {
    MainPage mainPage = new MainPage();

    private final String TITLE_BUY_AUDI = "Купить Audi";
    private final String AUDI = "Audi";

    public void findAudiCar(String carName){
        log.info("Find audi car");
        mainPage.searchForm
                .sendKeys(carName, Keys.ENTER);
    }

    public void verifyTitle(String title){
        log.info("Verify expect title");
        mainPage.title
                .shouldHave(text(title));
    }
}
