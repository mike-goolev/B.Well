package pages;

import org.openqa.selenium.WebDriver;
import utils.Locators;
import utils.TestConfig;

public class HomePage extends BasePage {
    private final Locators.HomePageLocators homePageLocators;

    public HomePage(WebDriver driver) {
        super(driver);
        homePageLocators = new Locators.HomePageLocators();
    }

    /**
     * Navigates to the home page via URL
     */
    public void loadHomePageByURL() {
        String currentUrl = driver.getCurrentUrl();
        String toUrl = TestConfig.getBaseUrl();

        if (!currentUrl.equals(toUrl)) {
            driver.get(toUrl);
        }
    }

    /**
     * Enters Application name
     */
    public void enterApplicationName(String name) {
        setElementText(homePageLocators.appName, name);
    }

    /**
     * Enters Email Address
     */
    public void enterEmailAddress(String email) {
        setElementText(homePageLocators.email, email);
    }

    /**
     * Enters Password
     */
    public void enterPassword(String password) {
        setElementText(homePageLocators.password, password);
    }

    /**
     * Clicks on Sign in button
     */
    public void clickOnSignInButton() {
        click(homePageLocators.signInBtn);
    }
}
