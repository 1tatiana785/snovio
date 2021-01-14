package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

final public class MyActions {

    public static void findElement(By element) {
        Driver.getDriver().findElement(element);
    }

    public static void findElementLoc(By elementLocation) {
        Driver.getDriver().findElement(elementLocation);
    }

    public static void click(By elementLocation) {
        Driver.getDriver().findElement(elementLocation).click();
    }

    public static void visibility(By locator) {
        Element.visibilityElLocation(locator);
    }

    public static void isEnable(By elementLocation) {
        Driver.getDriver().findElement(elementLocation).isEnabled();
    }

    public static void presenceElLocation(By locator) {
        Element.presenceElLocation(locator);
    }

    public static void sendKeys(By elementLocation, String name) {
        Driver.getDriver().findElement(elementLocation).sendKeys(name);
    }

    public static void keysEnter(By elementLocation) {
        Driver.getDriver().findElement(elementLocation).sendKeys(Keys.ENTER);
    }

    public static void keysChordShift(By elementLocation, String name) {
        Driver.getDriver().findElement(elementLocation).sendKeys(Keys.chord(Keys.SHIFT, name));
    }

    public static void keysChordControl(By elementLocation, String name) {
        Driver.getDriver().findElement(elementLocation).sendKeys(Keys.chord(Keys.CONTROL, name));
    }

    public static List<WebElement> findElements(By elementLocation) {
        List<WebElement> list = Driver.getDriver().findElements(elementLocation);
        return list;
    }

    public static boolean selectStringNumber(String elementLocation, String number) {
        if (Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number))).isSelected()) {
        } else return false;
        return true;
    }

    public static void isEnableString(String elementLocation, String number) {
        Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number))).isEnabled();
    }

    public static void findStringElement(String elementLocation, String number) {
        Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number)));
    }

    public static void clickStringName(String elementLocation, String name) {
        Driver.getDriver().findElement(By.xpath(String.format(elementLocation, name))).click();
    }

    public static void clickStringNumber(String elementLocation, String number) {
        Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number))).click();
    }

    public static void clickString2(String elementLocation, String number, String number1) {
        // Element.waitingClickable(By.xpath(String.format(elementLocation, name)));
        Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number, number1))).click();
    }

    public static boolean selectString2(String elementLocation, String number, String number1) {
        if (Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number, number1))).isSelected()) {
        } else return false;
        return true;
    }

    public static void visibilityString(String elementLocation, String name) {
        Element.visibilityElLocation(By.xpath(String.format(elementLocation, name)));
    }

    public static void presenceElLocationString(String locator, String number) {
        Element.presenceElLocation(By.xpath(String.format(locator, number)));
    }
}