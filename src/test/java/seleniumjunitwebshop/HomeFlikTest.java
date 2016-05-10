package seleniumjunitwebshop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeFlikTest {
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
	
	List<String> temp = new ArrayList<>();
	
	// /html/body/div[2]/div/div/div/div/div/div/div[1]/div[3]/div/a/span
	
	/*@FindBy(id = "answer1")
	WebElement answer1Element;
	
	@FindBy(id = "answer4")
	WebElement answer4Element;
	
	@FindBy(id = "answer6")
	WebElement answer6Element;
	
	@FindBy(id = "answer8")
	WebElement answer8Element;
	
	@FindBy(id = "answer10")
	WebElement answer10Element;
	
	@FindBy(id = "answer11")
	WebElement answer11Element;
	
	@FindBy(id = "answer13")
	WebElement answer13Element;
	
	@FindBy(id = "answer14")
	WebElement answer14Element;
	
	@FindBy(id = "name")
	WebElement textNameElement;
	
	@FindBy(id = "occupation")
	WebElement optionOccupationElement;
	
	@FindBy(xpath = "//*[@class='bluebox']")
	List<WebElement> blueBoxElements;
	
	@FindBy(xpath = "//*[@onclick='link_clicked();return false']")
	WebElement clickMeLinkElement;
	
	@FindBy(id = "redbox")
	WebElement redBoxElement;
	
	@FindBy(xpath = "//*[@value='wrotebook']")
	WebElement radioButtonYesWroteBookElement;
	
	@FindBy(id = "greenbox")
	WebElement greenBoxElement;
	
	@FindBy(id = "orangebox")
	WebElement orangeBoxElement;
	
	@FindBy(id = "ishere")
	WebElement isHereElement;
	
	@FindBy(id = "purplebox")
	WebElement purpleBoxElement;
	
	@FindBy(xpath = "//*[@onclick='show_new_link_after_wait();return false;']")
	WebElement buttonClickThenWaitElement;
	
	@FindBy(xpath = "//*[@onclick='click_after_wait();return false;']")
	WebElement buttonClickAfterWaitElement;
	
	@FindBy(id = "submitbutton")
	WebElement buttonSubmit;*/
	
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
		
		//driver.close();
	}
	
	@Test
	public void verifyMAgicMouseImageTest() {
		magicMouse.click();
		assertEquals("Unexpected product page from Magic Mouse image link", "Magic Mouse | ONLINE STORE", driver.getTitle());
		
		//driver.close();
	}
	
	@Test
	public void verifyMoreInfoLinkTest() {
		moreInfo.click();
		assertEquals("Unexpected product page from More Info link", "Magic Mouse | ONLINE STORE", driver.getTitle());
		
		//driver.close();
	}
	
	@Test
	public void verifyAllThreeProductsFromCarousel() {
		//System.out.println(slides.size());
		List<String> productNames = new ArrayList<>();
		productNames.add("Magic Mouse");
		productNames.add("iPhone 5");
		productNames.add("iPod Nano Blue");
		
		boolean allProductsExistInCarousel = false;
		
		for(int i = 0; i < 5; i++) {
			//System.out.println(slides.get(0).getText());
			
			if(productNames.contains(slides.get(0).getText())) {
				allProductsExistInCarousel = true;
			} else {
				allProductsExistInCarousel = false;
				break;
			}
			
			//System.out.println(allProductsExistInCarousel);
			//System.out.println(slides.get(0).getText());
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//System.out.println(allProductsExistInCarousel);
		assertTrue("Unexpected product in carousel", allProductsExistInCarousel);
		
		//driver.close();
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
	
	
	
	
	
	////@Test
	////public void testfall1() {
		/*buyNow.click();
		assertEquals("Unexpected product page from Buy Now button", "Magic Mouse | ONLINE STORE", driver.getTitle());
		
		iPodNanoBlue.click();
		assertEquals("Unexpected product page from iPod Nano Blue image link", "iPod Nano Blue | ONLINE STORE", driver.getTitle());
		
		home.click();
		
		moreInfo.click();
		assertEquals("Unexpected product page from More Info link", "Magic Mouse | ONLINE STORE", driver.getTitle());
		
		home.click();*/
		
		//System.out.println(slides.size());
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='click_after_wait();return false;']")));
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);*/
		
		//System.out.println(selectedSlides.size());
		
		/*try {
			int counter = 0;
			Thread.sleep(10000);
		
			for(WebElement element: selectedSlides) {
				if(element.getAttribute("class").equals("selected")) {
					//System.out.println(element.getAttribute("class") + ", " + counter);
					break;
				}
				counter++;
			}
			
			assertEquals("Unexpected change of product in carousel", 1, counter);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((WebElement) selectedSlides.get(2)).click();*/
		
		//System.out.println(latestBlogPost.size());
		////assertEquals("Unexpected amount of products under Latest Blog Post", 4, latestBlogPost.size());
		
		//System.out.println(latestBlogPost);
		////latestBlogPost.get(1).click();
		
		
		
		
		
		
		
		
		//List<WebElement> temp = new ArrayList<>();
		
		////for(WebElement element: latestBlogPost) {
			//List<WebElement> elements = (List<WebElement>) element;
			////String s = element.getText().substring(0, element.getText().indexOf("\n")).trim();
			//} else {
			//	s = element.getText().substring(0, 28).trim();
			//}
			
			//String s = element.getText().substring(0, 28).trim();
			//System.out.println(s);
			//System.out.println(element.getText().trim());
			//System.out.println(element.getText());
			
			//System.out.println(s.indexOf("\n"));
			
			//System.out.println(s);
			//System.out.println(s.length());
			//System.out.println();
			
			////WebElement e = driver.findElement(By.linkText(s));
			//System.out.println(e.getAttribute("title"));
			
			////temp.add(e.getAttribute("title"));
			
			/*
			//e.click();
			searchProducts.sendKeys(e.getAttribute("title"));
			searchProducts.sendKeys(Keys.RETURN);
			//home.click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Hej");*/
		////}
		
		
		
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("search")));
		//wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		driver.findElement(By.className("search")).click();
		driver.findElement(By.className("search")).sendKeys("Test1");
		driver.findElement(By.className("search")).sendKeys(Keys.RETURN);
		
		home.click();
		
		//PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("search")));
		//wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		driver.findElement(By.className("search")).click();
		driver.findElement(By.className("search")).sendKeys("Test2");
		driver.findElement(By.className("search")).sendKeys(Keys.RETURN);*/
		
		////for(String e: temp) {
			////WebDriverWait wait = new WebDriverWait(driver, 30);
			////wait.until(ExpectedConditions.presenceOfElementLocated(By.className("search")));
			////driver.findElement(By.className("search")).click();
			////driver.findElement(By.className("search")).sendKeys(e.trim());
			////driver.findElement(By.className("search")).sendKeys(Keys.RETURN);
			//wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(e.trim())));
			//String tempE = e.replace(" - ", " &#8211; ").trim();
			//System.out.println(tempE);
			////wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='prodtitle']/a")));
			////wait.pollingEvery(100, TimeUnit.MILLISECONDS);
			////System.out.println(e);
			////driver.findElement(By.xpath("//*[@class='prodtitle']/a")).click(); // xpath("//*[@title='" + e.trim() + "']")).click();
			////home.click();
			
			/*//WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("search")));
		    System.out.println(e.getAttribute("title"));
		    //driver.findElement(By.className("search")).click();
			driver.findElement(By.className("search")).sendKeys(e.getAttribute("title"));
			driver.findElement(By.className("search")).sendKeys(Keys.RETURN);
			//home.click();*/
		////}
		
		//System.out.println(temp);
		
		
		//WebElement e = driver.findElement(By.linkText("Apple iPhone 4S"));
		//System.out.println(e);
	////}
}
