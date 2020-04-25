package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BasePage {

    public static WebDriver driver;
    public WebDriverWait wait;
    private int waitInSeconds;

    public BasePage(WebDriver d) {
        driver = d;

        /* Setup fluent wait */
        waitInSeconds = 20;
        wait = new WebDriverWait(driver, waitInSeconds, 500);
        wait.ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementNotSelectableException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    /**
     * Clears an element's text
     *
     * @param identifier the By object for the click event
     */
    void clearElementText(By identifier) {
        try {
            click(identifier);
            driver.findElement(identifier).clear();
        } catch (Exception e) {
            System.out.println("The element's text should be empty");
        }
    }

    /**
     * Sets text of an element
     *
     * @param identifier the By object
     * @param text       the text to send to the identifier
     */
    public void setElementText(By identifier, String text) {
        try {
            clearElementText(identifier);
            driver.findElement(identifier).sendKeys(text);
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("No such element found");
        }
    }

    /**
     * Clicks an element
     *
     * @param identifier the By object
     */
    public void click(By identifier) {
        try {
            wait.until(elementToBeClickable(identifier));
            driver.findElement(identifier).click();
        } catch (NoSuchElementException | ElementClickInterceptedException | StaleElementReferenceException e) {
            driver.findElement(identifier).click();
        }
    }
}
