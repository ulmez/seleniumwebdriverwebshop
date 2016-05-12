package seleniumjunitwebshop.addtocart.testcases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartTest {
	WebDriver driver = new FirefoxDriver();
	
	@FindBy(xpath ="//*[@class='buynow']")
	WebElement buyNowButton;
	
	@FindBy(xpath ="//*[@class='wpsc_buy_button']")
	WebElement addToCartButton;
	
	@FindBy(xpath ="//*[@class='product_description']/h2")
	WebElement firstPageProductTitle;
	
	@FindBy(xpath ="//*[@id='fancy_notification_content']/span")
	WebElement notificationContent;
	
	@FindBy(xpath ="//*[@class='go_to_checkout']")
	WebElement checkOutButton;
	
	@FindBy(xpath ="//*[@class='entry-title']")
	WebElement checkoutTitle;
	
	@FindBy(xpath ="//*[@class='step2']")
	WebElement continueShoppingButton;
	
	@FindBy(xpath ="//*[@id='wpsc_shopping_cart_container']/h2")
	WebElement continueShoppingVerification;
	
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
		driver.close();
	}
	
	@AfterClass
	public static void getAfterClass() {
		
	}
	
	@Test
	public void verifyLatestBlogPostSectionShowProductsTest() {
		String firstPageProductTitleTemp = firstPageProductTitle.getText();
		
		buyNowButton.click();
		addToCartButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='fancy_notification_content']/span")));
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		
		String notificationTemp = notificationContent.getText();
		
		List<Integer> positionsOfCharacterInString = new ArrayList<>();
		
		for(int i = 0; i < notificationTemp.length(); i++) {
			if(notificationTemp.charAt(i) == '"') {
				positionsOfCharacterInString.add(i);
			}
		}
		
		notificationTemp = notificationTemp.substring(positionsOfCharacterInString.get(0) + 1, positionsOfCharacterInString.get(1));
		
		assertEquals("Unexpected title of Add To Cart ordering", firstPageProductTitleTemp, notificationTemp);
		
		checkOutButton.click();
		
		assertEquals("Unexpected title of Add To Cart ordering", "Checkout", checkoutTitle.getText());
		
		continueShoppingButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wpsc_shopping_cart_container']/h2")));
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		
		assertEquals("Unexpected title of Add To Cart ordering", "Calculate Shipping Price", continueShoppingVerification.getText());
	}
}
