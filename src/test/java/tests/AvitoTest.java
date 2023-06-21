package tests;

import lombok.extern.log4j.Log4j2;
import org.avito.models.CarData;
import org.avito.pages.*;
import org.avito.steps.CoreSteps;
import org.avito.steps.SelectionModelsStep;
import org.avito.utils.JsonReader;
import org.avito.utils.RetryUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class AvitoTest extends BaseTest {

    private MainPage mainPage;
    private AudiSelectionPage audiSelectionPage;
    private AuthorizationPage authorizationPage;
    private StoriesPage storiesPage;
    private CoreSteps coreSteps;
    private SelectionModelsStep selectionModelsStep;


    @BeforeClass
    public void startPage() {
        mainPage = new MainPage();
        audiSelectionPage = new AudiSelectionPage();
        authorizationPage = new AuthorizationPage();
        storiesPage = new StoriesPage();
        coreSteps = new CoreSteps();
        selectionModelsStep = new SelectionModelsStep();
    }

    @Test(dataProvider = "carNameData", dataProviderClass = JsonReader.class, retryAnalyzer = RetryUtils.class)
    public void findAudiCars(CarData carData) {

        coreSteps.findAudiCar(carData.getCarName());
        coreSteps.verifyTitle(coreSteps.getTITLE_BUY_AUDI());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkingModelOfCars() {

        log.info("Check model of cars 'A4'");

        coreSteps.findAudiCar(coreSteps.getAUDI());
        selectionModelsStep.clickOnModelOfCar();
        selectionModelsStep.clickOnCheckBoxModel();
        selectionModelsStep.verifyContainerWithModelsVisible();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkingSelectionFourWheelDriveCars() {

        log.info("Select four wheel driver cars");
        mainPage.searchForm
                .sendKeys("Audi", Keys.ENTER);
        audiSelectionPage.buttonDriveOfCar
                .scrollTo()
                .click();
        audiSelectionPage.buttonFilterSearch
                .click();
        mainPage.title
                .scrollTo()
                .shouldHave(text(": полный привод"));
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkingSelectionOfManShoes() {

        log.info("Checking selection of man shoes");
        mainPage.buttonAllCategories
                .click();
        mainPage.columnPersonalThings
                .click();
        mainPage.buttonManShoes
                .click();
        mainPage.title
                .shouldHave(text("Мужская обувь"));
    }

    @Test
    public void checkBotProtection(){
        log.info("Check bot protection 'fail test for screenshot'");

        mainPage.loginButton
                .click();
        authorizationPage.accountLogin
                .sendKeys("+1234567");
        authorizationPage.accountPassword
                .sendKeys("1234567");
        authorizationPage.buttonEnter
                .click();
        authorizationPage.messageError
                .shouldHave(text("Укажите мобильный телефон"));
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkSwitchingStories(){
        log.info("Сhecking switching between stories");

        mainPage.buttonStories
                .click();
        storiesPage.basketballStory
                .shouldBe(visible);
        try {
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        storiesPage.footballStory
                        .shouldBe(visible);
    }

//    @Test
//    public void cheapestPrise(){
//
//        mainPage.buttonElectronics
//                .click();
//        electronicsPage.iPhone11
//                .click();
//        SelenideElement cheapestProduct = FindPrice.findCheapestPrise();
//        String productName = cheapestProduct.find("item-title").getText();
//        System.out.println(productName);
//    }
}
