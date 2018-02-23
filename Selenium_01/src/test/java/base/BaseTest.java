package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait explicitWait;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {		
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		// NOP
		driver.quit();
	}
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		// NOP
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		// NOP
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
	
	public static void printTCStep(String output){
		System.out.println(">>> STEP >>> " + output + "...");
	}
	
}
