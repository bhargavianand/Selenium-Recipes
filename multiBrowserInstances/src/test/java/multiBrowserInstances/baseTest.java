package multiBrowserInstances;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class baseTest extends DriverFactory {

	private void googleExampleSearch(final String searchString) {
		System.setProperty("webdriver.chrome.driver", "C:\\gecko\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		WebElement searchField = driver.findElement(By.name("q"));
		searchField.clear();
		
		searchField.sendKeys(searchString);
		System.out.println("Page title is: " + driver.getTitle());
		
		searchField.submit();
		
		(new WebDriverWait(driver, 10))
			.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driverObject) {
					return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
				}
			});
		
		System.out.println("Page title is: " + driver.getTitle());
		
		driver.quit();
	}
	
	@Test
	public void googleCheese() {		
		googleExampleSearch("Cheese");
	}
	
	@Test
	public void googleMilk() {
		googleExampleSearch("Milk");
	}
	
	@Test
	public void googleBread() {
		googleExampleSearch("Bread");
	}
	
	@Test
	public void googleJuice() {
		googleExampleSearch("Juice");
	}
	
	@Test
	public void googleButter() {
		googleExampleSearch("Butter");
	}
	
}
