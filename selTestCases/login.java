package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class login {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.myth-weavers.com/");
		selenium.start();
	}

	@Test
	public void testLogin() throws Exception {
		selenium.open("/");
		selenium.click("link=Log In");
		selenium.type("id=navbar_username", "1n50mniac");
		selenium.type("id=navbar_password", "passpass");
		selenium.click("css=input.button");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Click here if your browser does not automatically redirect you.");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
