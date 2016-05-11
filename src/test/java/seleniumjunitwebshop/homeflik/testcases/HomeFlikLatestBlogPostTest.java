package seleniumjunitwebshop.homeflik.testcases;

import static org.junit.Assert.assertEquals;
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

public class HomeFlikLatestBlogPostTest {
	WebDriver driver = new FirefoxDriver();
	
	@FindBy(xpath ="//*[@class='footer_featured']/ul/li")
	List<WebElement> latestBlogPost;
	
	@FindBy(xpath ="//*[@class='prodtitle']")
	WebElement productTitle;
	
	@FindBy(xpath ="//*[@class='footer_featured']/ul/li/a/img")
	List<WebElement> latestBlogPostImages;
	
	@FindBy(xpath ="//*[@title='More Details']")
	List<WebElement> latestBlogPostMoreDetails;
	
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
		assertEquals("Unexpected amount of Latest Blog Post products", 4, latestBlogPost.size());
	}
	
	@Test
	public void verifyLatestBlogPostSectionLeadToProductPageTest() {
		String productName = latestBlogPost.get(2).getText().substring(0, latestBlogPost.get(2).getText().indexOf("\n")).trim();
		
		if(productName.indexOf(".") != -1) {
			String productNameTemp = productName.substring(0, productName.indexOf("."));
			productName = productNameTemp;
		}
		
		latestBlogPost.get(2).click();
		
		assertEquals("Unexpected product on the product page from the Latest Blog Post section", productName, productTitle.getText().substring(0, productName.length()));
	}
	
	@Test
	public void verifyLatestBlogPostSectionImageLeadToProductPageTest() {
		String productName = latestBlogPostImages.get(2).getAttribute("title").replace("–", "-").trim();
		
		latestBlogPostImages.get(2).click();
		
		assertEquals("Unexpected product on the product page from the Latest Blog Post image click", productName, productTitle.getText().replace("–", "-").trim());
	}
	
	@Test
	public void verifyLatestBlogPostMoreDetailsLinkLeadToProductPageTest() {
		String moreDetailsUrlClicked = latestBlogPostMoreDetails.get(2).getAttribute("href");
		
		latestBlogPostMoreDetails.get(2).click();
		
		String productPageUrl = driver.getCurrentUrl();
		
		assertEquals("Unexpected product on the product page from the Latest Blog Post More Details click", moreDetailsUrlClicked, productPageUrl);
	}
}