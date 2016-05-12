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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPagesFacebookTest {
	WebDriver driver = new FirefoxDriver();
	
	@FindBy(xpath ="//*[@class='buynow']")
	WebElement buyNow;
	
	@FindBy(xpath ="//*[@class='fb-like fb_iframe_widget']/span/iframe")
	WebElement likeButton;
	
	@FindBy(id ="facebook")
	WebElement facebookPage;
	
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
	
	@Test
	public void verifyFacebookLoginWindowAppearsTest() {
		buyNow.click();
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//String script = "window.open('');";
		//js.executeScript(script);
		//js.executeScript("document.createElement('p').appendChild(document.createTextNode('This is new.'));");
		
		//System.out.println(facebookPage);
		//System.out.println(likeButton.getAttribute("src"));
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='pluginButtonLabel']")));
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);*/
		
		////likeButton.click();
		
		//System.out.println(likeButton.getAttribute("src"));
		////String facebookUrl = likeButton.getAttribute("src");
		
		////driver.findElement(By.tagName("body")).sendKeys(Keys.COMMAND + "n");
		
		////driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		
		//System.out.println(driver.getWindowHandles().toArray()[0]);
		
		////driver.navigate().to(facebookUrl);
		
		//driver.navigate().to("https://www.facebook.com/login.php?api_key=127760087237610&skip_api_login=1&display=popup&nux=0&social_plugin_action=like&social_plugin=like&next=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Fplugin.optin%3F_path%3Dplugin.optin%26app_id%3D127760087237610%26client_id%3D127760087237610%26display%3Dpopup%26secure%3Dtrue%26social_plugin%3Dlike%26return_params%3D%257B%2522app_id%2522%253A%2522%2522%252C%2522channel%2522%253A%2522http%253A%252F%252Fstaticxx.facebook.com%252Fconnect%252Fxd_arbiter.php%253Fversion%253D42%2523cb%253Df1bfbf9c4537a92%2526domain%253Dstore.demoqa.com%2526origin%253Dhttp%25253A%25252F%25252Fstore.demoqa.com%25252Ff3531ac529eee94%2526relation%253Dparent.parent%2522%252C%2522container_width%2522%253A%252270%2522%252C%2522href%2522%253A%2522http%253A%252F%252Fstore.demoqa.com%252Fproducts-page%252Fproduct-category%252Faccessories%252Fmagic-mouse%252F%2522%252C%2522layout%2522%253A%2522button_count%2522%252C%2522locale%2522%253A%2522en_US%2522%252C%2522sdk%2522%253A%2522joey%2522%252C%2522send%2522%253A%2522false%2522%252C%2522show_faces%2522%253A%2522false%2522%252C%2522width%2522%253A%2522100%2522%252C%2522ret%2522%253A%2522optin%2522%252C%2522act%2522%253A%2522connect%2522%257D%26login_params%3D%257B%2522nux%2522%253Afalse%252C%2522social_plugin_action%2522%253A%2522like%2522%257D%26from_login%3D1&rcount=1");
		
		//driver.navigate().to("https://www.facebook.com/login.php?api_key=127760087237610&skip_api_login=1&display=popup&nux=0&social_plugin_action=like&social_plugin=like&next=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Fplugin.optin%3F_path%3Dplugin.optin%26app_id%3D127760087237610%26client_id%3D127760087237610%26display%3Dpopup%26secure%3Dtrue%26social_plugin%3Dlike%26return_params%3D%257B%2522app_id%2522%253A%2522%2522%252C%2522channel%2522%253A%2522http%253A%252F%252Fstaticxx.facebook.com%252Fconnect%252Fxd_arbiter.php%253Fversion%253D42%2523cb%253Df1bfbf9c4537a92%2526domain%253Dstore.demoqa.com%2526origin%253Dhttp%25253A%25252F%25252Fstore.demoqa.com%25252Ff3531ac529eee94%2526relation%253Dparent.parent%2522%252C%2522container_width%2522%253A%252270%2522%252C%2522href%2522%253A%2522http%253A%252F%252Fstore.demoqa.com%252Fproducts-page%252Fproduct-category%252Faccessories%252Fmagic-mouse%252F%2522%252C%2522layout%2522%253A%2522button_count%2522%252C%2522locale%2522%253A%2522en_US%2522%252C%2522sdk%2522%253A%2522joey%2522%252C%2522send%2522%253A%2522false%2522%252C%2522show_faces%2522%253A%2522false%2522%252C%2522width%2522%253A%2522100%2522%252C%2522ret%2522%253A%2522optin%2522%252C%2522act%2522%253A%2522connect%2522%257D%26login_params%3D%257B%2522nux%2522%253Afalse%252C%2522social_plugin_action%2522%253A%2522like%2522%257D%26from_login%3D1&rcount=1");
	}
}
