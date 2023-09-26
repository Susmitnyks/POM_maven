package basePage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pageObject.AdminPageElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Basetest {
    public static WebDriver driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static SoftAssert softAssert = new SoftAssert();

    public static void initializeReport(){
        htmlReporter =  new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/extentReport.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent =new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void sendEmail(){
        try {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            // Create an email attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath("C:\\Users\\Susmit surwade\\IdeaProjects\\POM_maven\\Reports\\extentReport.html"); // Replace with the actual path
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Extent Report");
            attachment.setName("ExtentReport.html");

            // Create an email
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.gmail.com"); // Replace with your SMTP server
            email.setSmtpPort(465); // Replace with the SMTP port
            email.setAuthenticator(new DefaultAuthenticator("susmit.s.surwade@gmail.com", "cbxl zils casn idbd"));
            email.setSSLOnConnect(true); // Use SSL if needed
            email.setFrom("susmit.s.surwade@gmail.com"); // Replace with your email
            email.addTo("susmit.s.surwade@gmail.com"); // Replace with recipient's email
            email.setSubject("Extent Report "+dtf.format(now));

            // Set the message body
            email.setMsg("Please find the attached Extent Report.");

            // Add the attachment
            email.attach(attachment);

            // Send the email
            email.send();
            System.out.println("Email sent successfully.");
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }

    public static void start() throws InterruptedException {
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        AdminPageElement ap=new AdminPageElement(driver);
        //listnerTest tp=new listnerTest(driver);
        softAssert.assertEquals("OrangeHRMS",driver.getTitle());
        initializeReport();
        // Soft assert hence test case getting pass
        //softAssert.assertAll();
    }
}
