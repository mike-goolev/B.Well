package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DashboardPage extends BasePage {

    private final Locators.DashboardPageLocators dashboardPageLocators;

    public DashboardPage(WebDriver driver) {
        super(driver);
        dashboardPageLocators = new Locators.DashboardPageLocators();
    }

    /**
     * Verifies the dashboard page URL
     */
    public String verifyDashboardPageByURL() {
        wait.until(visibilityOfElementLocated(dashboardPageLocators.dashboardTitle));
        String currentUrl = driver.getCurrentUrl();
        String toUrl = "http://login.myappcms.com/build";
        if (!currentUrl.equals(toUrl)) {
            driver.get(toUrl);
        }
        return driver.getCurrentUrl();
    }

    /**
     * Checks the text of the Dashboard page title
     *
     * @return The the text of the Dashboard page title
     */
    public String getDashboardTitleText() {
        wait.until(visibilityOfElementLocated(By.xpath("//span[contains(text(),'CMS DEMO ACCOUNT')]")));
        return driver.findElement(dashboardPageLocators.dashboardTitle).getText();
    }

    /**
     * Clicks on Appointments in the left Dashboard menu
     */
    public void clickOnAppointments() {
        click(dashboardPageLocators.appointmentsBtn);
    }

    /**
     * Clicks on Services under Appointments menu
     */
    public void clickOnServices() {
        click(dashboardPageLocators.servicesBtn);
    }

    /**
     * Verifies if sort of Appointment services by name is in ascending order
     *
     * @return Whether or not sort is in ascending order of Appointment services by name
     */
    public boolean verifySortedData() {
        wait.until(visibilityOfElementLocated(dashboardPageLocators.firstRow));

        // determine rows count in the table
        List<WebElement> rows = driver.findElements(dashboardPageLocators.rows);
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
        click(dashboardPageLocators.serviceNameSortBtn);

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
     * Enters a keyword in a search box
     */
    public void enterKeyword(String keyWord) {
        setElementText(dashboardPageLocators.searchTextfield, keyWord);
    }

    /**
     * Verifies retrieved data in the table after searching by a keyword
     */
    public void verifyTableRetrievedData() {
        wait.until(visibilityOfElementLocated(dashboardPageLocators.firstRow));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // determine rows and columns count of the table
        List<WebElement> rows = driver.findElements(dashboardPageLocators.rows);
        List<WebElement> columns = driver.findElements(dashboardPageLocators.columns);
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
}
