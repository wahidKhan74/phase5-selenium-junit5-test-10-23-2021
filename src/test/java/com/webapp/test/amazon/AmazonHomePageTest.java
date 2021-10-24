package com.webapp.test.amazon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHomePageTest {

	// step1: Formulate a test url
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {

		// step2: Setting selenium system property
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step3: Initiate selenium webdriver
		driver = new ChromeDriver();

		// step4: Lunch web browser
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		// step6: close driver
		driver.close();
	}

	@Test
	public void testHompageTitle() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assertions.assertEquals(expected, driver.getTitle());
	}
	
	@Test
	public void testHompageSourceUrl() {
		Assertions.assertEquals(siteUrl, driver.getCurrentUrl());
	}
}
