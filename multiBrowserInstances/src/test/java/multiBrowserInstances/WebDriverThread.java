package multiBrowserInstances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverThread {

	private WebDriver webDriver;

	private final String operatingSystem = System.getProperty("os.name").toUpperCase();
	private final String systemArchitecture = System.getProperty("os.arch");

	public WebDriver getDriver() throws Exception {
		if (null == webDriver) {
			System.out.println(" ");
			System.out.println("Current Operating System: " + operatingSystem);
			System.out.println("Current Architecture: " + systemArchitecture);
			System.out.println("Current Browser Selection: Chrome");
			System.out.println(" ");
			System.setProperty("webdriver.chrome.driver", "C:\\gecko\\chromedriver.exe");
			webDriver = new ChromeDriver();
		}
		return webDriver;
	}

	public void quitDriver() {
		if (null != webDriver) {
			webDriver.quit();
			webDriver = null;
		}
	}

}
