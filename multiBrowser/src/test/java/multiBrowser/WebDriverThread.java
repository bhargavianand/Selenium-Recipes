package multiBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import multiBrowser.config.DriverType;

public class WebDriverThread {

	private WebDriver webDriver;
	private DriverType selectedDriverType;
	
	//private final DriverType defaultDriverType = DriverType.FIREFOX;
	private final String browser = System.getProperty("browser").toUpperCase();
	private final String operatingSystem = System.getProperty("os.name").toUpperCase();
	private final String systemArchitecture = System.getProperty("os.arch");

	public WebDriver getDriver() throws Exception {
		if (null == webDriver) {
			selectedDriverType = DriverType.valueOf(browser);
			DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
			instantiateWebDriver(desiredCapabilities);			
		}
		return webDriver;
	}

	public void quitDriver() {
		if (null != webDriver) {
			webDriver.quit();			
		}
	}
	
//	private DriverType determineEffectiveDriverType() {		
//		DriverType driverType = DriverType.valueOf(browser);
//		try {
//			driverType = DriverType.valueOf(browser);
//		} catch (IllegalArgumentException ignored) {
//			System.err.println("Unknow driver specified, defaulting to '" + driverType + "'...");			
//		} catch (NullPointerException ignored) {
//			System.err.println("No driver specified, defaulting to '" + driverType + "'...");
//		}
//		return driverType;
//	}
	
	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) {
		System.out.println(" ");
		System.out.println("Current Operating System: " + operatingSystem);
		System.out.println("Current Architecture: " + systemArchitecture);
		System.out.println("Current Browser selection: " + selectedDriverType);		
		System.out.println(" ");	
		
		webDriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
	}

}
