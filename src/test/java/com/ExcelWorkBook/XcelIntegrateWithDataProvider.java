package com.ExcelWorkBook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestNGOCT.DataUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XcelIntegrateWithDataProvider {

	public static WebDriver driver;

	/*@DataProvider(name = "login")
	private String[][] loginDetails() {
		String[][] data = new String[2][2];
		data[0][0] = "husseyhari@gmail.com";
		data[0][1] = "Hari@123";

		data[1][0] = "8637615641";
		data[1][1] = "password@13";

		return data;

	}*/

	@Test(dataProvider = "dataUtils", dataProviderClass = DataUtils.class)
	//	private void Login(String id, String password) {

	private void Login(String [] data) { //give the inputs pass and email as data
		
		System.out.println("id =" + data[0]);
		System.out.println("pass =" + data[1]);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input#ap_email")).sendKeys(data[0]);
		driver.findElement(By.cssSelector("input[id=continue]")).click();
		driver.findElement(By.cssSelector("#ap_password")).sendKeys(data[1]);
		driver.findElement(By.cssSelector("input[type=submit]")).click();
		driver.quit();

	}

}
