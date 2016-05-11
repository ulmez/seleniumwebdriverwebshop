package seleniumjunitwebshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

public class HomeFlikLatestBlogPostTest {
	WebDriver driver = new FirefoxDriver();
	
	@FindBy(xpath ="//*[@class='footer_featured']/ul/li")
	List<WebElement> latestBlogPost;
	
	@FindBy(xpath ="//*[@class='prodtitle']")
	WebElement productTitle;
	
	@FindBy(xpath ="//*[@class='footer_featured']/ul/li/a/img")
	List<WebElement> latestBlogPostImages;
	
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
		//driver.close();
	}
	
	@AfterClass
	public static void getAfterClass() {
		
	}
	
	/*@Test
	public void verifyLatestBlogPostSectionShowProductsTest() {
		//System.out.println(latestBlogPost.size());
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
	}*/
	
	@Test
	public void verifyLatestBlogPostSectionImageLeadToProductPageTest() {
		//System.out.println(latestBlogPostImages.get(2).getAttribute("title"));
		String productName = latestBlogPostImages.get(2).getAttribute("title").replace("–", "-").trim();
		
		//System.out.println(productName);
		
		latestBlogPostImages.get(2).click();
		
		//System.out.println(productTitle.getText().replace("–", "-").trim());
		
		assertEquals("Unexpected product on the product page from the Latest Blog Post image click", productName, productTitle.getText().replace("–", "-").trim());
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
