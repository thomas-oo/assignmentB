package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
private static String pathToChromeDriver = "/Users/thomas/Projects/eclipse/cucumber and selenium";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", pathToChromeDriver+"/chromedriver");
		WebDriver driver = new ChromeDriver();
		 
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Online Store Website
 
        driver.get("https://www.ssense.com/en-ca/men");
 
        // Find the element that's ID attribute is 'account'(My Account) 
 
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
        
        //go to men's section and click on Vetements brand
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        WebElement mensSection = null;
        while(!wait.until(ExpectedConditions.titleContains("Account Details"))){
        	mensSection = driver.findElement(By.xpath("//a[@id='linkMen']"));
        }
        mensSection.click();
        driver.findElement(By.xpath("//div[@class='browsing-side-navigation text-left']/div[@class='section'][2]/ul[@class='nav nav--stacked']/li[201]/a")).click();
        
        //find an item, Black champion edition archive hoodie
        driver.findElement(By.xpath("//div[@class='browsing-product-item'][10]/a/div[@class='browsing-product-description text-center vspace1']/p[@class='hidden-smartphone-landscape']")).click();
        //remember the item
        WebElement productDescription = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("product-description-container")));
        Select sizeSelect = new Select(driver.findElement(By.xpath("//form[@id='addBagForm']/div[@class='row-fluid']/div[@class='span16']/select[@id='size']")));
        sizeSelect.selectByVisibleText("M");
        WebElement addToCart = driver.findElement(By.xpath("//button[@class='btn-add-to-bag button button-primary full-width']"));
        addToCart.click();
        WebElement checkout = driver.findElement(By.xpath("//a[@class='button full-width']"));
        checkout.click();
        
        
        
        
        driver.quit();
	}

}
