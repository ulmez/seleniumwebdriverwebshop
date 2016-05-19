package seleniumjunitwebshop.checkoutyourcart.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	
	@FindBy(xpath ="//*[@class='slide1']/table/tbody/tr/td/a")
	List<WebElement> productNamesInBasketArea;
	
	@FindBy(xpath ="//*[@name='quantity']")
	List<WebElement> quantityOfProductsInBasketArea;
	
	@FindBy(xpath ="//*[@class='search']")
	WebElement searchProductField;
	
	@FindBy(xpath ="/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[6]/form/input[4]")
	WebElement removeProductButton;
	
	@FindBy(xpath ="//*[@class='pricedisplay']")
	WebElement priceDisplay;
	
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
	
	// 6. a) *******************************
	/*@Test
	public void verifyEmptyBasketTest() {
		// i.
		checkoutBasketButton.click();
		
		assertEquals("Unexpected message for empty cart", "Oops, there is nothing in your cart.", basketMessage.getText());
		
		// ii.
		assertFalse("Unexpected cart area", isWebElementPresent(By.xpath("//*[@class='slide1']")));
	}*/
	// *************************************
	
	// 6.) *********************************
	@Test
	public void verifyTheProductsPutInTheCartTest() throws InterruptedException {
		// b
		List<String> productNames = new ArrayList<>();
		productNames.add("iPhone 5");
		productNames.add("iPhone 5");
		productNames.add("Apple 27 inch Thunderbolt Display");
		productNames.add("Sennheiser RS 120");
		productNames.add("Sennheiser RS 120");
		productNames.add("Sennheiser RS 120");
		productNames.add("Sennheiser RS 120");
		
		Map<String, Integer> productNamesAndQuantity = new HashMap<>();
		productNamesAndQuantity.put("iPhone 5", 2);
		productNamesAndQuantity.put("Apple 27 inch Thunderbolt Display", 1);
		productNamesAndQuantity.put("Sennheiser RS 120", 4);
		
		for(String productName: productNames) {
			searchProductField.sendKeys(productName);
			searchProductField.sendKeys(Keys.ENTER);
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='wpsc_buy_button']")));
			wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			
			addToCartButton.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='go_to_checkout']")));
			wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			
			goToCheckoutButton.click();
		}
		
		List<Integer> quantityOfProductsInBasketAreaEdited = new ArrayList<>();
		
		for(WebElement element: quantityOfProductsInBasketArea) {
			if(Integer.parseInt(element.getAttribute("value")) != 0) {
				quantityOfProductsInBasketAreaEdited.add(Integer.parseInt(element.getAttribute("value")));
			}
		}
		
		Map<String, Integer> productNamesAndQuantityEdited = new HashMap<>();
		
		for(int i = 0; i < productNamesInBasketArea.size(); i++) {
			productNamesAndQuantityEdited.put(productNamesInBasketArea.get(i).getText(), quantityOfProductsInBasketAreaEdited.get(i));
		}
		
		assertEquals("Unexpected list of products and quantity in cart area", productNamesAndQuantity, productNamesAndQuantityEdited);
		
		// c
		removeProductButton.click();
		
		String priceDisplayFirst = priceDisplay.getText().substring(0, priceDisplay.getText().length() - 1);
		
		assertFalse("Unexpected removing of product in cart", productNamesInBasketArea.contains("iPhone 5"));
		
		// d
		//System.out.println(quantityOfProductsInBasketArea.get(0).getAttribute("value"));
		quantityOfProductsInBasketArea.get(0).clear();
		quantityOfProductsInBasketArea.get(0).sendKeys("3");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[3]/form/input[4]")).click();
		//quantityOfProductsInBasketArea.get(1).click();
		String priceDisplaySecond = priceDisplay.getText().substring(0, priceDisplay.getText().length() - 1);
		
		System.out.println(priceDisplayFirst);
		System.out.println(priceDisplaySecond);
	}
	// *************************************
	
	private boolean isWebElementPresent(By by) {
	    try {
	        driver.findElement(by);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
}
