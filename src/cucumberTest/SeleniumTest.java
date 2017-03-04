package cucumberTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
private static String pathToChromeDriver = "/Users/gibea/Downloads/chromedriver_win32";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", pathToChromeDriver+"/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = (new WebDriverWait(driver, 10));
		 
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Online Store Website
 
        driver.get("https://www.ssense.com/en-ca/men");
 
        // Find the element that's ID attribute is 'account'(My Account) 
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
        
        //go to men's section and click on Vetements brand
        driver.findElement(By.xpath("//a[@id='linkMen']")).click();
        driver.findElement(By.partialLinkText("Vetements")).click();
        
        //find an item, Black champion edition archive hoodie
        wait.until(ExpectedConditions.titleContains("Vetements"));
        driver.findElement(By.partialLinkText("Black Champion Edition Archive Hoodie")).click();
        //remember the item
        wait.until(ExpectedConditions.titleContains("Black Champion Edition"));
        
        String productSKU = driver.findElement(By.className("product-description-container")).getAttribute("data-product-sku");
        System.out.println(productSKU);
        WebElement productDescription = driver.findElement(By.className("product-description-container"));
        System.out.println(productDescription.getAttribute("data-product-name"));
        Select sizeSelect = new Select(driver.findElement(By.xpath("//form[@id='addBagForm']/div[@class='row-fluid']/div[@class='span16']/select[@id='size']")));
        sizeSelect.selectByVisibleText("M");
        WebElement addToCart = driver.findElement(By.xpath("//button[@class='btn-add-to-bag button button-primary full-width']"));
        addToCart.click();
        //WebElement checkout = driver.findElement(By.className("button full-width"));
        //checkout.click();
        
        //go to shopping bag
        WebElement shoppingBag = driver.findElement(By.className("navShoppingBag"));
        shoppingBag.click();
        wait.until(ExpectedConditions.titleContains("Shopping Bag"));
        
        try{
        	driver.findElement(By.id("checkout_logged"));
        }catch (Exception e){
        	throw e;
        }
        
        List<WebElement> shoppingItems = driver.findElements(By.xpath("//div[@class='row-fluid row-table shopping-item']"));
    	Predicate<WebElement> byAttribute = webelement -> webelement.getAttribute("data-product-sku").equals(productSKU);
    	
    	List<WebElement> results = shoppingItems.stream().filter(byAttribute).collect(Collectors.<WebElement> toList());
    	System.out.println("Found " + shoppingItems.size() + " items!");
    	System.out.println("Found thru filter: " + results.size() + " items!");
        
    	WebElement linkToProduct = results.get(0).findElement(By.xpath(".//div[@class='span3 text-center']/a/img"));
    	linkToProduct.click();
        
        //driver.quit();
	}

}
