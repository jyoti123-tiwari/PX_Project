package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir")
                + "/test-output/ExtentReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(path);

        reporter.config().setReportName("PolicyX Automation Report");
        reporter.config().setDocumentTitle("PolicyX Test Execution Report");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Jyoti");
        extent.setSystemInfo("Project", "PolicyX");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");

        return extent;
    }
}
