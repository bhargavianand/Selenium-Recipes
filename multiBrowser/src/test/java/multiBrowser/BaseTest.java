package multiBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BaseTest extends DriverFactory {

	private void googleExampleSearch(final String searchString) throws Exception {
		
		WebDriver driver = DriverFactory.getDriver();
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
				
	}
	
	@Test
	public void googleCheese() throws Exception {		
		googleExampleSearch("Cheese");
	}
	
	@Test
	public void googleMilk() throws Exception {
		googleExampleSearch("Milk");
	}
	
	@Test
	public void googleBread() throws Exception {
		googleExampleSearch("Bread");
	}
	
	@Test
	public void googleJuice() throws Exception {
		googleExampleSearch("Juice");
	}
	
	@Test
	public void googleButter() throws Exception {
		googleExampleSearch("Butter");
	}
	
}
