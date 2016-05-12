package seleniumjunitwebshop.productcategoryflik.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryFlikVerifyAllProductCategoriesTest {
	WebDriver driver = new FirefoxDriver();
	
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
	public void verifyAllCategoriesAndThatEachCategoryLeadsToThatCategoryTest() throws InterruptedException {
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"))).build().perform();
		driver.findElement(By.id("menu-item-34")).click();
		assertEquals("Unexpected category calue", "Accessories", driver.findElement(By.xpath("//*[@class='entry-title']")).getText());
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"))).build().perform();
		driver.findElement(By.id("menu-item-35")).click();
		assertEquals("Unexpected category calue", "iMacs", driver.findElement(By.xpath("//*[@class='entry-title']")).getText());
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"))).build().perform();
		driver.findElement(By.id("menu-item-36")).click();
		assertEquals("Unexpected category calue", "iPads", driver.findElement(By.xpath("//*[@class='entry-title']")).getText());
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"))).build().perform();
		driver.findElement(By.id("menu-item-37")).click();
		assertEquals("Unexpected category calue", "iPhones", driver.findElement(By.xpath("//*[@class='entry-title']")).getText());
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"))).build().perform();
		driver.findElement(By.id("menu-item-38")).click();
		assertEquals("Unexpected category calue", "iPods", driver.findElement(By.xpath("//*[@class='entry-title']")).getText());
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElement(By.xpath("//*[@href='http://store.demoqa.com/products-page/product-category/']"))).build().perform();
		driver.findElement(By.id("menu-item-39")).click();
		assertEquals("Unexpected category calue", "MacBooks", driver.findElement(By.xpath("//*[@class='entry-title']")).getText());
	}
}
