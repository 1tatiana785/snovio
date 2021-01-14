package Core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

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

    public static WebElement visibilityElLocation(By locator) {
        waitEl().ignoreAll(ignored_exeptions);
        return waitEl().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement presenceElLocation(By locator) {
        waitEl().ignoreAll(ignored_exeptions);
        return waitEl().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement presenceElLocationString(String locator, String number) {
        waitEl().ignoreAll(ignored_exeptions);
        return waitEl().until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(String.format(locator, number))));
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

    public static WebElement waitingClickable(By locator) {
        waitEl().ignoreAll(ignored_exeptions);
        return waitEl().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitClick(By locator) {
        return waitEl().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitClick(WebElement element) {
        return waitEl().until(ExpectedConditions.elementToBeClickable(element));
    }
}