package seleniumjunitwebshop.productpages.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPagesVerifyTheProductPageContainsTest {
	WebDriver driver = new FirefoxDriver();
	
	@FindBy(xpath ="//*[@class='buynow']")
	WebElement buyNow;
	
	@FindBy(xpath = "//*[@class='prodtitle']")
	WebElement productTitle;
	
	@FindBy(xpath = "//*[@class='product_description']/p")
	WebElement productDescription;
	
	@FindBy(xpath = "//*[@class='currentprice pricedisplay product_price_40']")
	WebElement productPrice;
	
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
	public void verifyProductPageContainsTitleTest() {
		buyNow.click();
		
		boolean titleExists = false;
		
		if(productTitle != null && productTitle.getText().length() > 0) {
			titleExists = true;
		}
		
		assertTrue("Unexpected title on productpage", titleExists);
	}
	
	@Test
	public void verifyProductPageContainsDescriptionTest() {
		buyNow.click();
		
		boolean descriptionExists = false;
		
		if(productDescription != null && productDescription.getText().length() > 0) {
			descriptionExists = true;
		}
		
		assertTrue("Unexpected description on productpage", descriptionExists);
	}
	
	@Test
	public void verifyProductPageContainsPriceTest() {
		buyNow.click();
		
		boolean priceExists = false;
		
		if(productPrice != null && productPrice.getText().length() > 0) {
			priceExists = true;
		}
		
		assertTrue("Unexpected price on productpage", priceExists);
	}
}
