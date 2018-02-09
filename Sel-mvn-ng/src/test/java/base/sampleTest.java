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
		System.out.println("Test for apple");
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
		System.out.println("Test for banana");
		driver.quit();
	}
	
}
