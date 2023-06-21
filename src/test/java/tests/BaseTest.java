package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.extern.log4j.Log4j2;
import org.avito.utils.PropertyReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
abstract public class BaseTest {

    private final String URL = PropertyReader.getPropertyValue("URL");

    @BeforeClass
    public void setUp() {
        log.info("BEFORE CLASS");
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true)
                .enableLogs(LogType.BROWSER, Level.ALL));
    }

    @BeforeMethod
    public void init() {
        log.info("BEFORE METHOD");
        open(URL);
        setUp();
    }

    @AfterMethod
    public void tearDown() {
        log.info("AFTER CLASS");
        clearBrowserLocalStorage();
        clearBrowserCookies();
    }

}
