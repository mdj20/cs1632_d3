
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;





public class cs1632_d3 {
	
	
	static WebDriver webDriver = new HtmlUnitDriver();
	
	
	
	@Before
	public static void setUp() throws Exception {
		webDriver.get("http://www.myth-weavers.com");
	}
	
	
	
	@Test
	public static void test1() throws Exception {
	
		
		WebDriver testDriver = new FirefoxDriver();
		
		//testDriver.
		
		
		System.out.println("Hello World!");
		
		
		
	}

	
	
	
	
	
	
	

	
	
	

}