package base;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.MalformedURLException;

import org.testng.annotations.Parameters;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait explicitWait;
	public static Wait<WebDriver> fluentWait;
	public static String[] gridNodes = new String[2];

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		gridNodes = Config.NodeUrls();  		
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		// NOP
	}

	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	public void beforeTest(String browserSelection) {
		// NOP		
		DesiredCapabilities capabilities;
		driver = null;

        switch (browserSelection.toLowerCase()) {
        case "firefox":
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            capabilities.setPlatform(Platform.WIN10);
            try {
                driver = new RemoteWebDriver(new URL(Config.NodeUrls()[0]), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            break;

        case "chrome":
            System.setProperty("webdriver.chrome.driver", "C:\\gecko\\chromedriver.exe");
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WIN10);
            try {
                driver = new RemoteWebDriver(new URL(Config.NodeUrls()[1]), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            break;

        default:
            System.setProperty("webdriver.chrome.driver", "C:\\gecko\\chromedriver.exe");
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WIN10);
            try {
                driver = new RemoteWebDriver(new URL(Config.NodeUrls()[1]), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            break;
        }		
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		// NOP
		//driver.quit();
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
