package com.webapp.test.screenshot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TakeScreenshotTest {

	// step1: Formulate a test url
	String siteUrl = "https://www.facebook.com/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void testHomepage() throws IOException {
		assertEquals("Facebook - Log In or Sign Up", driver.getTitle());
		takeScreenShot("facebook-homepage.png");
	}
	
	
	@Test
	void testInputDataEntry() throws IOException {
		driver.findElement(By.cssSelector("#email")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("abc@123");
		driver.findElement(By.name("login")).submit();
		
		takeScreenShot("facebook-dataentry.png");
	}
	
	
	@Test
	@DisplayName("Facebook Login Test")
	void testForFaiure() throws IOException {
		driver.findElement(By.cssSelector("#email")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("abc@123");
		driver.findElement(By.name("login")).submit();
		
		//evaluate failure test
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", errorMsg.getText());		
		
		WebElement errorMsg2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"error_box\"]/div[2]")));
		assertEquals("Invalid username or password", errorMsg2.getText());
	
		takeScreenShot("facebook-login-failed.png");
	}

	private void takeScreenShot(String filename) throws IOException {
		// type cast take screenshot
		TakesScreenshot tsc = (TakesScreenshot) driver;

		// screenshot as file
		File src = tsc.getScreenshotAs(OutputType.FILE);

		// copy src into file
		FileHandler.copy(src, new File("/home/wahidkhan74gmai/test-screenshot/"+filename));

	}
}
