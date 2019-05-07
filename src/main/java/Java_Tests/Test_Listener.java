package Java_Tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_Listener extends Test_Prepare implements ITestListener {

    @Attachment(value = "{0}", type = "image/png")
    private byte[] screenCreate(String name) {
        return  ((TakesScreenshot)(new Augmenter().augment(driver)))
                     .getScreenshotAs(OutputType.BYTES);
    }

    private void screen(String mes) {
        Date dat = new Date();
        DateFormat formatForDateNow = new SimpleDateFormat("dd-mm-yyyy hh.mm.ss");
        screenCreate(mes + " " + formatForDateNow.format(dat));
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        screen("Fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        screen("Skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        screen("Almost Fail");
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
