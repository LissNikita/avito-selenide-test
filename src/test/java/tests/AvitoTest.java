package tests;

import lombok.extern.log4j.Log4j2;
import org.avito.pages.AudiSelectionPage;
import org.avito.pages.MainPage;
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

    @BeforeClass
    public void startPage() {
        mainPage = new MainPage();
        audiSelectionPage = new AudiSelectionPage();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void findAudiCars() {

        log.info("Find Audi cars");
        mainPage.searchForm
                .sendKeys("Audi", Keys.ENTER);
        mainPage.title
                .shouldHave(text("Купить Audi"));
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkingModelOfCars() {

        log.info("Check model of cars 'A4'");
        findAudiCars();
        audiSelectionPage.modelOfCar
                .scrollTo()
                .click();
        audiSelectionPage.checkBoxModel
                .scrollTo()
                .click();
        audiSelectionPage.containerWithModels
                .shouldBe(visible);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void checkingSelectionFourWheelDriveCars() {

        log.info("Select four wheel driver cars");
        findAudiCars();
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
    public void checkingSelectionOfManShoes(){

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
}
