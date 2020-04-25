package utils;

import org.openqa.selenium.By;

public class Locators {

    /***************************** Home Page ****************************************/

    public static class HomePageLocators {
        public By appName = By.id("appName");
        public By email = By.id("username");
        public By password = By.id("password");
        public By signInBtn = By.xpath("//div[contains(text(),'Sign in')]");
    }

    /**************************** Dashboard Page - Appointments Services *********************************/

    public static class DashboardPageLocators {
        public By dashboardTitle = By.xpath("//span[contains(text(),'CMS DEMO ACCOUNT')]");
        public By appointmentsBtn = By.xpath("//div[contains(text(),'Appointments')]");
        public By servicesBtn = By.xpath("//li[@class='app-item-view submenuItem green mjs-nestedSortable-branch mjs-nestedSortable-expanded']//div[@class='widgetName'][contains(text(),'Services')]");
        public By firstRow = By.xpath("//tr[1]//td[1]//div[1]");
        public By rows = By.xpath("//body/div/div/section/section/div/div/div/div/div/div/div/ul/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr");
        public By columns = By.xpath("/html[1]/body[1]/div[1]/div[2]/section[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/*");
        public By serviceNameSortBtn = By.xpath("//span[contains(text(),'Service Name')]");
        public By searchTextfield = By.xpath("//input[@placeholder='Search']");
    }
}
