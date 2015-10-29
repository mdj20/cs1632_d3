package JUnit.JULoginTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

/*
AS a User
I would like to Login to my account
So that I can view my account information
*/

public class LoginSuite {
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
	Given a correct user name and password
	When I login
	Then my credentials should be accepted
	*/
	@Test
	public void testCorrectCorrect() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Log In")).click();
	    driver.findElement(By.id("navbar_username")).clear();
	    driver.findElement(By.id("navbar_username")).sendKeys("Aytros");
	    driver.findElement(By.id("navbar_password")).clear();
	    driver.findElement(By.id("navbar_password")).sendKeys("Mystra@428");
	    driver.findElement(By.cssSelector("input.button")).click();
	    assertEquals("Aytros", driver.findElement(By.linkText("Aytros")).getText());
	    driver.findElement(By.linkText("Log Out Aytros")).click();
	    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
	    driver.findElement(By.linkText("Go to forums index")).click();
	}
	
	/*
	Given a correct user name and incorrect password
	When I login
	Then my credentials should be rejected
	*/
	
	@Test
	public void testCorrectIncorrect() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Log In")).click();
	    driver.findElement(By.id("navbar_username")).clear();
	    driver.findElement(By.id("navbar_username")).sendKeys("Aytros");
	    driver.findElement(By.id("navbar_password")).clear();
	    driver.findElement(By.id("navbar_password")).sendKeys("wrong");
	    driver.findElement(By.cssSelector("input.button")).click();
	    assertEquals("Log In", driver.findElement(By.linkText("Log In")).getText());
	    driver.findElement(By.cssSelector("img[alt=\"Myth-Weavers\"]")).click();
	}
	
	/*
	Given an incorrect user name and a correct password
	When I login
	Then my credentials should be rejected
	*/
	@Test
	public void testIncorrectCorrect() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Log In")).click();
	    driver.findElement(By.id("navbar_username")).clear();
	    driver.findElement(By.id("navbar_username")).sendKeys("wrong");
	    driver.findElement(By.id("navbar_password")).clear();
	    driver.findElement(By.id("navbar_password")).sendKeys("Mystra@428");
	    driver.findElement(By.cssSelector("input.button")).click();
	    assertEquals("Log In", driver.findElement(By.linkText("Log In")).getText());
	    driver.findElement(By.cssSelector("img[alt=\"Myth-Weavers\"]")).click();
	}
	
	/*
	Given an incorrect user name and password
	When I login 
	Then my credentials should be rejected
	*/
	@Test
	public void testIncorrectIncorrect() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Log In")).click();
	    driver.findElement(By.id("navbar_username")).clear();
	    driver.findElement(By.id("navbar_username")).sendKeys("wrong");
	    driver.findElement(By.id("navbar_password")).clear();
	    driver.findElement(By.id("navbar_password")).sendKeys("wrong");
	    driver.findElement(By.cssSelector("input.button")).click();
	    assertEquals("Log In", driver.findElement(By.linkText("Log In")).getText());
	    driver.findElement(By.cssSelector("img[alt=\"Myth-Weavers\"]")).click();
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
