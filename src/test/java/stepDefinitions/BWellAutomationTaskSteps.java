package stepDefinitions;

import hooks.ServiceHooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import pages.ContentPage;
import pages.HomePage;
import utils.TestDataImporter;

public class BWellAutomationTaskSteps extends ServiceHooks {
    private HomePage homePage;
    private ContentPage contentPage;

    private String appName;
    private String email;
    private String password;
    private String keyWord;

    @Before("@QA_task")
    public void testsSetUp() {
        System.out.println("\nExecuting preconditions for " + this.getClass().getName() + "...\n");

        appName = (String) TestDataImporter.get("BWellTestData", "BWellTestData").get("appName");
        email = (String) TestDataImporter.get("BWellTestData", "BWellTestData").get("email");
        password = (String) TestDataImporter.get("BWellTestData", "BWellTestData").get("password");
        keyWord = (String) TestDataImporter.get("BWellTestData", "BWellTestData").get("keyWord");

        baseTestSuiteSetup();
        baseTestClassSetup();

        homePage = new HomePage(driver);
        contentPage = new ContentPage(driver);
    }

    @After
    public void testsTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", "screenshot");
        }
        baseTestClassTeardown();
        baseTestSuiteTeardown();
    }

    /* Sign In scenario */
    @Given("I am on {string} home page")
    public void iAmOnLoginHomePage(String arg0) {
        homePage.loadHomePageByURL();
    }

    @When("I type ​string as App Name")
    public void iTypeAppName() {
        homePage.enterApplicationName(appName);
    }

    @And("I type ​username​ as Email address")
    public void iType​EmailAddress() {
        homePage.enterEmailAddress(email);
    }

    @And("I type ​password as Password")
    public void iType​Password() {
        homePage.enterPassword(password);
    }

    @And("I click on Sign in button")
    public void iClickOnSignInButton() {
        homePage.clickOnSignInButton();
    }

    @Then("I should see my Content")
    public void iShouldSeeMyContent() {
        Assert.assertEquals(contentPage.getContentTitleText(), "CMS DEMO ACCOUNT");
    }

    @Given("I am on {string} page")
    public void iAmOnContentPage(String arg0) {
        Assert.assertEquals(contentPage.verifyContentPageByURL(), "http://login.myappcms.com/build");
    }

    /* Sorting Appointments services scenario */
    @When("I click ​Sort Ascending option​ on ​Service Name​ column")
    public void iClick​On​ServiceName​Column() {
        contentPage.clickOnAppointments();
        contentPage.clickOnServices();
    }

    @Then("I should see correct results list after sorting")
    public void iShouldSeeCorrectResultsListAfterSorting() {
        Assert.assertTrue(contentPage.verifySortedData(), "Service Name column should be sorted in ascending order");
    }

    /* Searching Appointments services scenario */
    @When("I type ​keyword​ in the Search box")
    public void iType​keyword​InTheSearchBox() {
        contentPage.clickOnAppointments();
        contentPage.clickOnServices();
        contentPage.enterKeyword(keyWord);
    }

    @Then("I should see correct results list after searching")
    public void iShouldSeeCorrectResultsListAfterSearching() {
        contentPage.verifyTableRetrievedData();
    }
}