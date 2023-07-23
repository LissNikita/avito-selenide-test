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
    private final String HELP_LIZA_ALERT = "Помогите «ЛизаАлерт»";
    private final String WHO_IS_LOOKING_FOR_NEAR_YOU = "Кого ищут рядом с вами";

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

    @Step("Verify tittle of story (LizaAlert)")
    public void verifyTitleOfStoryHelpLizaAlert() {
        log.info("Verify tittle of story (LizaAlert)");
        storiesPage.basketballStory(HELP_LIZA_ALERT)
                .shouldBe(visible);
    }

    @Step("Verify tittle of story (Who is looking for near you)")
    public void verifyTitleOfStoryWhoIsLookingForNearYou() {
        log.info("Verify tittle of story (Who is looking for near you)");
        storiesPage.footballStory(WHO_IS_LOOKING_FOR_NEAR_YOU)
                .shouldBe(visible);
    }
}
