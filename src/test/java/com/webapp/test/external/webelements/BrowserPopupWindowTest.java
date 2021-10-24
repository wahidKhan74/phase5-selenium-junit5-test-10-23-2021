package com.webapp.test.external.webelements;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserPopupWindowTest {

	String siteUrl = "https://www.amazon.in/";
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
	void testBrowserPopup() throws InterruptedException {
		// find and open location popup
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(3000);
		//swith from main window to popup window
		String mainWinodw = driver.getWindowHandle();
		//list of external popups
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while (itr.hasNext()) {
			String chidWindow = itr.next();		
			//switch to child window
			driver.switchTo().window(chidWindow);
			//find pin location input
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500018");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
		}
		driver.switchTo().window(mainWinodw);
		Thread.sleep(5000);
	}
}
