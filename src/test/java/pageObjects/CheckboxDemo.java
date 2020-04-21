package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxDemo {

    public WebElement getCheckBox(WebDriver driver) {
        return driver.findElement(By.id("isAgeSelected"));
    }

    public WebElement getCheckBoxResultMessage(WebDriver driver) {
        return driver.findElement(By.id("txtAge"));
    }

}
