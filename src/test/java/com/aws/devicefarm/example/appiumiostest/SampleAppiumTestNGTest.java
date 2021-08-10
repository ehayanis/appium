package com.aws.devicefarm.example.appiumiostest;

import org.testng.annotations.Test;
import java.io.File;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SampleAppiumTestNGTest 
{
	private static RemoteWebDriver driver = null;
	
	public boolean takeScreenshot(final String name) {
		String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}
  
	
	@BeforeMethod
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
       		URL url = new URL("http://localhost:4723/wd/hub");
        	driver = new RemoteWebDriver(url, capabilities);
	}
	
	
	@Test
	public void test01() throws InterruptedException {
		driver.findElement(By.name("Add")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("Complete Taxes");
		driver.findElement(By.name("Save")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]")).click();
		String screenshot1 = null;
		takeScreenshot(screenshot1);
	}
	
	
	@Test
	public void test02() throws InterruptedException {
		driver.findElement(By.name("Add")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("Book tickets for vacation");
		driver.findElement(By.name("Save")).click();
		String screenshot2 = null;
		takeScreenshot(screenshot2);
	}
	

	@Test
	public void test03() throws InterruptedException {
		driver.findElement(By.name("Add")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")).click();
	}
	

	@Test
	public void test04() throws InterruptedException {
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
	}

	
	@AfterMethod
	public static void tearDownClass() {
        		if (driver != null) {
            		driver.quit();
        		}
    	}
}
