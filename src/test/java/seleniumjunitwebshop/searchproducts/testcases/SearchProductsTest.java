package seleniumjunitwebshop.searchproducts.testcases;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductsTest {
	WebDriver driver = new FirefoxDriver();
	
	@FindBy(xpath ="//*[@class='search']")
	WebElement searchProduct;
	
	@FindBy(xpath ="//*[@class='prodtitle']/a")
	WebElement productTitle;
	
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
	public void verifySearchOfProductTest() {
		searchProduct.sendKeys("Apple 27 inch Thunderbolt Display");
		searchProduct.sendKeys(Keys.ENTER);
		
		assertEquals("Unexpected search result", "Apple 27 inch Thunderbolt Display", productTitle.getText().trim());
	}
}
