package org.avito.steps;

import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.avito.pages.MainPage;
import org.avito.pages.StoriesPage;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Data
@Log4j2
public class CoreStep {

    MainPage mainPage = new MainPage();
    StoriesPage storiesPage = new StoriesPage();

    private final String TITLE_BUY_AUDI = "Купить Audi";
    private final String AUDI = "Audi";
    private final String DRIVE_UNIT = ": полный привод";
    private final String MAN_SHOES = "Мужская обувь";
    private final String BALLS_FOR_BASKETBALL = "Мячи для баскетбола";
    private final String BALLS_FOR_FOOTBALL = "Мячи для футбола";

    @Step("Find audi car")
    public void findAudiCar(String carName) {
        log.info("Find audi car");
        mainPage.searchForm
                .sendKeys(carName, Keys.ENTER);
    }

    @Step("Verify expect title")
    public void verifyTitle(String title) {
        log.info("Verify expect title");
        mainPage.title
                .shouldHave(text(title));
    }

    @Step("Click on login button")
    public void clickOnLoginButton() {
        log.info("Click on login button");
        mainPage.loginButton
                .click();
    }

    @Step("Click on stories button")
    public void clickOnStoriesButton() {
        log.info("Click on stories button");
        mainPage.buttonStories
                .click();
    }

    @Step("Verify tittle of story (basketball)")
    public void verifyTitleOfStoryBasketball() {
        log.info("Verify tittle of story (basketball)");
        storiesPage.basketballStory(BALLS_FOR_BASKETBALL)
                .shouldBe(visible);
    }

    @Step("Verify tittle of story (football)")
    public void verifyTitleOfStoryFootball() {
        log.info("Verify tittle of story (football)");
        storiesPage.footballStory(BALLS_FOR_FOOTBALL)
                .shouldBe(visible);
    }
}
