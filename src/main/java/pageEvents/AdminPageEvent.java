package pageEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.AdminPageElement;
import utility.Data_repository;
import org.testng.Assert;
import utility.listnerTest;

public class AdminPageEvent {
    WebDriver driver;
    public AdminPageEvent(WebDriver driver)
    {
        this.driver=driver;
    }


    public static void adminMenu() throws InterruptedException {
        Thread.sleep(2000);
        AdminPageElement.admin.click();
        Thread.sleep(2000);
        String text=AdminPageElement.admintitle.getText();
        Assert.assertEquals(text,"User Management");


    }
    public static void userName()
    {
        AdminPageElement.username.sendKeys(Data_repository.username_value);
    }

    public static void adminSearchbtn()
    {
        AdminPageElement.searchbtn.click();
    }
}
