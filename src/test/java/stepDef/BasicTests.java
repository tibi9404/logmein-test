package stepDef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AjaxFormSubmit;
import pageObjects.CheckboxDemo;
import pageObjects.HomePage;
import pageObjects.SimpleFormDemo;

public class BasicTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private SimpleFormDemo simpleFormDemo;
    private CheckboxDemo checkboxDemo;
    private AjaxFormSubmit ajaxFormSubmit;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait  = new WebDriverWait(driver,5);
        homePage = new HomePage();
        simpleFormDemo = new SimpleFormDemo();
        checkboxDemo = new CheckboxDemo();
        ajaxFormSubmit = new AjaxFormSubmit();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Given("^I am on the homepage of seleniumeasy$")
    public void iAmOnTheHomepageOfSeleniumeasy() {
        homePage.loadHomaPage(driver);
    }

    @When("^I investigate the page title$")
    public void iInvestigateThePageTitle() {
    }

    @When("^I open the 'Input Forms' dropdown in the menu$")
    public void iOpenTheInputFormsDropDownInTheMenu() {
        homePage.getInputFormsDropdown(driver).click();
    }

    @When("^I choose '(.*)' item$")
    public void iChooseSimpleFormDemoItem(String menuItem) {
        switch (menuItem) {

            case "Simple Form Demo":
                homePage.getSimpleFormDemoItem(driver).click();
                break;

            case "Checkbox Demo":
                homePage.getCheckboxDemoItem(driver).click();
                break;

            case "Ajax Form Submit":
                homePage.getAjaxFormSubmitItem(driver).click();
                break;
        }

    }

    @When("^I enter (.*) in the 'a' input field$")
    public void iEnter5InTheAInputField(String value) {
        simpleFormDemo.getInputFieldA(driver).sendKeys(value);
    }

    @When("^I enter (.*) in the 'b' input field$")
    public void iEnter6InTheBInputField(String value) {
        simpleFormDemo.getInputFieldB(driver).sendKeys(value);
    }

    @When("^I click on the 'Get total' button$")
    public void iClickOnTheGetTotalButton() {
        simpleFormDemo.getGetTotalButton(driver).click();
    }

    @When("^I tick the single checkbox$")
    public void iTickTheSingleCheckbox() {
        checkboxDemo.getCheckBox(driver).click();
    }

    @When("^I attempt to submit the form$")
    public void iAttemptToSubmitTheForm() {
        ajaxFormSubmit.getSubmitButton(driver).click();
    }

    @When("^I fill the '(.*)' input field$")
    public void iFillTheInputField(String param) {
        if ("Name".equals(param)) {
            ajaxFormSubmit.getNameInputField(driver).sendKeys("Name value");
        } else {
            ajaxFormSubmit.getCommentInputField(driver).sendKeys("Comment value");
        }
    }

    @Then("^It should contain the string '(.*)'$")
    public void itShouldContainTheString(String expectedValue) {
        Assert.assertTrue(homePage.getPageTitle(driver).getText().contains(expectedValue));
    }

    @Then("^the result should be '(.*)'$")
    public void theResultShouldBe(String expectedValue) {
        Assert.assertEquals(expectedValue, simpleFormDemo.getResult(driver).getText());
    }

    @Then("^the successful result message is appeared$")
    public void theSuccessfulResultMessageIsAppeared() {
        Assert.assertEquals("Success - Check box is checked", checkboxDemo.getCheckBoxResultMessage(driver).getText());
    }

    @Then("^the form (.*) submitted$")
    public void theFormSubmitted(String action) {
        if (action.equals("is")) {
            wait.until(ExpectedConditions.textToBePresentInElement(ajaxFormSubmit.getSubmitResultSuccessfulMessage(driver), "Form submited Successfully!"));
        } else {
            Assert.assertTrue(ajaxFormSubmit.getSubmitButton(driver).isDisplayed());
            Assert.assertEquals("border: 1px solid rgb(255, 0, 0);", ajaxFormSubmit.getNameInputField(driver).getAttribute("style"));
        }
    }

}
