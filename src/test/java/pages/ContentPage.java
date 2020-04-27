package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ContentPage extends BasePage {

    private final Locators.ContentPageLocators contentPageLocators;
    private final Locators.HomePageLocators homePageLocators;

    public ContentPage(WebDriver driver) {
        super(driver);
        contentPageLocators = new Locators.ContentPageLocators();
        homePageLocators = new Locators.HomePageLocators();
    }

    /**
     * Verifies the content page URL
     */
    public String verifyContentPageByURL() {
        wait.until(visibilityOfElementLocated(contentPageLocators.contentTitle));
        return driver.getCurrentUrl();
    }

    /**
     * Checks the text of the Content page title
     *
     * @return The the text of the Content page title
     */
    public String getContentTitleText() {
        wait.until(visibilityOfElementLocated(By.xpath("//span[contains(text(),'CMS DEMO ACCOUNT')]")));
        return driver.findElement(contentPageLocators.contentTitle).getText();
    }

    /**
     * Clicks on the Appointments in the left Content menu
     */
    public void clickOnAppointments() {
        click(contentPageLocators.appointmentsBtn);
    }

    /**
     * Clicks on Services under Appointments menu
     */
    public void clickOnServices() {
        click(contentPageLocators.servicesBtn);
    }

    /**
     * Verifies if the sort of Appointment services by name is in ascending order
     *
     * @return Whether or not the sort is in ascending order of Appointment services by name
     */
    public boolean verifySortedData() {
        wait.until(visibilityOfElementLocated(contentPageLocators.firstRow));

        // determine rows count in the table
        List<WebElement> rows = driver.findElements(contentPageLocators.rows);
        int rowCount = rows.size();

        // fetching data from Service Name column before sorting
        List unsorted = new ArrayList();
        for (int i = 1; i <= rowCount; i++) {
            String cellData = driver.findElement(By.xpath("//body/div/div/section/section/div/div/div/div/div/div/div/ul/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[" + i + "]/td[1]")).getText();
            unsorted.add(cellData);
        }

        // sort list of data from Service Name column
        List temp = new ArrayList();
        temp.addAll(unsorted);

        //Ascending
        Collections.sort(temp, String.CASE_INSENSITIVE_ORDER);

        // Click on Service Name column in the table
        click(contentPageLocators.serviceNameSortBtn);

        // Fetching data from Service Name column after sorting
        List sorted = new ArrayList();
        for (int i = 1; i <= rowCount; i++) {
            String cellData = driver.findElement(By.xpath("//body/div/div/section/section/div/div/div/div/div/div/div/ul/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[" + i + "]/td[1]")).getText();
            sorted.add(cellData);
        }

        // Verify Service names ​sorted in ascending order
        if (temp.equals(sorted)) {
            System.out.println("Service Name column is sorted in ascending order:\n" + sorted);
        }
        return true;
    }

    /**
     * Enters a keyword in the search box
     */
    public void enterKeyword(String keyWord) {
        setElementText(contentPageLocators.searchTextfield, keyWord);
    }

    /**
     * Verifies retrieved data in the table after searching by a keyword
     */
    public void verifyTableRetrievedData() {
        wait.until(visibilityOfElementLocated(contentPageLocators.firstRow));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // determine rows and columns count of the table
        List<WebElement> rows = driver.findElements(contentPageLocators.rows);
        List<WebElement> columns = driver.findElements(contentPageLocators.columns);
        int rowCount = rows.size();
        int columnsCount = columns.size();

        // fetching data from entire table
        List data = new ArrayList();
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= columnsCount; j++) {
                String cellData = driver.findElement(By.xpath("//body/div/div/section/section/div/div/div/div/div/div/div/ul/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                data.add(cellData);
            }
        }
        if (!data.isEmpty()) {
            int occurrences = Collections.frequency(data, "colour");
            System.out.println("Keyword 'colour' was found " + occurrences + " time(s) inside the table");
            System.out.println(data);
        } else {
            System.out.println("Search result is empty");
        }
    }

    /**
     * Clicks on the Analytics tab navigation button
     */
    public void clickOnAnalyticsBtn() {
        click(contentPageLocators.analyticsBtn);
    }

    /**
     * Verifies the content page URL
     */
    public String verifyAnalyzePageUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Clicks on the Push Message tab navigation button
     */
    public void clickOnPushMessagesBtn() {
    click(contentPageLocators.pushMessageBtn);
    }

    /**
     * Verifies the Push message page URL
     */
    public String verifyPushMessagePageUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Clicks on the Manage Your App tab navigation button
     */
    public void clickOnManageYourAppBtn() {
        click(contentPageLocators.manageYourAppBtn);
    }

    /**
     * Clicks on the Demo Account button
     */
    public void clickOnDemoAccountBtn() {
        click(contentPageLocators.demoAccountBtn);
    }

    /**
     * Checks to see if the all tab navigation buttons are displayed
     *
     * @return Whether or not the all tab navigation buttons are displayed
     */
    public boolean verifyNavigationTabBtn() {
        wait.until(visibilityOfElementLocated(contentPageLocators.contentTitle));
        return driver.findElement(contentPageLocators.manageYourAppBtn).getText().equals("Manage Your App") &&
                driver.findElement(contentPageLocators.analyticsBtn).getText().equals("Analytics") &&
                driver.findElement(contentPageLocators.pushMessageBtn).getText().equals("Push Message");
    }

    /**
     * Verifies the Demo Account button
     */
    public String verifyContentDemoAccountBtn() {
        wait.until(visibilityOfElementLocated(contentPageLocators.demoAccountBtn));
        return driver.findElement(contentPageLocators.demoAccountBtn).getText();
    }

    /**
     * Clicks on the Sign out button
     */
    public void clickOnSignOutBtn() {
        click(contentPageLocators.signOutBtn);
    }

    /**
     * Verifies the Demo Account button
     */
    public String verifySignInFormTitle() {
        wait.until(visibilityOfElementLocated(homePageLocators.signInFormTitle));
        return driver.findElement(homePageLocators.signInFormTitle).getText();
    }

    /**
     * Clicks on the language drop dowm
     */
    public void clickOnLanguageDropDown() {
        wait.until(visibilityOfElementLocated(contentPageLocators.languageDropDown));
        click(contentPageLocators.languageDropDown);
    }

    /**
     * Selects the language from drop down
     *
     * @param index
     * index [1] - English
     * index [2] - Nederlands
     * index [3] - español
     * index [4] - português
     * index [5] - Deutsch
     * index [6] - 中文(简体)
     * index [7] - 中文(繁體)
     * index [8] - русский
     * index [9] - polski
     * index [10] - suomi
     *
     */
    public void selectLanguage(String index) {
        click(contentPageLocators.languageFromDropDown(index));
        wait.until(invisibilityOfElementLocated(contentPageLocators.contentTitle));
    }

    /**
     * Selects English language into the input text field
     */
    public void selectEnglishLanguage() {
        setElementText(contentPageLocators.languageInput, "English");
        driver.findElement(contentPageLocators.languageInput).sendKeys(Keys.ENTER);
        wait.until(invisibilityOfElementLocated(contentPageLocators.contentTitle));
    }

    /**
     * Checks to see if the all tab navigation buttons are translated
     *
     * @return Whether or not the all tab navigation buttons are translated
     */
    public boolean verifyNavigationTabButtonsTranslated() {
        wait.until(visibilityOfElementLocated(contentPageLocators.contentTitle));
        return driver.findElement(contentPageLocators.manageYourAppBtn).getText().equals("Управление приложением") &&   // translated 'Manage Your App" button into Russian
                driver.findElement(contentPageLocators.analyticsBtn).getText().equals("Аналитика") &&                   // translated 'Analytics" button into Russian
                driver.findElement(contentPageLocators.pushMessageBtn).getText().equals("Пуш-уведомления");             // translated 'Push Message" button into Russian
    }
}
