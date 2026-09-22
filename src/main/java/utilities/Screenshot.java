package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

        import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) throws IOException {

        TakesScreenshot ts =
                (TakesScreenshot) driver;

        File source =
                ts.getScreenshotAs(OutputType.FILE);

        String path =
                "target/screenshot/" + testName + ".png";

        File destination =
                new File(path);

        FileUtils.copyFile(source, destination);

        return path;
    }
}