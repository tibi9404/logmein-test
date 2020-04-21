package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleFormDemo {

    public WebElement getInputFieldA(WebDriver driver) {
        return driver.findElement(By.id("sum1"));
    }

    public WebElement getInputFieldB(WebDriver driver) {
        return driver.findElement(By.id("sum2"));
    }

    public WebElement getGetTotalButton(WebDriver driver) {
        return driver.findElement(By.cssSelector("#gettotal > button"));
    }

    public WebElement getResult(WebDriver driver) {
        return driver.findElement(By.id("displayvalue"));
    }
}
