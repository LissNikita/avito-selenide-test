package tests;

import lombok.extern.log4j.Log4j2;
import org.avito.models.CarData;
import org.avito.pages.AudiSelectionPage;
import org.avito.pages.AuthorizationPage;
import org.avito.pages.MainPage;
import org.avito.pages.StoriesPage;
import org.avito.steps.CategoriesStep;
import org.avito.steps.CoreStep;
import org.avito.steps.ModelsOfCarStep;
import org.avito.utils.JsonReader;
import org.avito.utils.RetryUtils;
import org.avito.utils.Waiter;
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
    private CoreStep coreStep;
    private ModelsOfCarStep modelsOfCarStep;
    private CategoriesStep categoriesStep;


    @BeforeClass
    public void startPage() {
        mainPage = new MainPage();
        audiSelectionPage = new AudiSelectionPage();
        authorizationPage = new AuthorizationPage();
        storiesPage = new StoriesPage();
        coreStep = new CoreStep();
        modelsOfCarStep = new ModelsOfCarStep();
        categoriesStep = new CategoriesStep();
    }

    @Test(dataProvider = "carNameData", dataProviderClass = JsonReader.class, retryAnalyzer = RetryUtils.class)
    public void findAudiCars(CarData carData) {

        coreStep.findAudiCar(carData.getCarName());
        coreStep.verifyTitle(coreStep.getTITLE_BUY_AUDI());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkingModelOfCars() {

        log.info("Check model of cars 'A4'");

        coreStep.findAudiCar(coreStep.getAUDI());
        modelsOfCarStep.clickOnModelOfCar();
        modelsOfCarStep.clickOnCheckBoxModel();
        modelsOfCarStep.verifyContainerWithModelsVisible();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkingSelectionFourWheelDriveCars() {

        log.info("Select four wheel driver cars");

        coreStep.findAudiCar(coreStep.getAUDI());
        modelsOfCarStep.clickOnButtonDriverOfCar();
        modelsOfCarStep.clickOnButtonFilterSearch();
        coreStep.verifyTitle(coreStep.getDRIVE_UNIT());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkingSelectionOfManShoes() {

        log.info("Checking selection of man shoes");
        categoriesStep.clickOnButtonAllCategories();
        categoriesStep.clickOnColumnPersonalThings();
        categoriesStep.clickOnButtonManShoes();
        coreStep.verifyTitle(coreStep.getMAN_SHOES());
    }

    @Test
    public void checkBotProtection() {
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
    public void checkSwitchingStories() {
        log.info("Сhecking switching between stories");

        mainPage.buttonStories
                .click();
        storiesPage.basketballStory
                .shouldBe(visible);
        Waiter.sleep();
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
