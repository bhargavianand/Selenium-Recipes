package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait explicitWait;
	public static Wait<WebDriver> fluentWait;
	public static String Node1Url;
	public static String Node2Url;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		Properties prop = new Properties();
		InputStream input = null;
		String usrDir = System.getProperty("user.dir");
		try {
			input = new FileInputStream(usrDir + "/base.properties");
			prop.load(input);

			Node1Url = prop.getProperty("node1.url");
			Node2Url = prop.getProperty("node2.url");
			System.out.println(Node1Url);
			System.out.println(Node2Url);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		// NOP

	}

	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	public void beforeTest(String browserSelection) {
		// NOP		

		switch (browserSelection.toLowerCase()) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver170.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		// NOP
		driver.quit();
	}

	@BeforeGroups(alwaysRun = true)
	public void beforeGroups() {
		// NOP
	}

	@AfterGroups(alwaysRun = true)
	public void afterGroups() {
		// NOP
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		// NOP
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// NOP
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext ctx, Method method) {
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("TEST CASE START ---------------------------------------------------------------");
		System.out.println(" Suite		: " + ctx.getCurrentXmlTest().getSuite().getName());
		System.out.println(" Test Group	: " + ctx.getName());
		System.out.println(" Test Case 	: " + method.getName());
		driver.get("http://www.google.com");
	}

	@AfterMethod
	public void afterMethod() {

	}

	public static void printTCStep(String output) {
		System.out.println(">>> STEP >>> " + output + "...");
	}

}
