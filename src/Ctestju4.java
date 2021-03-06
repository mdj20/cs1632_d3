//package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ctestju4 {
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
  public void testMsgSave() throws Exception {
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
    driver.findElement(By.name("title")).sendKeys("testing123");
    driver.findElement(By.id("vB_Editor_001_textarea")).clear();
    driver.findElement(By.id("vB_Editor_001_textarea")).sendKeys("welcome to test!");
    driver.findElement(By.id("vB_Editor_001_save")).click();
    driver.findElement(By.linkText("Track Messages")).click();
    driver.findElement(By.linkText("Your Control Panel")).click();
    driver.findElement(By.id("nav_pmfolders")).click();
    driver.findElement(By.linkText("Sent Items")).click();
    driver.findElement(By.linkText("testing123")).click();
    assertEquals("welcome to test!", driver.findElement(By.id("post_message_")).getText());
    driver.findElement(By.linkText("Sent Items")).click();
    driver.findElement(By.id("checkall_all")).click();
    driver.findElement(By.id("pm_inlinego")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Private Messages')])[2]")).click();
    driver.findElement(By.id("checkall_all")).click();
    new Select(driver.findElement(By.name("dowhat"))).selectByVisibleText("Delete");
    driver.findElement(By.id("pm_inlinego")).click();
    driver.findElement(By.linkText("Log Out 1n50mniac")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
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
