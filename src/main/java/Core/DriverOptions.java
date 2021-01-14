package Core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverOptions {


    ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--deleteAllCookies");
        options.addArguments("--start-maximized");
        return options;
    }

    FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--deleteAllCookies");
        options.addArguments("--start-maximized");
        return options;
    }
}
