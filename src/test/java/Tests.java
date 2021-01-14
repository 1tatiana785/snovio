import Core.Constants;
import Core.Driver;
import Core.Listener;
import Pages.FindEmails;
import Pages.LogIn;
import Pages.Main;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})

public class Tests {

    // allure serve /home/tatiana/_Projects/snovio/allure-results
    Main mainPage = new Main();
    LogIn logInPage = new LogIn();
    FindEmails findEmails = new FindEmails();

    @BeforeTest
    public void login() {
        Driver.getDriver().get(Constants.url);
        logInPage.logIn();
        mainPage.clickClosedButton();
    }

    @Test(priority = 0, description = "work with domains")
    public void test() {
        mainPage.selectMenu();
        findEmails.waitBulkDomainSearchPage();
        findEmails.clickDomainNamesButton();
        findEmails.chooseFile(Constants.File1);
        Assert.assertEquals(findEmails.checkFile(), "File type must be CSV, XLS, XLSX or TXT");
        System.out.println("Invalid file type. The text is shown " + "(" + findEmails.checkFile() + ")");
        findEmails.chooseFile(Constants.File2);
        findEmails.clickEmailsOnlyButton();
        findEmails.uncheckCheckbox1();
        findEmails.uncheckCheckbox2();
        findEmails.uncheckCheckbox3();
        findEmails.clickStartSearchButton();
        findEmails.waitCheckType();
        Assert.assertEquals(findEmails.checkType(), "Error");
        System.out.println("Does not upload type. The text is shown" + "(" + findEmails.checkType() + ")");
        findEmails.clickOkButton();
        findEmails.checkCheckbox1();
        findEmails.clickStartSearchButton();
        findEmails.waitResultText();
        Assert.assertEquals(findEmails.getResultText(), true);
    }
}