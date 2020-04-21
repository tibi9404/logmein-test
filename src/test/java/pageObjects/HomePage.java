package pageObjects;

import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

    public void loadHomaPage(WebDriver driver) {
        driver.get("https://www.seleniumeasy.com/test/");
    }

    public WebElement getPageTitle(WebDriver driver) {
        return driver.findElement(By.id("name-and-slogan"));
    }

    public WebElement getInputFormsDropdown(WebDriver driver) {
        return driver.findElement(By.cssSelector("#navbar-brand-centered > ul:nth-child(1) > li:nth-child(1)"));
    }

    public WebElement getSimpleFormDemoItem(WebDriver driver) {
        return driver.findElement(By.cssSelector("#navbar-brand-centered > ul:nth-child(1) > li.dropdown.open > ul > li:nth-child(1)"));
    }

}
