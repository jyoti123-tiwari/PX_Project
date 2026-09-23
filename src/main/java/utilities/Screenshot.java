package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

        import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void captureScreenshot(
            WebDriver driver,
            String testName) throws IOException {

        try {

            File folder = new File("target/screenshot");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            TakesScreenshot ts =
                    (TakesScreenshot) driver;

            File source =
                    ts.getScreenshotAs(OutputType.FILE);

            File destination =
                    new File(folder, testName + ".png");

            FileUtils.copyFile(source, destination);

            System.out.println(
                    "Screenshot saved at: "
                            + destination.getAbsolutePath()
            );

        } catch (Exception e) {

            System.out.println(
                    "Screenshot capture failed: "
                            + e.getMessage()
            );

            e.printStackTrace();
        }
    }
}