package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static Core.Constants.DRIVER_CHROME;
import static Core.Constants.DRIVER_FIREFOX;

final public class Driver {

    private static WebDriver driver = null;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if (Constants.browserName.equalsIgnoreCase("chrome")) {
                if ((System.getProperty("os.name")).contains("linux")) {
                    System.setProperty("webdriver.chrome.driver", "/path/to/linux/chromedriver");
                } else {
                    System.setProperty("webdriver.chrome.driver", "/path/to/win/chromedriver.exe");
                }
            }
            System.setProperty("webdriver.chrome.driver", DRIVER_CHROME);
            driver = new ChromeDriver(new DriverOptions().chromeOptions());
        } else if (Constants.browserName.equalsIgnoreCase("firefox")) {
            if ((System.getProperty("os.name")).contains("linux")) {
                System.setProperty("webdriver.chrome.driver", "/path/to/linux/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "/path/to/win/chromedriver.exe");
            }
            System.setProperty("webdriver.gecko.driver", DRIVER_FIREFOX);
            driver = new FirefoxDriver(new DriverOptions().firefoxOptions());
        }
        return driver;
    }
}