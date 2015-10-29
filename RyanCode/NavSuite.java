package JUnit.JUNavTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

/*
As a User
I would like to have a navigation bar
So that I may go to different areas of the website
*/

public class NavSuite {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
	  driver = new HtmlUnitDriver();
	  baseUrl = "http://www.myth-weavers.com/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	/*
	Given: Logged into a valid account
	When: I look at the navigation bar
	Then: I will see a link for my user profile
	*/
	@Test
	public void testProfile() throws Exception {
		driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Log In")).click();
	    driver.findElement(By.id("navbar_username")).clear();
	    driver.findElement(By.id("navbar_username")).sendKeys("Aytros");
	    driver.findElement(By.id("navbar_password")).clear();
	    driver.findElement(By.id("navbar_password")).sendKeys("Mystra@428");
	    driver.findElement(By.cssSelector("input.button")).click();
	    driver.findElement(By.linkText("Aytros")).click();
	    assertEquals("Aytros's Profile", driver.findElement(By.cssSelector("strong")).getText());
	}

	/*
	Given: a loaded site
	When: I view the navigation bar
	Then: I will see a link to currently running games
	*/
	@Test
	public void testGames() throws Exception {
	  driver.get(baseUrl + "/");
	  assertEquals("Games", driver.findElement(By.linkText("Games")).getText());
	}
	
	/*
	Given: a loaded site
	When: I view the navigation bar
	Then: I will see a link to view my character sheets
	*/
	@Test
	public void testSheets() throws Exception {
		driver.get(baseUrl + "/");
		assertEquals("Sheets", driver.findElement(By.linkText("Sheets")).getText());
	}
	
	/*
	Given: a loaded site
	When: I view the navigation bar
	Then: I will see a link for the maps that I have created
	*/
	@Test
	public void testMaps() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("navbar_username")).clear();
	    driver.findElement(By.id("navbar_username")).sendKeys("Aytros");
	    driver.findElement(By.id("navbar_password")).clear();
	    driver.findElement(By.id("navbar_password")).sendKeys("Mystra@428");
	    driver.findElement(By.cssSelector("input.button")).click();
	    assertEquals("Maps", driver.findElement(By.linkText("Maps")).getText());
	}
	
	/*
	Given: a loaded site
	When: The navigation bar is viewed
	Then: I will see a link to an online store
	*/
	@Test
	public void testShop() throws Exception {
		driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Shop")).click();
	    assertEquals("Myth-Weavers Shop", driver.findElement(By.linkText("Myth-Weavers Shop")).getText());
	}
	
	/*
	Given: a loaded site
	When: I view the navigation bar
	Then: I will see a link to a wiki page
	*/
	@Test
	public void testWiki() throws Exception {
		driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Wiki")).click();
	    assertEquals("Welcome to Myth-Weavers Wiki!", driver.findElement(By.cssSelector("td > div")).getText());
	}

	@After
	public void tearDown() throws Exception {
	  driver.quit();
	  String verificationErrorString = verificationErrors.toString();
	  if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	  }
	}

	private boolean isElementPresent(By by) {
	  try {
	    driver.findElement(by);
	    return true;
	  } catch (NoSuchElementException e) {
	    return false;
	  }
	}

	private boolean isAlertPresent() {
	  try {
	    driver.switchTo().alert();
	    return true;
	  } catch (NoAlertPresentException e) {
	    return false;
	  }
	}

	private String closeAlertAndGetItsText() {
	  try {
	    Alert alert = driver.switchTo().alert();
	    String alertText = alert.getText();
	    if (acceptNextAlert) {
	      alert.accept();
	    } else {
	      alert.dismiss();
	    }
	    return alertText;
	  } finally {
	    acceptNextAlert = true;
	  }
	}
}
