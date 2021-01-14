package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static Core.Constants.DRIVER_CHROME;
import static Core.Constants.DRIVER_FIREFOX;

final public class Driver {
    private static final ThreadLocal<Driver> driverThread = new ThreadLocal<>();
    private static WebDriver driver = null;

    public static Driver getInstance() {
        if (driverThread.get() == null) {
            synchronized (Driver.class) {
                driverThread.set(new Driver());
            }
        }
        return driverThread.get();
    }

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if (Constants.browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", DRIVER_CHROME);
                //chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(new DriverOptions().chromeOptions());
            } else if (Constants.browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", DRIVER_FIREFOX);
                driver = new FirefoxDriver(new DriverOptions().firefoxOptions());
            }
        }
        return driver;
    }

    public static void close() {
        System.out.println("Closing the browser");
        driver.close();
        driver = null;
    }
}