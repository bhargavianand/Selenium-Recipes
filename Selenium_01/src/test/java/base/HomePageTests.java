package base;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageTests extends BaseTest {
		
	@Test(	priority = 2, 
			description = "TEST APPLE",
			groups = {"SmokeTest", "RegressionTest", "SystemTest"})
	public void googleApple() {		
		printTCStep("Wait for search bar to display");
		explicitWait = new  WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By
			.cssSelector("input[id='lst-ib']")));
		printTCStep("Search for apple");
		driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("apple", Keys.ENTER);	
		printTCStep("Wait for search results");
		explicitWait.until(ExpectedConditions.elementToBeClickable(By
			.cssSelector("div[id='resultStats']")));
		printTCStep("Check if Apple result is displayed as main");
		String text = driver.findElement(By
			.cssSelector("div[class='med']:nth-child(2) div[class='_NId']:nth-child(1) div:nth-child(1)>h3"))
			.getText();
		try {
			Assert.assertEquals(text.toLowerCase(), "apple", "apple not displayed");
		} catch (AssertionError t) {
			Assert.fail("Expected apples, but got " + text);
		}
				
	}
	
	@Test(	priority = 1, 
			description = "TEST BANANA",
			groups = {"SmokeTest", "RegressionTest", "SystemTest"})
	public void googleBanana() {
		printTCStep("Wait for search bar to display");
		fluentWait = new FluentWait<WebDriver>(driver)
			.withTimeout(30, TimeUnit.SECONDS)
			.pollingEvery(5, TimeUnit.SECONDS)
			.ignoring(NoSuchMethodException.class);
		WebElement searchBar = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("input[id='lst-ib']"));
			}
		});
		
		printTCStep("Search for banana");
		searchBar.sendKeys("banana", Keys.ENTER);
		printTCStep("Wait for search results");
		explicitWait = new  WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By
			.cssSelector("div[id='resultStats']")));
		String text = driver.findElement(By.cssSelector("div[id='search'] div[class='_NId']:nth-child(1) h3:nth-child(1)>a")).getText();
		Assert.assertTrue(text.toLowerCase().contains("bananai"), "Expected text to contain bananai, but got " + text);
		
	}
	
	@Test(	priority = 2, 
			description = "TEST CHERRY",
			groups = {"RegressionTest", "SystemTest"})
	public void googleCherry() {		
		driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("cherry", Keys.ENTER);
		printTCStep("Search for cherry");		
	}
	
	@Test(	priority = 1, 
			description = "TEST DATES",
			groups = {"RegressionTest", "SystemTest"})
	public void googleDates() {		
		driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("dates", Keys.ENTER);
		printTCStep("Search for dates");		
	}
	
	@Test(	priority = 2, 
			description = "TEST EGGFRUIT",
			groups = {"SystemTest"})
	public void googleEggfruit() {		
		driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("eggfruit", Keys.ENTER);
		printTCStep("Search for eggfruit");		
	}
	
	@Test(	priority = 1, 
			description = "TEST FIG",
			groups = {"SystemTest"})
	public void googleFig() {		
		driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("fig", Keys.ENTER);
		printTCStep("Search for fig");		
	}
	
	@Test(	priority = 2, 
			description = "TEST GRAPES",
			groups = {"SystemTest"})
	public void googleGrapes() {		
		driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("grapes", Keys.ENTER);
		printTCStep("Search for grapes");
	}
	
	@Test(	priority = 1, 
			description = "TEST HONEY",
			groups = {"SystemTest"})
	public void googleHoney() {		
		driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("honey", Keys.ENTER);
		printTCStep("Search for honey");
	}
	
	@Test(	priority = 2, 
			description = "TEST IMBE",
			groups = {"SystemTest"})
	public void googleImbe() {		
		driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("today", Keys.ENTER);
		printTCStep("Search for imbe");
	}
	
	@Test(	priority = 1, 
			description = "TEST JACKFRUIT",
			groups = {"SystemTest"})
	public void googleJackfruit() {		
		driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("tomorrow", Keys.ENTER);
		printTCStep("Search for jackfruit");
	}
	
	
}
