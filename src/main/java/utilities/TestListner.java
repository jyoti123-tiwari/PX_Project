package utilities;
import  base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestListner implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "Test Failed: " +
                        result.getName()
        );

        Object testClass =
                result.getInstance();

        WebDriver driver =
                ((BaseTest) testClass).getDriver();

        try {

            String screenshotPath =
                    Screenshot.captureScreenshot(
                            driver,
                            result.getName()
                    );

            System.out.println(
                    "Screenshot Path: " +
                            screenshotPath
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

