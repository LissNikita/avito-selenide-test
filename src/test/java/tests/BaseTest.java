package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.wildberries.utils.PropertyReader;

import static com.codeborne.selenide.Selenide.open;

abstract public class BaseTest {

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @BeforeMethod
    public void init() {
        open(PropertyReader.getPropertyValue("URL"));
        setUp();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
