package org.master.facebook;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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

public class BaseClass {
	public static WebDriver driver;
	
	public static WebDriver browserLaunch(String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
		}
		else if (bname.equalsIgnoreCase("firebox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
		}
		else if (bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
		}
		return driver;
	}
	
	public static void url(String a) {
		driver.get(a);
		driver.manage().window().maximize();
	}
	
	public static void implicitlyWait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
	
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	
	public static void clicks(WebElement e) {
		e.click();
	}
	
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e);
	}
	
	public static void clickTarget(WebElement e,int a) {
		Select s=new Select(e);
		s.selectByIndex(a);
	}
	
	public static void keyEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void ketTab() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	
	public static void selectByIndex(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e);
	}
	
	public static void screensShot(String file) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		long time = System.currentTimeMillis();
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest=new File(file+time+".png");
		FileUtils.copyFile(src, dest);
	}
	
	public static String getAttriValue(WebElement e) {
		String s = e.getAttribute("value");
		return s;
	}
	
	public static String getAttriText(WebElement e) {
		String s = e.getAttribute("value");
		return s;
	}
	
	public static void quitsWindow() {
		driver.quit();
	}
	
}
