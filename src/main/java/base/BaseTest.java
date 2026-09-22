package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.policyx.com/health-insurance/buynow/Star-Health-And-Allied-Insurance-Company-Limited.php?key_pid=MTFxRzJQYUhkL2NJRm9TNU1UcUJuZz09");

    }

    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }

    }
}