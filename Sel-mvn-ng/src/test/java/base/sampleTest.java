package base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampleTest {

	@Test(priority = 2, description = "TEST APPLE")
	public void googleApple() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("apple", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for apple");
		driver.quit();
	}
	
	@Test(priority = 1, description = "TEST BANANA")
	public void googleBanana() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("banana", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for banana");
		driver.quit();
	}
	
	@Test(priority = 2, description = "TEST TABLE")
	public void googleTable() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("table", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for table");
		driver.quit();
	}
	
	@Test(priority = 1, description = "TEST CHAIR")
	public void googleChair() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("chair", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for chair");
		driver.quit();
	}
	
	@Test(priority = 2, description = "TEST RED")
	public void googleRed() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("red", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for red");
		driver.quit();
	}
	
	@Test(priority = 1, description = "TEST BLUE")
	public void googleBlue() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("blue", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for blue");
		driver.quit();
	}
	
	@Test(priority = 2, description = "TEST GREEN")
	public void googleGreen() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("green", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for green");
		driver.quit();
	}
	
	@Test(priority = 1, description = "TEST YELLOW")
	public void googleYellow() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("yellow", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for yellow");
		driver.quit();
	}
	
	@Test(priority = 2, description = "TEST TODAY")
	public void googleToday() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("today", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for today");
		driver.quit();
	}
	
	@Test(priority = 1, description = "TEST TOMORROW")
	public void googleTomorrow() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[id='lst-ib']"))
			.sendKeys("tomorrow", Keys.ENTER);
		System.out.println(">>> CONSOLE OUT >>> : Test for tomorrow");
		driver.quit();
	}
	
}
