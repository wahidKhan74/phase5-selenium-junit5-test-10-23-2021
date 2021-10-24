package com.webapp.test.webelements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class RadioButtonTest {

	// step1: Formulate a test url
	String siteUrl = "file:///home/wahidkhan74gmai/PG2-Workspace/phase5-selenium-junit5-test-10-23-2021/static/web-elements.html";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		 driver.close();
	}

	@Test
	@DisplayName("Radio button One exist test")
	void testToVerifyRadioButtonExist() {
		WebElement radioButton = driver.findElement(By.id("male"));
		assertTrue(radioButton.isDisplayed());
		assertTrue(radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
	}
	
	@Test
	@DisplayName("Radio button Two exist test")
	void testToVerifyRadioButton2Exist() {
		WebElement radioButton = driver.findElement(By.id("female"));
		assertTrue(radioButton.isDisplayed());
		assertTrue(radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
	}
	
	@Test
	@DisplayName("Radio button One select test")
	void testToVerifyRadioButton1IsSelected() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("male"));
		assertTrue(radioButton.isDisplayed());
		assertTrue(radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		
		//click on radiobutton
		radioButton.click();
		assertEquals(true, radioButton.isSelected());
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Radio button Two select test")
	void testToVerifyRadioButton2IsSelected() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("female"));
		assertTrue(radioButton.isDisplayed());
		assertTrue(radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		
		//click on radiobutton
		radioButton.click();
		assertEquals(true, radioButton.isSelected());
		Thread.sleep(3000);
	}

}
