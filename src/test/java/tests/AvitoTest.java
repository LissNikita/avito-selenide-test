package tests;

import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.avito.models.CarData;
import org.avito.models.UserData;
import org.avito.steps.AuthorizationStep;
import org.avito.steps.CategoriesStep;
import org.avito.steps.CoreStep;
import org.avito.steps.ModelsOfCarStep;
import org.avito.utils.JsonReader;
import org.avito.utils.RetryUtils;
import org.avito.utils.Waiter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Log4j2
public class AvitoTest extends BaseTest {
    private CoreStep coreStep;
    private ModelsOfCarStep modelsOfCarStep;
    private CategoriesStep categoriesStep;
    private AuthorizationStep authorizationStep;

    @BeforeClass
    public void startPage() {
        coreStep = new CoreStep();
        modelsOfCarStep = new ModelsOfCarStep();
        categoriesStep = new CategoriesStep();
        authorizationStep = new AuthorizationStep();
    }

    @Test(dataProvider = "carData", dataProviderClass = JsonReader.class, retryAnalyzer = RetryUtils.class)
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

    @Issue("Element not found")
    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkBotProtection(UserData userData) {
        log.info("Check bot protection 'fail test for screenshot'");

        coreStep.clickOnLoginButton();
        authorizationStep.setLogin(userData.getLogin());
        authorizationStep.setPassword(userData.getPassword());
        authorizationStep.clickOnButtonEnter();
        authorizationStep.verifyMessageError(authorizationStep.getERROR_MESSAGE());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkSwitchingStories() {
        log.info("Сhecking switching between stories");

        coreStep.clickOnStoriesButton();
        coreStep.verifyTitleOfStoryBasketball();
        Waiter.sleep();
        coreStep.verifyTitleOfStoryFootball();
    }
}
