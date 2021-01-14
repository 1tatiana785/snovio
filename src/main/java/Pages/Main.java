package Pages;

import Core.Driver;
import Core.Element;
import Core.MyActions;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Main {

    Actions actions = new Actions(Driver.getDriver());
    private By popUpWindow = By.xpath("//div[@class='modal-youtube']");
    private By closeButton = By.cssSelector(".modal-youtube>.btn-modal-close");
    private By findEmailLink = By.xpath("//nav[@class='app-header__nav']/div[2]");
    private By getListLink = By.xpath("//div[@class='app-header__nav-box']");
    String ListLink = "//div[@class='app-header__select-list']//a[@href='%s']";
    private By domainLink = By.xpath("//a[@href='https://app.snov.io/url-emails']");

    public void clickClosedButton() {
        Element.presenceElLocation(closeButton);
        MyActions.click(closeButton);
    }

    public void selectMenu() {
        actions.moveToElement(Driver.getDriver().findElement(findEmailLink)).build().perform();
        MyActions.visibility(getListLink);
        actions.moveToElement(Driver.getDriver().findElement(domainLink)).click().build().perform();
    }
}