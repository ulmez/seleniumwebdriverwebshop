package seleniumjunitwebshop.homeflik.testcases;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFlikProductTest {
	WebDriver driver = new FirefoxDriver();
	
	@FindBy(xpath = "//*[@value='Search Products']")
	WebElement searchProducts;
	
	@FindBy(xpath ="//*[@class='buynow']")
	WebElement buyNow;
	
	@FindBy(xpath ="//*[@class='featured_image']/a")
	WebElement magicMouse;
	
	@FindBy(xpath ="//*[@href='http://store.demoqa.com/']")
	WebElement home;
	
	@FindBy(xpath ="//*[@title='More Info']")
	WebElement moreInfo;
	
	@FindBy(xpath ="//*[@class='product_description']/h2")
	List<WebElement> slides;
	
	@FindBy(xpath ="//*[@id='slide_menu']/a")
	List<WebElement> selectedSlides;
	
	@FindBy(xpath ="//*[@class='footer_featured']/ul/li")
	List<WebElement> latestBlogPost;
	
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
	public void verifyBuyNowButtonAndIPodNanoBlueImageTest() {
		buyNow.click();
		assertEquals("Unexpected product page from Buy Now button", "Magic Mouse | ONLINE STORE", driver.getTitle());
	}
	
	@Test
	public void verifyMAgicMouseImageTest() {
		magicMouse.click();
		assertEquals("Unexpected product page from Magic Mouse image link", "Magic Mouse | ONLINE STORE", driver.getTitle());
	}
	
	@Test
	public void verifyMoreInfoLinkTest() {
		moreInfo.click();
		assertEquals("Unexpected product page from More Info link", "Magic Mouse | ONLINE STORE", driver.getTitle());
	}
	
	@Test
	public void verifyAllThreeProductsFromCarousel() {
		List<String> productNames = new ArrayList<>();
		productNames.add("Magic Mouse");
		productNames.add("iPhone 5");
		productNames.add("iPod Nano Blue");
		
		boolean allProductsExistInCarousel = false;
		
		for(int i = 0; i < 5; i++) {
			if(productNames.contains(slides.get(0).getText())) {
				allProductsExistInCarousel = true;
			} else {
				allProductsExistInCarousel = false;
				break;
			}
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		assertTrue("Unexpected product in carousel", allProductsExistInCarousel);
	}
	
	@Test
	public void verifyManualClickOnChoiseInCarousel() {
		List<String> productNames = new ArrayList<>();
		for(int i = slides.size()-1; i >= 0; i--) {
			((WebElement) selectedSlides.get(i)).click();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			productNames.add(slides.get(0).getText());
		}
		
		assertEquals("Unexpected product amount from carousel", 3, productNames.size());
	}
}