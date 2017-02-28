package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class Test_Steps {
	WebDriver driver;
	String pathToChromeDriver = "/Users/thomas/Projects/eclipse/cucumber and selenium";
	@Given("^User is on Home Page and logged in$")
    public void user_is_on_home_page_and_logged_in() throws Throwable {
		System.setProperty("webdriver.chrome.driver", pathToChromeDriver+"/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.ssense.com/en-ca/men");
        
        WebElement loginButton = driver.findElement(By.xpath("//span[text()='login']"));
        loginButton.click();
        WebElement emailField = driver.findElement(By.xpath("//div[@class='login-section span5 offset2 no-padding tablet-landscape-full-fluid-width']/form[@class='login']/div[@class='row-fluid']/div[@class='span16']/input[1]"));
        emailField.click();
        emailField.sendKeys("oo.thomas96@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='login-section span5 offset2 no-padding tablet-landscape-full-fluid-width']/form[@class='login']/div[@class='row-fluid']/div[@class='span16']/input[2]"));
        passwordField.click();
        passwordField.sendKeys("testtest123");

        WebElement submitLogin = driver.findElement(By.xpath("//button[@id='submitLogin']"));
        submitLogin.click();
    }

    @When("^User Navigates to product page$")
    public void user_navigates_to_product_page() throws Throwable {
    	driver.findElement(By.xpath("//a[@id='linkMen']")).click();
    }

    @Then("^User sees item in bag$")
    public void user_sees_item_in_bag() throws Throwable {
        throw new PendingException();
    }

    @And("^User selects a product$")
    public void user_selects_a_product() throws Throwable {
    	driver.findElement(By.xpath("//div[@class='browsing-side-navigation text-left']/div[@class='section'][2]/ul[@class='nav nav--stacked']/li[201]/a")).click();
    	driver.findElement(By.xpath("//div[@class='browsing-product-item'][10]/a/div[@class='browsing-product-description text-center vspace1']/p[@class='hidden-smartphone-landscape']")).click();
    	//remember the product
    	driver.findElement(By.className("product-description-container"));
    }

    @And("^User selects a size$")
    public void user_selects_a_size() throws Throwable {
    	Select sizeSelect = new Select(driver.findElement(By.xpath("//form[@id='addBagForm']/div[@class='row-fluid']/div[@class='span16']/select[@id='size']")));
        sizeSelect.selectByVisibleText("M");
    }

    @And("^User clicks add to bag$")
    public void user_clicks_add_to_bag() throws Throwable {
    	WebElement addToBag = driver.findElement(By.xpath("//button[@class='btn-add-to-bag button button-primary full-width']"));
        addToBag.click();
    }

    @And("^User goes to shopping bag$")
    public void user_goes_to_shopping_bag() throws Throwable {
        throw new PendingException();
    }

    @And("^User sees checkout button$")
    public void user_sees_checkout_button() throws Throwable {
        throw new PendingException();
    }
}
