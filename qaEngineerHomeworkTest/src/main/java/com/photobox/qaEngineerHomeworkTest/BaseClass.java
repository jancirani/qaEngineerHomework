package com.photobox.qaEngineerHomeworkTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class BaseClass {
	/**
	 * Author: Naresh Kumar 08/11/2015
	 */

	public static WebDriver driver;
	public static Properties ObjectRepository = null;
	public static Properties CONFIG = null;
	public static boolean isLogged = false;
	static boolean Presense;
	public String actual;
	public ATUTestRecorder recorder;

	public void initialize() throws IOException {

		/***
		 * Loading CONFIG property File
		 */
		// if (driver == null) {
		CONFIG = new Properties();
		FileInputStream fn = new FileInputStream(System.getProperty("user.dir")
				+ "/src/main/resources/utilities/CONFIG.properties");
		CONFIG.load(fn);

		/**
		 * Loading OR Property File
		 */

		ObjectRepository = new Properties();
		fn = new FileInputStream(System.getProperty("user.dir")
				+ "/src/main/resources/utilities/ObjectRepository.properties");
		ObjectRepository.load(fn);

		/**
		 * Initialising WebDriver
		 */

		if (CONFIG.getProperty("browser").equals("FireFox")) {
			driver = new FirefoxDriver();

		} else if (CONFIG.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"src/test/resources/crossBrowserTesting/chromedriver.exe");
			
			
			driver = new ChromeDriver();
		}
	}

	// }

	public void lanchTaxApplication() throws ATUTestRecorderException,
			InterruptedException {
		recorder = new ATUTestRecorder(System.getProperty("user.dir")
				+ "/src/test/java/testsRecordings", "TC", true);
		recorder.start();
		String URL = System.getProperty("user.dir");
		driver.get(URL + CONFIG.getProperty("testSiteURL"));
		driver.manage().window().maximize();

	}

	public void closeBrowser() throws ATUTestRecorderException
	{
		driver.close();
		recorder.stop();
	}

	protected static WebElement getObject(String XpathElement,
			String IDElement, String CSSElement) throws IOException {
		String Xpath = XpathElement;
		String ID = IDElement;
		String CSS = CSSElement;
		try {

			if (Xpath != null) {
				WebElement myDynamicElement = (new WebDriverWait(driver, 30))
						.until(ExpectedConditions.presenceOfElementLocated(By
								.xpath(Xpath)));
				Presense = myDynamicElement.isDisplayed();
				return driver.findElement(By.xpath(Xpath));
			}

			else if (ID != null) {
				WebElement myDynamicElement1 = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By
								.id(ID)));
				Presense = myDynamicElement1.isDisplayed();
				return driver.findElement(By.id(ID));
			} else if (CSS != null) {
				WebElement myDynamicElement1 = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(By
								.cssSelector(CSS)));
				Presense = myDynamicElement1.isDisplayed();
				return driver.findElement(By.cssSelector(CSS));
			}
		} catch (Throwable  t ) {
			captureScreen();
			System.out.println(t.getMessage());
		}
	
		return null;
	}

	public static void captureScreen() throws IOException {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
				+ "/src/test/resources/screenshots/Failure.png"));
	}

}
