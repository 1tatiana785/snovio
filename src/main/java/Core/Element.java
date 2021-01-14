package Core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Element {

    private static Collection ignored_exeptions = Arrays.asList(
            NoSuchElementException.class,
            ElementNotVisibleException.class,
            ElementNotSelectableException.class);

    public static WebDriverWait waitEl() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

    public WebDriverWait waitEl1() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 300);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

    public WebElement visibilityEl(WebElement element) {
        waitEl().ignoreAll(ignored_exeptions);
        waitEl().until(ExpectedConditions.visibilityOfAllElements(element));
        return element;
    }

    public WebElement waitingSelect(WebElement element) {
        waitEl().until(ExpectedConditions.elementToBeSelected(element));
        waitEl().ignoreAll(ignored_exeptions);
        return element;
    }

    public static WebElement waitingClickableLoc (By locator) {
        waitEl().ignoreAll(ignored_exeptions);
        return waitEl().until(ExpectedConditions.elementToBeClickable(locator));
    }

    /*public boolean isSelectEl(WebElement elementLocation) {
        if (Driver.getDriver().findElement(elementLocation).isSelected()) {
        } else return false;
        return true;
    }*/

    public static WebElement waitingClickable(By by) {
        waitEl().ignoreAll(ignored_exeptions);
        return waitEl().until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement visibilityElLoc (By locator) {
        waitEl().ignoreAll(ignored_exeptions);
        return waitEl().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement presenceElLocation(By locator) {
        waitEl().ignoreAll(ignored_exeptions);
        return waitEl().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement findElement(By by) {
        return Driver.getDriver().findElement(by);
    }

    public static WebElement findElementLoc(By elementLocation) {
        return Driver.getDriver().findElement(elementLocation);
    }

    public List<WebElement> findLestElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    public static void click (By locator) {
        waitingClickableLoc (locator).click();
    }

    public static void sendKeys(By elementLocation, String name) {
        findElementLoc(elementLocation).sendKeys(name);
    }

    public void keysEnter(By elementLocation) {
        Driver.getDriver().findElement(elementLocation).sendKeys(Keys.ENTER);
    }

    public void keysChordShift(By elementLocation, String name) {
        Driver.getDriver().findElement(elementLocation).sendKeys(Keys.chord(Keys.SHIFT, name));
    }

    public void keysChordControl(By elementLocation, String name) {
        Driver.getDriver().findElement(elementLocation).sendKeys(Keys.chord(Keys.CONTROL, name));
    }

    public void isEnable(By elementLocation) {
        Driver.getDriver().findElement(elementLocation).isEnabled();
    }

    public WebElement presenceElLocString(String locator, String number) {
        waitEl().ignoreAll(ignored_exeptions);
        return waitEl().until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(String.format(locator, number))));
    }

    public WebElement findStringEl(String elementLocation, String number) {
        return Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number)));
    }

    public WebElement visibilityString(String elementLocation, String name) {
        return Element.visibilityElLoc(By.xpath(String.format(elementLocation, name)));
    }

    public void clickStringNumber(String elementLocation, String number) {
        Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number))).click();
    }

    public boolean selectStringNumber(String elementLocation, String number) {
        if (Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number))).isSelected()) {
        } else return false;
        return true;
    }

    public void isEnableString(String elementLocation, String number) {
        Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number))).isEnabled();
    }
}