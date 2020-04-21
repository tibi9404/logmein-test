package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AjaxFormSubmit {

    public WebElement getNameInputField(WebDriver driver) {
        return driver.findElement(By.id("title"));
    }

    public WebElement getCommentInputField(WebDriver driver) {
        return driver.findElement(By.id("description"));
    }

    public WebElement getSubmitButton(WebDriver driver) {
        return driver.findElement(By.id("btn-submit"));
    }

    public WebElement getSubmitResultSuccessfulMessage(WebDriver driver) {
        return driver.findElement(By.id("submit-control"));
    }

}
