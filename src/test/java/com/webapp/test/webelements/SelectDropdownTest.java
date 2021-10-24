package com.webapp.test.webelements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownTest {

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
	@DisplayName("Select dropdown exist test")
	void testToVerifyDropDownExist() {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		assertTrue(dropdown.isDisplayed());
		assertTrue(dropdown.isEnabled());
	}
	
	@Test
	@DisplayName("Test first selected option from dropdown")
	public void testToVerifyFirstSelectFromDropDown() throws InterruptedException {
		
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		//select option as bike
		select.selectByVisibleText("Bike");
		WebElement selectedRs = select.getFirstSelectedOption();
		assertEquals(" Bike ", selectedRs.getText());
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Test 3rd index selected option from dropdown")
	public void testToVerifyThirdIndexSelectFromDropDown() throws InterruptedException {
		
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		//select option as 3rd index
		select.selectByIndex(3);
		WebElement selectedRs = select.getFirstSelectedOption();
		assertEquals(" Airplane ", selectedRs.getText());
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("Test car  selected by value option from dropdown")
	public void testToVerifyCarSelectByValueFromDropDown() throws InterruptedException {
		
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		//select option as 3rd index
		select.selectByValue("car");
		WebElement selectedRs = select.getFirstSelectedOption();
		assertEquals(" Car ", selectedRs.getText());
		Thread.sleep(3000);
	}
}
