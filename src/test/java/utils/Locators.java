package utils;

import org.openqa.selenium.By;

public class Locators {

    /****************************************** Home Page *************************************************************/

    public static class HomePageLocators {
        public By appName = By.id("appName");
        public By email = By.id("username");
        public By password = By.id("password");
        public By signInBtn = By.xpath("//div[contains(text(),'Sign in')]");
        public By signInFormTitle = By.xpath("//h2[@class='form-signin-heading']");
    }

    /******************************************* Content Page *********************************************************/

    public static class ContentPageLocators {

        /* Header */
        public By contentTitle = By.xpath("//span[contains(text(),'CMS DEMO ACCOUNT')]");
        public By manageYourAppBtn = By.id("tab-content");
        public By analyticsBtn = By.id("tab-analytics");
        public By pushMessageBtn = By.id("tab-pushmessages");
        public By demoAccountBtn = By.xpath("//span[@class='display-name']");
        public By signOutBtn = By.id("sign-out");
        public By languageDropDown = By.xpath("//div[@class='div-language']");
        public By languageInput = By.xpath("//body/div/div/input[1]");
        public By languageFromDropDown(String index) {
            return By.xpath("//body//ul//li[" + index + "]");
        }

        /* Appointments Services */
        public By appointmentsBtn = By.xpath("//div[contains(text(),'Appointments')]");
        public By servicesBtn = By.xpath("//li[@class='app-item-view submenuItem green mjs-nestedSortable-branch mjs-nestedSortable-expanded']//div[@class='widgetName'][contains(text(),'Services')]");
        public By firstRow = By.xpath("//tr[1]//td[1]//div[1]");
        public By rows = By.xpath("//body/div/div/section/section/div/div/div/div/div/div/div/ul/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr");
        public By columns = By.xpath("/html[1]/body[1]/div[1]/div[2]/section[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/*");
        public By serviceNameSortBtn = By.xpath("//span[contains(text(),'Service Name')]");
        public By searchTextfield = By.xpath("//input[@placeholder='Search']");
    }
}
