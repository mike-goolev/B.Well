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

public class ContentHeaderSteps extends ServiceHooks {

    private HomePage homePage;
    private ContentPage contentPage;

    private String appName;
    private String email;
    private String password;
    private String languageIndex;

    @Before("@Header")
    public void testsSetUp() {
        System.out.println("\nExecuting preconditions for " + this.getClass().getName() + "...\n");

        appName = (String) TestDataImporter.get("BWellTestData", "BWellTestData").get("appName");
        email = (String) TestDataImporter.get("BWellTestData", "BWellTestData").get("email");
        password = (String) TestDataImporter.get("BWellTestData", "BWellTestData").get("password");
        languageIndex = (String) TestDataImporter.get("BWellTestData", "BWellTestData").get("languageIndex");

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

    /* Sign In background */
    @Given("User is signed in")
    public void userIsSignedIn() {
        homePage.loadHomePageByURL();
        homePage.enterApplicationName(appName);
        homePage.enterEmailAddress(email);
        homePage.enterPassword(password);
        homePage.clickOnSignInButton();
    }

    /* Header navigation scenario */
    @Given("Navigation tab buttons are displayed")
    public void iCanSeeNavigationButtons() {
        Assert.assertTrue(contentPage.verifyNavigationTabBtn(), "Not all tab navigation buttons are displayed");
    }

    @When("I click on Analytics tab navigation")
    public void iClickOnAnalyticsTabNavigation() {
        contentPage.clickOnAnalyticsBtn();
    }

    @Then("I should be on {string} analyze page")
    public void iShouldBeOnAnalyzePage(String arg0) {
        Assert.assertEquals(contentPage.verifyAnalyzePageUrl(), "http://login.myappcms.com/analyze");
    }

    @When("I click on Push Message tab navigation")
    public void iClickOnPushMessageTabNavigation() {
        contentPage.clickOnPushMessagesBtn();
    }

    @Then("I should be on {string} push messages page")
    public void iShouldBeOnPushMessagePage(String arg0) {
        Assert.assertEquals(contentPage.verifyPushMessagePageUrl(), "http://login.myappcms.com/pushmessages");
    }

    @When("I click on Manage Your App tab navigation")
    public void iClickOnManageYourAppTabNavigation() {
        contentPage.clickOnManageYourAppBtn();
    }

    @Then("I should be on {string} page")
    public void iShouldBeOnContentPage(String arg0) {
        Assert.assertEquals(contentPage.verifyContentPageByURL(), "http://login.myappcms.com/build");
    }

    /* Sign Out scenario */
    @Given("Content Demo Account button is displayed")
    public void iSeeDemoAccountButton() {
        Assert.assertEquals(contentPage.verifyContentDemoAccountBtn(), "Demo Account");
    }

    @When("I click on Demo Account button")
    public void iClickOnDemoAccountButton() {
        contentPage.clickOnDemoAccountBtn();
    }

    @And("I click on Sign out button")
    public void iClickOnSignOutButton() {
        contentPage.clickOnSignOutBtn();
    }

    @Then("I should be logged out and see sign in form")
    public void iShouldBeLoggedOutAndSeeSignInForm() {
        Assert.assertEquals(contentPage.verifySignInFormTitle(), "Please sign in");
    }

    /* Language change scenario */
    @When("I click on {string} button")
    public void iClickOnDemoAccountButton(String arg0) {
        contentPage.clickOnDemoAccountBtn();
    }

    @And("I click on drop down menu")
    public void iClickOnDropDownMenu() {
        contentPage.clickOnLanguageDropDown();
    }

    @And("I select a language from drop down")
    public void iSelectALanguageFromDropDown() {
        contentPage.selectLanguage(languageIndex);
    }

    @Then("Tab navigation buttons should be translated")
    public void tabNavigationButtonsShouldBeTranslated() {
        Assert.assertTrue(contentPage.verifyNavigationTabButtonsTranslated(), "Not all tab navigation buttons are translated");
    }

    @And("I select default English language")
    public void iSelectDefaultEnglishLanguage() {
        contentPage.clickOnDemoAccountBtn();
        contentPage.clickOnLanguageDropDown();
        contentPage.selectEnglishLanguage();
    }

    @Then("Tab navigation buttons should be translated into English")
    public void tabNavigationButtonsAreTranslatedIntoEnglish() {
        Assert.assertTrue(contentPage.verifyNavigationTabBtn(), "Not all tab navigation buttons are translated");
    }
}
