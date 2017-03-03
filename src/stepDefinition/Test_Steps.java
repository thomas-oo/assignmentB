package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class Test_Steps {
	WebDriver driver;
	WebDriverWait wait;
	String pathToChromeDriver = "/Users/thomas/Projects/eclipse/cucumber and selenium";
	
	String productSKU;
	int numberOfProductsInBag;
	
	@Given("^User is on Home Page and logged in$")
    public void user_is_on_home_page_and_logged_in() throws Throwable {
		System.setProperty("webdriver.chrome.driver", pathToChromeDriver+"/chromedriver");
		driver = new ChromeDriver();
		wait = (new WebDriverWait(driver, 10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.ssense.com/en-ca/men");
        
        WebElement loginButton = driver.findElement(By.id("loggedOptions"));
        loginButton.click();
        WebElement emailField = driver.findElement(By.xpath("//div[@class='login-section span5 offset2 no-padding tablet-landscape-full-fluid-width']/form[@class='login']/div[@class='row-fluid']/div[@class='span16']/input[1]"));
        emailField.click();
        emailField.sendKeys("oo.thomas96@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='login-section span5 offset2 no-padding tablet-landscape-full-fluid-width']/form[@class='login']/div[@class='row-fluid']/div[@class='span16']/input[2]"));
        passwordField.click();
        passwordField.sendKeys("testtest123");

        WebElement submitLogin = driver.findElement(By.xpath("//button[@id='submitLogin']"));
        submitLogin.click();
        wait.until(ExpectedConditions.titleContains("Account Details"));
    }

    @When("^User Navigates to product page$")
    public void user_navigates_to_product_page() throws Throwable {
    	driver.findElement(By.xpath("//a[@id='linkMen']")).click();
    	wait.until(ExpectedConditions.titleContains("for Men"));
    }

    @Then("^User sees item in bag$")
    public void user_sees_item_in_bag() throws Throwable {
    	List<WebElement> shoppingItems = driver.findElements(By.xpath("//div[@class='row-fluid row-table shopping-item']"));
    	Predicate<WebElement> byAttribute = webelement -> webelement.getAttribute("data-product-sku").equals(productSKU);
    	
    	List<WebElement> results = shoppingItems.stream().filter(byAttribute).collect(Collectors.<WebElement> toList());
    	if(results.isEmpty()){
    		throw new Exception("Item not found in cart!");
    	}else{
    		numberOfProductsInBag = results.size();
    		System.out.println("Found " + numberOfProductsInBag + " quantity of item SKU: " +productSKU);
    	}
    }

    @And("^User selects a product$")
    public void user_selects_a_product() throws Throwable {
    	driver.findElement(By.partialLinkText("Vetements")).click();
    	wait.until(ExpectedConditions.titleContains("Vetements"));
    	driver.findElement(By.partialLinkText("Black Champion Edition Archive Hoodie")).click();
    	wait.until(ExpectedConditions.titleContains("Black Champion Edition"));
    	productSKU = driver.findElement(By.className("product-description-container")).getAttribute("data-product-sku");
    	
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
    	WebElement shoppingBag = driver.findElement(By.className("navShoppingBag"));
        shoppingBag.click();
        wait.until(ExpectedConditions.titleContains("Shopping Bag"));
    }

    @And("^User sees checkout button$")
    public void user_sees_checkout_button() throws Throwable {
        try{
        	driver.findElement(By.id("checkout_logged"));
        }catch (Exception e){
        	throw e;
        }
        System.out.println("User sees checkout button successfully.");
    }
    
    //NEW STEPS FOR ALTERNATE FLOW BELOW
    
    //User has a product in mind (product name and brand) and finds it in the shopping bag. ie check for existance of such an item
    @When("^User finds the product they want another of$")
    public void user_finds_the_product_they_want_another_of() throws Throwable {
    	List<WebElement> shoppingItems = driver.findElements(By.xpath("//div[@class='row-fluid row-table shopping-item']"));
    	Predicate<WebElement> byAttribute = webelement -> webelement.getText().contains("Vetements") && webelement.getText().contains("Black Champion Edition Archive Hoodie");
    	
    	List<WebElement> results = shoppingItems.stream().filter(byAttribute).collect(Collectors.<WebElement> toList());
    	if(results.isEmpty()){
    		throw new Exception("Item not found in cart!");
    	}else{
    		numberOfProductsInBag = results.size();
    		System.out.println("Found " + numberOfProductsInBag + " quantity of item: " + "Black Champion Edition Archive Hoodie");
    	}
    }
    
    //User clicks on the first element of the item they want.
    @And("^User clicks on the product$")
    public void user_clicks_on_the_product() throws Throwable {
    	List<WebElement> shoppingItems = driver.findElements(By.xpath("//div[@class='row-fluid row-table shopping-item']"));
    	Predicate<WebElement> byAttribute = webelement -> webelement.getText().contains("Vetements") && webelement.getText().contains("Black Champion Edition Archive Hoodie");
    	List<WebElement> results = shoppingItems.stream().filter(byAttribute).collect(Collectors.<WebElement> toList());
    	WebElement linkToProduct = results.get(0).findElement(By.xpath(".//div[@class='span3 text-center']/a/img"));
    	linkToProduct.click();
    	wait.until(ExpectedConditions.titleContains("Black Champion Edition"));
    }
    
    //User should see an additional item in bag ie. the number of items before has to increase by 1.
    //TODO: small bug here where sometimes an additional item is not found in the cart. probably due to lag?
    @Then("^User sees an additional item in bag$")
    public void user_sees_an_additional_item_in_bag() throws Throwable {
    	List<WebElement> shoppingItems = driver.findElements(By.xpath("//div[@class='row-fluid row-table shopping-item']"));
    	Predicate<WebElement> byAttribute = webelement -> webelement.getText().contains("Vetements") && webelement.getText().contains("Black Champion Edition Archive Hoodie");
    	List<WebElement> results = shoppingItems.stream().filter(byAttribute).collect(Collectors.<WebElement> toList());
    	if(results.size() == numberOfProductsInBag + 1){
    		System.out.println("User finds an additional product in bag!");
    	}else{
    		throw new Exception("User did not found an additional product in bag!");
    	}
    }
    
    //NEW STEPS FOR ERROR FLOW BELOW
    
    @Given("^User is on Home Page and logged out$")
    public void user_is_on_home_page_and_logged_out() throws Throwable {
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver+"/chromedriver");
		driver = new ChromeDriver();
		wait = (new WebDriverWait(driver, 10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.ssense.com/en-ca/men");
        
        WebElement loginButton = driver.findElement(By.id("loggedOptions"));
        System.out.println(loginButton.getAttribute("class"));
        if(loginButton.getAttribute("class").contains("logged")){
        	//should never get here but just in case.
        	Actions actions = new Actions(driver);
        	actions.moveToElement(loginButton);
        	WebElement logoutButton = driver.findElement(By.className("btn-logout"));
        	logoutButton.click();
        	wait.until(ExpectedConditions.titleContains("for Men"));
        }
    }
    
    @But("^User does not see the checkout button$")
    public void user_does_not_see_the_checkout_button() throws Throwable {
    	WebElement checkout;
    	try{
        	checkout = driver.findElement(By.id("checkout_logged"));
        }catch (Exception e){
        	System.out.println("Checkout button not present as expected.");
        	return;
        }
    	if(checkout.isDisplayed()){
    		throw new Exception("Checkout button is present when it shouldn't be!");
    	}
    }
    
    @Then("^User is prompted to login or create an account$")
    public void user_is_prompted_to_login_or_create_an_account() throws Throwable {
        boolean loginButtonShown = driver.findElement(By.id("submitLogin")).isDisplayed();
        boolean createButtonShown = driver.findElement(By.id("submitRegister")).isDisplayed();
        if(loginButtonShown && createButtonShown){
        	return;
        }else{
        	throw new Exception("Not prompted to login or create an account!");
        }
    }
    
    @And("^User logs in thru the prompt$")
    public void user_logs_in_thru_the_prompt() throws Throwable {
        driver.findElement(By.name("email")).sendKeys("oo.thomas96@gmail.com");
        driver.findElement(By.name("password")).sendKeys("testtest123");
        driver.findElement(By.id("submitLogin")).click();
        wait.until(
        		ExpectedConditions.or(
        		ExpectedConditions.titleContains("Shopping Bag"),
        		ExpectedConditions.titleContains("Checkout")));
        if(driver.getTitle().contains("Checkout")){
        	driver.navigate().back();
        }
    }
    
    @And("^User sees the same item in cart$")
    public void user_sees_the_same_item_in_cart() throws Throwable {
    	List<WebElement> shoppingItems = driver.findElements(By.xpath("//div[@class='row-fluid row-table shopping-item']"));
    	Predicate<WebElement> byAttribute = webelement -> webelement.getAttribute("data-product-sku").equals(productSKU);
    	
    	List<WebElement> results = shoppingItems.stream().filter(byAttribute).collect(Collectors.<WebElement> toList());
    	if(results.isEmpty()){
    		throw new Exception("Item not found in cart!");
    	}else{
    		numberOfProductsInBag = results.size();
    		System.out.println("Found " + numberOfProductsInBag + " quantity of item SKU: " +productSKU);
    	}
    }
}
