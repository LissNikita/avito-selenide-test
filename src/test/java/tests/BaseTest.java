package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.extern.log4j.Log4j2;
import org.avito.utils.PropertyReader;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
abstract public class BaseTest {

    private final String URL = PropertyReader.getPropertyValue("URL");

    @BeforeMethod
    @Parameters({"startType", "browser", "version"})
    public void setUp(String statType,
                      @Optional("browser") String browser,
                      @Optional("version") String version) {
        if (statType.equals("local")) {
            startLocal();
        } else if (statType.equals("selenoid")) {
            startSelenoid(browser, version);
        }
        log.info("BEFORE METHOD");
        open(URL);
    }

    @AfterMethod
    public void tearDown() {
        log.info("AFTER CLASS");
        clearBrowserLocalStorage();
        clearBrowserCookies();
    }

    public static void startLocal() {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true)
                .enableLogs(LogType.BROWSER, Level.ALL));
    }

    public static void startSelenoid(String browser, String version) {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true)
                .enableLogs(LogType.BROWSER, Level.ALL));
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = browser;

        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", false);
        options.put("enableLog", true);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setVersion(version);
        capabilities.setCapability("selenoid:options", options);
        Configuration.browserCapabilities = capabilities;
    }
}
