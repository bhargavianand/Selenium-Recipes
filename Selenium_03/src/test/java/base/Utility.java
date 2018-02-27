package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utility {

    public static WebDriver getWebDriver(String browserName) {
        ThreadLocal<RemoteWebDriver> drv = new ThreadLocal<RemoteWebDriver>();
        DesiredCapabilities capabilities;

        switch (browserName.toLowerCase()) {
        case "firefox":
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            capabilities.setPlatform(Platform.WIN10);
            try {
                drv.set(new RemoteWebDriver(new URL(Config.NodeUrls()[0]), capabilities));
                //drv = new RemoteWebDriver(new URL(Config.NodeUrls()[0]), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            break;

        case "chrome":
            // WebDriverManager.chromedriver().setup();
            // driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "C:\\gecko\\chromedriver.exe");
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WIN10);
            try {
                drv.set(new RemoteWebDriver(new URL(Config.NodeUrls()[1]), capabilities));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            break;

        default:
            //capabilities = new DesiredCapabilities().chrome();
            System.setProperty("webdriver.chrome.driver", "C:\\gecko\\chromedriver.exe");
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WIN10);
            try {
                drv.set(new RemoteWebDriver(new URL(Config.NodeUrls()[1]), capabilities));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            break;
        }

        return drv.get();
    }

}
