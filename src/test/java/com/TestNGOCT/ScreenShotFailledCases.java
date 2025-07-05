package com.TestNGOCT;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Baseclass.baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotFailledCases extends baseClass {
	WebDriver driver;

	@Test
	private void FailTestCasesScreenshot() throws IOException {
		WebDriverManager.chromedriver().setup();

		try {
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			driver.findElement(By.id("ap_email")).sendKeys("8637615641");
			driver.findElement(By.className("a-button-input")).click();
			driver.findElement(By.name("password")).sendKeys("Hari@13");

			WebElement signInButton = driver.findElement(By.id("signInSubmit"));
			File source = signInButton.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Signin/img.png");
			FileUtils.copyFile(source, dest);
			System.out.println("Size === " + signInButton.getSize());
			System.out.println("getRect==" + signInButton.getRect());
			signInButton.click();

			// Checking the incorrect password message
			WebElement errorElement = driver
					.findElement(By.xpath("//span[contains(text(),'Your password is incorrect')]"));
			String errorMessage = errorElement.getText();
			Assert.assertEquals("Your password is incorret", errorMessage);

		} catch (AssertionError | Exception e) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			String fname = "./FailedScreenshot/img.png";
			File destination = new File(fname);
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, destination);

			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
}
