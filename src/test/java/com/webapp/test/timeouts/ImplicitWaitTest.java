package com.webapp.test.timeouts;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ImplicitWaitTest {

	// step1: Formulate a test url
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// implicit wait  : The implicit in selenium is used for tell the web driver to wait for 
		// a certain time before it throw a "No Such element exception" default implicit setting is 0.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	@DisplayName("Amazon Test : Mobile Nav Link")
	public void testMobileNavLink() {
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
		// test for exist
		assertTrue(mobileLink.isDisplayed());
		assertTrue(mobileLink.isEnabled());

		// click on mobile
		mobileLink.click();
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(expected, driver.getTitle());

	}

	@Test
	@DisplayName("Amazon Test : Fashion Nav Link")
	public void testFashionNavLink() {
		WebElement fashionLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(5)"));

		// test for exist
		assertTrue(fashionLink.isDisplayed());
		assertTrue(fashionLink.isEnabled());

		// click on mobile
		fashionLink.click();
		String expected = "Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids";
		assertEquals(expected, driver.getTitle());
	}
}
