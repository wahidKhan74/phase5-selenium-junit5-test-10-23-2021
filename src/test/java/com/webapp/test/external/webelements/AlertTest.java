package com.webapp.test.external.webelements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AlertTest {

	// step1: Formulate a test url
	String siteUrl = "file:///home/wahidkhan74gmai/PG2-Workspace/phase5-selenium-junit5-test-10-23-2021/static/external-web-element.html";
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
	@DisplayName("Alert Test :  simple  alert window ")
	void testAlertDailogWindow() throws InterruptedException {
		//find and open alert
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(2) > button"));
		alertButton.click();
		
		//switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Are you sure !", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	
	@Test
	@DisplayName("Confirm Test :  confirmation  alert window with accept")
	void testConfirmDailogWindow() throws InterruptedException {
		//find and open confirm
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmButton.click();
		
		//switch to confirm window
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		// confirmation with ok button click
		alert.accept();
	}
	
	@Test
	@DisplayName("Confirm Test :  confirmation  alert window with cancel")
	void testConfirmDailogWindowCancel() throws InterruptedException {
		//find and open confirm
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmButton.click();
		
		//switch to confirm window
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		// confirmation with cancel button click
		alert.dismiss();
	}

	
	@Test
	@DisplayName("Prompt Test :  Prompt alert window with accept")
	void testPromptDailogWindow() throws InterruptedException {
		//find and open prompt
		WebElement promptButton = driver.findElement(By.cssSelector("body > p:nth-child(6) > button"));
		promptButton.click();
		
		//switch to prompt window
		Alert alert = driver.switchTo().alert();
		assertEquals("Please enter your name", alert.getText());
		alert.sendKeys("Iron Man");
		Thread.sleep(3000);
		// confirmation with accept button click
		alert.accept();
		}
}
