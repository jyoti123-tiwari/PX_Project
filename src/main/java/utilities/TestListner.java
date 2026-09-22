package utilities;


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
                ((base.BaseTest) testClass).getDriver();

        try {

            Screenshot.captureScreenshot(
                    driver,
                    result.getName()
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}