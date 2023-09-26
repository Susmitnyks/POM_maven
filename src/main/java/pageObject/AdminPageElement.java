package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPageElement {
 public AdminPageElement(WebDriver driver)
 {
  this.driver=driver;
  PageFactory.initElements(driver,this);
 }

 WebDriver driver;

 @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span")
 public static WebElement admintitle;
 @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
 public static WebElement admin;
 @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
 public static WebElement  username;

 @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
 public static WebElement  searchbtn;




}
