package com.webapp.test.google;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class GoogleHompageTest {

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
	void test() {
		// step5: Evaluate Test
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Test is passed !");
		} else {
			System.out.println("Test is failed !");
		}

		System.out.println("Expected Title : " + expectedTitle);
		System.out.println("Actual Title : " + actualTitle);
	}

}
