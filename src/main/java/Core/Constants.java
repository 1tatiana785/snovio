package Core;

import java.io.File;

public class Constants {

    public static String browserName = "chrome";
    public static String url = "https://app.snov.io/login";
    public static String email = "t_test_t@yahoo.com";
    public static String password = "test123456789";
    public static String DRIVER_CHROME = new File("src/main/resources/chromedriver").getAbsolutePath();
    public static String DRIVER_FIREFOX = new File("src/main/resources/geckodriver").getAbsolutePath();
    public static String File1 = new File("src/main/resources/cat.jpg").getAbsolutePath();
    public static String File2 = new File("src/main/resources/2.txt").getAbsolutePath();
}
