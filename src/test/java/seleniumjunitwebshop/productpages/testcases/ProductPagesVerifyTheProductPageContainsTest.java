package seleniumjunitwebshop.productpages.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	
	/*@Test
	public void verifyProductPageContainsTitleTest() {
		buyNow.click();
		
		System.out.println(productTitle.getText());
		
		boolean titleExists = false;
		
		if(productTitle != null && productTitle.getText().length() > 0) {
			titleExists = true;
		}
		
		assertTrue("Unexpected title on productpage", titleExists);
	}*/
	
	@Test
	public void verifyProductPageContainsDescriptionTest() {
		buyNow.click();
		
		System.out.println(productDescription.getText());
		
		boolean descriptionExists = false;
		
		if(productDescription != null && productDescription.getText().length() > 0) {
			descriptionExists = true;
		}
		
		assertTrue("Unexpected description on productpage", descriptionExists);
	}
}
