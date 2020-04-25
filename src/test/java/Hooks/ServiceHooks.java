package Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.BrowserFactory;
import utils.TestConfig;

import static org.testng.Reporter.log;

public class ServiceHooks {

    public WebDriver driver;

    public void baseTestSuiteSetup() {
        /* Set default URL */
        String envUrl = "http://login.myappcms.com/";
        TestConfig.setBaseUrl(envUrl);
    }

    public void baseTestClassSetup() {
        log( "\n**************************************************\n" +
                "* Initializing " + this.getClass().getSimpleName() + "...\n" +
                "**************************************************", true);

        String browser = "firefox";
        log("Browser: " + browser, true);

        System.setProperty("webdriver.gecko.driver", "geckodriver");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "warning_logs"); // suppress console warning log

        /* Create a webdriver instance */
        driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
    }

    public void baseTestClassTeardown(){
        log( "\n**************************************************\n" +
                "* Finishing " + this.getClass().getSimpleName() + "...\n" +
                "**************************************************", true);

        if (driver != null) {
            driver.quit();
        }
    }

    public void baseTestSuiteTeardown(){
        log( "\nTesting finished.\n", true);

        if (driver != null) {
            driver.quit();
        }
    }
}