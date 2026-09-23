package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;
import utilities.Screenshot;

public class ExtentReportListener implements ITestListener {

    ExtentReports extent =
            ExtentReportManager.getReportObject();

    ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod().getMethodName()
                );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail("Test Failed");

        test.get().fail(result.getThrowable());

        Object testClass =
                result.getInstance();

        WebDriver driver =
                ((base.BaseTest) testClass).getDriver();

        try {

            String screenshotPath =
                    Screenshot.captureScreenshot(
                            driver,
                            result.getName()
                    );

            if (screenshotPath != null) {

                test.get().addScreenCaptureFromPath(
                        screenshotPath
                );
            }

        } catch (Exception e) {

            test.get().warning(
                    "Unable to attach screenshot: "
                            + e.getMessage()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
