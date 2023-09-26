package utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class listnerTest  implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot scrShot =((TakesScreenshot)Test_case.driver);
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
        File dest= new File("./Screenshots/screenshot_"+filename+".png");

        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
