package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.policyx.com/health-insurance/buynow/Star-Health-And-Allied-Insurance-Company-Limited.php?key_pid=MTFxRzJQYUhkL2NJRm9TNU1UcUJuZz09");

    }

    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }

    }
}