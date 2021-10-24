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

class CheckBoxTest {

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
	@DisplayName("CheckBox One exist test")
	void testToVerifyCheckBoxExist() {
		WebElement checkBox = driver.findElement(By.id("vehicle1"));
		assertTrue(checkBox.isDisplayed());
		assertTrue(checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("CheckBox Two exist test")
	void testToVerifyCheckBox2Exist() {
		WebElement checkBox = driver.findElement(By.id("vehicle2"));
		assertTrue(checkBox.isDisplayed());
		assertTrue(checkBox.isEnabled());
		// default selected
		assertEquals(true, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("CheckBox One select test")
	void testToVerifyCheckBoxIsSelected() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle1"));
		assertTrue(checkBox.isDisplayed());
		assertTrue(checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
		
		//click on radiobutton
		checkBox.click();
		assertEquals(true, checkBox.isSelected());
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Deselect Checkbox Two select test")
	void testToVerifyRadioButton2IsSelected() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle2"));
		assertTrue(checkBox.isDisplayed());
		assertTrue(checkBox.isEnabled());
		assertEquals(true, checkBox.isSelected());
		
		//click on checkBox to deselect
		checkBox.click();
		assertEquals(false, checkBox.isSelected());
		Thread.sleep(3000);
	}

}
