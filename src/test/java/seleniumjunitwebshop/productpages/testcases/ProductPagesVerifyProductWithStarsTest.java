package seleniumjunitwebshop.productpages.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

public class ProductPagesVerifyProductWithStarsTest {
	WebDriver driver = new FirefoxDriver();
	
	@FindBy(xpath ="//*[@class='buynow']")
	WebElement buyNow;
	
	@FindBy(xpath ="//*[@title='5']")
	WebElement starRatingClick;
	
	@FindBy(xpath ="//*[@class='message']")
	WebElement ratedYesOrNoMessage;
	
	@FindBy(xpath ="//*[@class='star-rating-control']/div")
	List<WebElement> stars;
	
	@FindBy(xpath ="//*[@class='wpec-star-rating rater-0 star star-rating-applied star-rating-live star-rating-on']")
	List<WebElement> numberOfStars;
	
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
	
	// 2. c) *****************************
	@Test
	public void verifyProductRatedOnlyOnceTest() {
		// i.
		buyNow.click();
		starRatingClick.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='message']")));
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		
		String ratedMessage1 = ratedYesOrNoMessage.getText();
		
		driver.navigate().refresh();
		
		starRatingClick.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='message']")));
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		
		String ratedMessage2 = ratedYesOrNoMessage.getText();
		
		boolean ratingMessageEvaluatedOnlyOnce = false;
		
		if(ratedMessage1.equals("Thanks for rating!") && ratedMessage2.equals("Thanks for rating!")) {
			ratingMessageEvaluatedOnlyOnce = false;
		} else {
			ratingMessageEvaluatedOnlyOnce = true;
		}
		
		assertTrue("Unexpected rating message", ratingMessageEvaluatedOnlyOnce);
	}
	
	@Test
	public void verifyGradeOneTwoFiveTest() {
		// ii.
		buyNow.click();
		
		boolean verifyClickOnAllFiveStars = false;
		
		for(int i = 1; i < stars.size(); i++) {
			stars.get(i).click();
			
			if(Integer.parseInt(stars.get(i).getText()) == numberOfStars.size()) {
				verifyClickOnAllFiveStars = true;
			} else {
				verifyClickOnAllFiveStars = false;
				break;
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='message']")));
			wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			
			driver.navigate().refresh();
		}
		
		assertTrue("Unexpected response when clicking star", verifyClickOnAllFiveStars);
	}
	
	@Test
	public void verifyNotPossibleToGradeAlreadyGradedProductTest() {
		// iii.
		buyNow.click();
		starRatingClick.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='message']")));
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		
		String rateMessage = ratedYesOrNoMessage.getText();
		
		assertEquals("Unexpected response when clicking already rated product star", "Sorry, you already rated!", rateMessage);
	}
	// ***********************************
}
