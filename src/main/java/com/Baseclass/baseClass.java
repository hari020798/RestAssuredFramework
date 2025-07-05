package com.Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public static WebDriver driver;
	public static String value;

	// 1,Browser Launch
	public static WebDriver browserlaunch(String type) {
		if (type.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}

		else if (type.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if (type.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}
	
	//2,isEnabled
	public static void isEnabled(WebElement Element) {
		Element.isEnabled();
    
	}
	
	//3,Is Displayed
	
	public static void isDisplayed(WebElement element) {
 element.isDisplayed();	
 }
	
	
	//4, Is selected
	public static void isSelected(WebElement element) {
element.isSelected();
	
	}
	
	
	

	// 5,CLick
	public static void clickOnElement(WebElement element) {

		element.click();

	}

//6,SendKeys
	public static WebDriver sendKeyElement(WebElement element, String value) {
		element.sendKeys(value);
		return driver;

	}

	//7 Actions, Move to Element & Double Click
	public static void Actionss(String type, WebElement element) {
		Actions a = new Actions(driver);

		if (type.equalsIgnoreCase("moveto")) {
			a.moveToElement(element).click().build().perform();

		} else if (type.equalsIgnoreCase("dclick")) {
			a.doubleClick(element).perform();

		}
	}

	public static void drag(WebElement Drag, WebElement drop) {
Actions a = new Actions(driver);
a.dragAndDrop(Drag, drop).build().perform();
	}
//8,Quit

	public static WebDriver quit() {
		driver.quit();
		return driver;
	}

//9,Close
	public static WebDriver close() {
		driver.close();
		return driver;
	}

	// 9Navigate 10, refresh T0/Back/Forward/Refresh
	public static WebDriver Navigates(String type, String value) {

		if (type.equalsIgnoreCase("to")) {
			driver.navigate().to(value);
		}

		else if (type.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}

		else if (type.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}

		else if (type.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}

		return driver;

	}

	// 11,GetUrl
	public static WebDriver getUrl(String url) {
		driver.get(url);
		return driver;
	}

	// 12,Dropdown
	public static void dropDown(String type, WebElement element, String value) {

		Select s = new Select(element);
		if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (type.equalsIgnoreCase("index")) {
			int data = Integer.parseInt(value);
			s.selectByIndex(data);
		} else if (type.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	}

	// 13,Gettext
	public static void GetText(WebElement element) {

		element.getText();

	}
	
	

	// 14,GetAttribute
	public static void GetAttribute(WebElement element, String text) {
		element.getAttribute(text);

	}

	// 15,Wait
	public static void waitMeth(WebElement element) throws InterruptedException {
		element.wait();

	}

	// 16,GetTitle
	public static WebDriver GetTitle() {
		driver.getTitle();
		return driver;
	}
	
	//17,getcurrentuRL
	
	public static WebDriver getCurrentURl() {
		driver.getCurrentUrl();
		return driver;

	}
	
	public static WebDriver getCurrrentURL() {
String currentUrl = driver.getCurrentUrl();
System.out.println(currentUrl);
return driver;
	}

	// 18,GetwindowHandles
	public static WebDriver getWindowhandles() {
		driver.getWindowHandle();
		return driver;

	}
	//19,getwindowhandles
	public static WebDriver getWindowHandlesss() {
		driver.getWindowHandles();
		return driver;

	}
	
	

	// 20,Alerts
	public static void Alerts(String type) {
		if (type.equalsIgnoreCase("accept")) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
//21dismiss
		} else if (type.equalsIgnoreCase("dismiss")) {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}

	}
//22.AlertSendkeys
	public static void Alertsendkeys(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}
	
	
//23,ExcelRead
	public static String excelRead(String link, int sheetin, int rowin, int cellin) throws IOException {
		File f = new File(link);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(sheetin);
		Row row = sheetAt.getRow(rowin);
		Cell cell = row.getCell(cellin);
		CellType cellType = cell.getCellType();

		if (cellType.equals(CellType.STRING)) {
			value = cell.getStringCellValue();
		}

		else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int data = (int) numericCellValue;
			value = String.valueOf(data);
		}
		wb.close();
		return value;
	}
	
	
	
	//24 ExcelReadall
	public static String excelReadAllData(String path,int sheetin) throws IOException {
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(sheetin);
		int numberOfRows = sheetAt.getPhysicalNumberOfRows();
		System.out.println(numberOfRows);
		for(int i=0;i<numberOfRows;i++) {
			Row row = sheetAt.getRow(i);
		
			int numberOfCells = row.getPhysicalNumberOfCells();
			for(int j=0;j<numberOfCells;j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if(cellType.equals(CellType.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}
				else if(cellType.equals(CellType.NUMERIC)) {
				    double numericCellValue = cell.getNumericCellValue();
				    int data = (int) numericCellValue;
 System.out.println(data);				}
				}
				} wb.close();
			    return value;}
	//25,Frames
	
	public static void Frames(String frame1,int frameint, WebElement element) {
		
		
		if(frame1.equalsIgnoreCase("frame")) {
			driver.switchTo().frame(element);
					}
		if(frame1.equalsIgnoreCase("frame1")) {
			driver.switchTo().frame(frameint);
		}
      if(frame1.equalsIgnoreCase("parentframe")) {
    	  driver.switchTo().parentFrame();
      }
      if(frame1.equalsIgnoreCase("default")) {
             driver.switchTo().defaultContent();
	}


}
	//26,clear
	public static void clear(WebElement  clear) {
		clear.clear();
		

	}
	
	
	
	//radio button
	public static void radioButton(WebElement element) {
 element.click();
	}
	
	//28 getlistselectedoptions
	
	public static void getlistSelectedOpt(WebElement element) {
Select s = new  Select(element);
s.getFirstSelectedOption();
	}
	
	//29 is multiple
	public static void isMultiple(WebElement element) {
Select s = new Select(element);
s.isMultiple();
	}
	
	//30, getoptions

	public static void getOptions(WebElement element) {
		Select s = new Select(element);
		s.getAllSelectedOptions();
        
	}
	
	//31 scroll
	
	public static void Scrolll(String type) {
  JavascriptExecutor j = (JavascriptExecutor) driver; //downcasting
  if(type.equalsIgnoreCase("bottom"))
  {
	  j.executeScript("window.scrollby(0,document.body.scrollHeight)");
  }
  else if(type.equalsIgnoreCase("top")) 
  {
	  j.executeScript("window.scrollTo(0,0)");
  }
  
	  
  }
	
	public static void windowsHandling(String wId) {
		Set<String> AllId = driver.getWindowHandles();
		for (String id : AllId) {
			
				if (!(id == wId))
					driver.switchTo().window(id); // Switch to the desired window first and then execute commands using
			}
	}

	public static void takeScreenshot(String fileName) {
		if (driver != null) {
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        File source = screenshotDriver.getScreenshotAs(OutputType.FILE);
        File destination = new File(fileName);
        destination.getParentFile().mkdirs();
        try {
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot taken on failure.");
        } catch (IOException ioException) {
            System.out.println("Failed to save screenshot: " + ioException.getMessage());
        }
    }
	}
	
	



	
	





/*

  public static void robotopt() throws AWTException { Robot r = new Robot(); 
 if
 r.keyPress(KeyEvent.VK_DOWN); r.keyRelease(KeyEvent.VK_DOWN);
 r.keyPress(KeyEvent.VK_DOWN); r.keyPress(KeyEvent.VK_DOWN);
 
 } */
 
}

