package Pages;

import Core.Driver;
import Core.Element;
import Core.MyActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class FindEmails {

    private By bulkPage = By.id("app-layout");
    private By uploadFromFileButton = By.xpath("//span[text()='Upload from file']");
    private By domainNamesRadioButton = By.xpath("//span[text()='Upload from file']");
    private By chooseFile = By.xpath("//input[@type='file']");
    private By wrongTypeText = By.className("help-block");
    private By emailsOnlyButton = By.xpath("//span[text()='Emails only']");
    private By selected1Checkbox = By.cssSelector(".email-boxes > label:nth-child(1)>input");
    private By selected2Checkbox = By.cssSelector(".email-boxes > label:nth-child(2)>input");
    private By selected3Checkbox = By.cssSelector(".email-boxes > label:nth-child(3)>input");
    private By startSearchButton = By.cssSelector(".hint-container>button");
    private By errorPopUp = By.cssSelector(".sweet-alert h2");
    private By okButton = By.cssSelector(".confirm");
    private By resultText = By.cssSelector(".domain-search-result > tr:nth-child(1) > td:nth-child(2)>span");
    private By resultButton = By.cssSelector(".domain-search-result > tr:nth-child(1) > td:nth-child(3)>button");
    //String checkCheckbox = ".email-boxes > label:nth-child(%$)>input";
    String checkCheckbox = "//div[@class='email-boxes custom-checkbox bare']/label[%$]/input";


    public void waitBulkDomainSearchPage() {
        Element.visibilityElLocation(bulkPage);
    }

    public void clickDomainNamesButton() {
        WebElement button = Driver.getDriver().findElement(domainNamesRadioButton);
        MyActions.click(uploadFromFileButton);
        if (button.isEnabled())
            MyActions.click(domainNamesRadioButton);
        else MyActions.click(uploadFromFileButton);
    }

    public void chooseFile(String file) {
        MyActions.sendKeys(chooseFile, file);
    }

    public String checkFile() {
        String fileText = Driver.getDriver().findElement(wrongTypeText).getText();
        return fileText;
    }

    public void clickEmailsOnlyButton() {
        WebElement button = Driver.getDriver().findElement(emailsOnlyButton);
        if (button.isEnabled())
            MyActions.click(emailsOnlyButton);
    }

    /*public void uncheckCheckbox (String number) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Element.presenceElLocationString(selectedCheckbox, number);
        WebElement checkbox = Driver.getDriver().findElement(By.xpath(String.format(checkCheckbox, number)));
        if (checkbox.isEnabled()) {
            if (MyActions.selectStringNumber(checkCheckbox, number)) {
                MyActions.clickStringNumber(checkCheckbox, number);
            }
        }
    }*/

    public void uncheckCheckbox1() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Element.presenceElLocation(selected1Checkbox);
        WebElement element = Driver.getDriver().findElement(selected1Checkbox);
        if (element.isDisplayed()) {
            if (element.isSelected()) {
                MyActions.click(selected1Checkbox);
            }
        }
    }

    public void uncheckCheckbox2() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Element.presenceElLocation(selected2Checkbox);
        WebElement element = Driver.getDriver().findElement(selected2Checkbox);
        if (element.isDisplayed()) {
            if (element.isSelected()) {
                MyActions.click(selected2Checkbox);
            }
        }
    }

    public void uncheckCheckbox3() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Element.presenceElLocation(selected3Checkbox);
        WebElement element = Driver.getDriver().findElement(selected3Checkbox);
        if (element.isDisplayed()) {
            if (element.isSelected()) {
                MyActions.click(selected3Checkbox);
            }
        }
    }

    public void checkCheckbox1() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Element.presenceElLocation(selected1Checkbox);
        WebElement element = Driver.getDriver().findElement(selected1Checkbox);
        if (element.isDisplayed()) {
            if (!element.isSelected()) {
                MyActions.click(selected1Checkbox);
            }
        }
    }

    public void checkCheckbox2() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Element.presenceElLocation(selected2Checkbox);
        WebElement element = Driver.getDriver().findElement(selected2Checkbox);
        if (element.isDisplayed()) {
            if (!element.isSelected()) {
                MyActions.click(selected2Checkbox);
            }
        }
    }

    public void checkCheckbox3() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Element.presenceElLocation(selected3Checkbox);
        WebElement element = Driver.getDriver().findElement(selected3Checkbox);
        if (element.isDisplayed()) {
            if (element.isSelected()) {
                MyActions.click(selected3Checkbox);
            }
        }
    }

    public void clickStartSearchButton() {
        WebElement button = Driver.getDriver().findElement(startSearchButton);
        if (button.isEnabled())
            MyActions.click(startSearchButton);
    }

    public void waitCheckType() {
        WebElement button = Driver.getDriver().findElement(errorPopUp);
        if (button.isEnabled())
            checkType();
        //   System.out.println(checkType());
    }

    public String checkType() {
        String messageText = Driver.getDriver().findElement(errorPopUp).getText();
        return messageText;
    }

    public void clickOkButton() {
        MyActions.click(okButton);
    }

    public String getResultText1() {
        String actualResult = Driver.getDriver().findElement(resultText).getText();
        return actualResult;
    }

    public boolean getResultText() {
        String actualResult = new String(Driver.getDriver().findElement(resultText).getText());
        boolean result = actualResult.contains("0 domains search");
        return result;
    }

    public void waitResultText() {
        WebElement button = Driver.getDriver().findElement(resultButton);
        if (button.isEnabled())
            getResultText();
        //   System.out.println(getResultText());
    }
}
       /* WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selected1Checkbox));
        Element.waitEl();*/