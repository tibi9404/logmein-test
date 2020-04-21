package stepDef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.SimpleFormDemo;

public class BasicTests {

    private static WebDriver driver;
    private HomePage homePage;
    private SimpleFormDemo simpleFormDemo;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage();
        simpleFormDemo = new SimpleFormDemo();
    }

    @After
    public void teatDown(){
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

    @When("^I choose 'Simple Form Demo' item$")
    public void iChooseSimpleFormDemoItem() {
        homePage.getSimpleFormDemoItem(driver).click();
    }

    @When("^I enter 5 in the 'a' input field$")
    public void iEnter5InTheAInputField() {
        simpleFormDemo.getInputFieldA(driver).sendKeys("5");
    }

    @When("^I enter 6 in the 'b' input field$")
    public void iEnter6InTheBInputField() {
        simpleFormDemo.getInputFieldB(driver).sendKeys("6");
    }

    @When("^I click on the 'Get total' button$")
    public void iClickOnTheGetTotalButton() {
        simpleFormDemo.getGetTotalButton(driver).click();
    }

    @Then("^It should contain the string '(.*)'$")
    public void itShouldContainTheString(String expectedValue) {
        Assert.assertTrue(homePage.getPageTitle(driver).getText().contains(expectedValue));
    }

    @Then("^the result should be '(.*)'$")
    public void theResultShouldBe(String expectedValue) {
        Assert.assertEquals(expectedValue, simpleFormDemo.getResult(driver).getText());
    }

}
