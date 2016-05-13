package seleniumjunitwebshop.checkoutyourcart.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutYourCartTest {
	WebDriver driver = new FirefoxDriver();
	
	@FindBy(xpath ="//*[@class='buynow']")
	WebElement buyNowButton;
	
	@FindBy(xpath ="//*[@class='wpsc_buy_button']")
	WebElement addToCartButton;
	
	@FindBy(xpath ="//*[@class='go_to_checkout']")
	WebElement goToCheckoutButton;
	
	@FindBy(xpath ="//*[@class='icon']")
	WebElement checkoutBasketButton;
	
	@FindBy(xpath ="//*[@class='entry-content']")
	WebElement basketMessage;
	
	@FindBy(xpath ="//*[@class='slide1']")
	WebElement basketArea;
	
	@BeforeClass
	public static void getBeforeClass() {
		//driver.get("http://store.demoqa.com/");
	}
	
	@Before
	public void getBefore() {
		driver.get("http://store.demoqa.com/");
		PageFactory.initElements(driver, this);
	}
	
	@After
	public void getAfter() {
		//driver.close();
	}
	
	@AfterClass
	public static void getAfterClass() {
		
	}
	
	@Test
	public void verifyEmptyBasketTest() {
		checkoutBasketButton.click();
		
		assertEquals("Unexpected message for empty cart", "Oops, there is nothing in your cart.", basketMessage.getText());
		assertFalse("Unexpected cart area", isWebElementPresent(By.xpath("//*[@class='slide1']")));
	}
	
	public boolean isWebElementPresent(By by) {
	    try {
	        driver.findElement(by);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
}
