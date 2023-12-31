package multiBrowserInstances;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class DriverFactory {

	private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
	protected static ThreadLocal<WebDriverThread> driverThread;
	
	@BeforeSuite
	public static void instatiateDriverObject() {		
		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};
	}
	
	public static WebDriver getDriver() throws Exception {
		return driverThread.get().getDriver();
	}
	
	@AfterMethod
	public static void quitDriver() throws Exception {
		getDriver().manage().deleteAllCookies();		
	}
	
	@AfterSuite
	public static void closeDriverObjects() {
		for (WebDriverThread webDriveThread: webDriverThreadPool) {
			webDriveThread.quitDriver();
		}
	}
	
}
