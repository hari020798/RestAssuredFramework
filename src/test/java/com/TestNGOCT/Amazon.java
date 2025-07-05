package com.TestNGOCT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	WebDriver driver;

	@Test
	private void iDNameClassName() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();

		driver.findElement(By.id("ap_email")).sendKeys("8637615641");
		driver.findElement(By.className("a-button-input")).click();
		driver.findElement(By.name("password")).sendKeys("Hari@123");
		WebElement signInButton = driver.findElement(By.id("signInSubmit"));

		File elementScreenshot = signInButton.getScreenshotAs(OutputType.FILE);

		File destination = new File("./Element/img.png");
		FileUtils.copyFile(elementScreenshot, destination);

		TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

		signInButton.click();

		File destination1 = new File("./FullPage/img.png");

		File screenshotType = screenshotDriver.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotType, destination1);

		WebDriverWait wait = new WebDriverWait(driver, 10);
///ancestor::*[@class='nav-fill'][2]"))
		WebElement sBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));

		sBox.sendKeys("Iphone");
		WebElement click = driver
				.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']/span/input[@type='submit']"));
		click.click();
		List<WebElement> all = driver.findElements(
				By.xpath("//span[contains(text(),'iPhone')]/ancestor::div[@data-component-type='s-search-result']"));

		for (WebElement iphone : all) {
			String text = iphone.getText();
			if (text.contains("Apple iPhone 13 (128GB) - Midnight")) {
				// Scroll into view and wait until clickable
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iphone);
				wait.until(ExpectedConditions.elementToBeClickable(iphone));
				System.out.println(iphone.getText());
				// Click using JavaScript for reliability																																																																																																																								
				iphone.click();
				break; // Exit the loop after clicking the target
			}

		}
	}
}
