package com.webapp.test.google;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class GoogleSearchTest {

	// step1: Formulate a test url
	String siteUrl = "https://www.google.com/";
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
	void testSearch() {
		// find a a seach box
		WebElement searchBox = driver.findElement(By.name("q"));
		// Enter search keys
		searchBox.sendKeys("selenium webdriver download");
		// submit search
		searchBox.submit();

		String expected = "selenium webdriver download - Google Search";
		String actual = driver.getTitle();

		assertEquals(expected, actual);
	}

}
