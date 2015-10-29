/*

Matthew Jeffreys

When I am logged into my account
And when user sends me a message
I should be able to view the message contents.


*/

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testmsgju {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.myth-weavers.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMsgju() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Log In")).click();
    driver.findElement(By.id("navbar_username")).clear();
    driver.findElement(By.id("navbar_username")).sendKeys("1n50mniac");
    driver.findElement(By.id("navbar_password")).clear();
    driver.findElement(By.id("navbar_password")).sendKeys("passpass");
    driver.findElement(By.cssSelector("input.button")).click();
    driver.findElement(By.linkText("Click here if your browser does not automatically redirect you.")).click();
    driver.findElement(By.linkText("1n50mniac")).click();
    driver.findElement(By.linkText("Send Message")).click();
    driver.findElement(By.linkText("Send a private message to 1n50mniac")).click();
    driver.findElement(By.name("title")).clear();
    driver.findElement(By.name("title")).sendKeys("test");
    driver.findElement(By.id("vB_Editor_001_textarea")).clear();
    driver.findElement(By.id("vB_Editor_001_textarea")).sendKeys("test");
    driver.findElement(By.id("vB_Editor_001_save")).click();
    driver.findElement(By.cssSelector("a > strong")).click();
    assertEquals("test", driver.findElement(By.id("post_message_")).getText());
    driver.findElement(By.xpath("(//a[contains(text(),'Private Messages')])[2]")).click();
    driver.findElement(By.id("checkall_all")).click();
    new Select(driver.findElement(By.name("dowhat"))).selectByVisibleText("Delete");
    driver.findElement(By.id("pm_inlinego")).click();
    new Select(driver.findElement(By.name("folderid"))).selectByVisibleText("Sent Items (1 Messages)");
    driver.findElement(By.id("checkall_all")).click();
    driver.findElement(By.id("pm_inlinego")).click();
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
