package org.avito.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.avito.pages.MainPage;

@Log4j2
public class CategoriesStep {

    MainPage mainPage = new MainPage();

    private final String OWN_THINGS = "Личные вещи";
    private final String MAN_SHOES = "Мужская обувь";

    @Step("Click on button all categories")
    public void clickOnButtonAllCategories() {
        log.info("Click on button all categories");
        mainPage.buttonAllCategories
                .click();
    }

    @Step("Click on column personal things")
    public void clickOnColumnPersonalThings() {
        log.info("Click on column personal things");
        mainPage.columnPersonalThings(OWN_THINGS)
                .click();
    }

    @Step("Click on button man shoes")
    public void clickOnButtonManShoes() {
        log.info("Click on button man shoes");
        mainPage.buttonManShoes(MAN_SHOES)
                .click();
    }
}
