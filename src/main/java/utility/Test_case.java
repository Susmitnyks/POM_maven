package utility;

import basePage.Basetest;
import com.aventstack.extentreports.Status;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.TestResult;
import pageEvents.AdminPageEvent;
import pageObject.AdminPageElement;
import org.testng.asserts.SoftAssert;
import utility.listnerTest;

import java.util.Arrays;

public class Test_case extends Basetest{

        @AfterSuite
        void tearDown() {
                extent.flush();
                sendEmail();
        }

        @BeforeTest
        void Login() throws InterruptedException {
                start();
        }
        /*@BeforeTest
        void start() throws InterruptedException {
                driver=new ChromeDriver();
                SoftAssert softAssert = new SoftAssert();
                driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                driver.manage().window().maximize();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
                AdminPageElement ap=new AdminPageElement(driver);
                //listnerTest tp=new listnerTest(driver);
                softAssert.assertEquals("OrangeHRM",driver.getTitle());
                initializeReport();
                // Soft assert hence test case getting pass
                softAssert.assertAll();

        }*/
        @AfterTest
        void close()  {
                driver.close();
        }


        @Test
        void adminclick(){
                //softAssert.assertAll();
                try {
                        AdminPageEvent.adminMenu();
                        test = extent.createTest("ADMIN CLICK","Verify Admin Menu Click action");
                        test.log(Status.PASS,"Clicking on admin menu");
                        test.assignCategory("P0");
                } catch (AssertionError|Exception e) {
                        test = extent.createTest("ADMIN CLICK","ADMIN CLICK ACTION");
                        test.log(Status.FAIL, e.getMessage());
                        test.assignCategory("P0");

                }

        }

        @Test
        void adminpage() throws InterruptedException {

                try {
                        AdminPageEvent.userName();
                        AdminPageEvent.adminSearchbtn();
                        test = extent.createTest("ADMIN SEARCH","ADMIN PAGE SEARCH");
                        test.log(Status.PASS,"Clicking on search button");
                        test.assignCategory("P0");
                } catch (Exception e) {
                        test = extent.createTest("ADMIN SEARCH","ADMIN PAGE SEARCH");
                        test.log(Status.FAIL, e.getMessage());
                        test.assignCategory("P0");
                        throw new RuntimeException(e);
                }


        }

        /*@AfterMethod
        public void getResult(ITestResult result) {
                if(result.getStatus() == ITestResult.FAILURE) {
                        test.log(Status.FAIL, result.getTestName());
                        test.log(Status.FAIL,result.getThrowable());
                }
                else if(result.getStatus() == ITestResult.SUCCESS) {
                        test.log(Status.PASS, result.getTestName());
                }
                else {
                        test.log(Status.SKIP, result.getTestName());
                }
        }*/
    }

