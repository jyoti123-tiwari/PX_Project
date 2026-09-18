package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProposalPage {

    private WebDriver driver;

    // ================= LOCATORS =================

    private By fullName = By.id("proposerName");
    private By email = By.id("proposerEmail");

    // PAN ka actual locator inspect karke replace karna hai
    private By pan = By.id("panNumber");
    private By gender = By.id("proposerGender");


    // ================= CONSTRUCTOR =================

    public ProposalPage(WebDriver driver) {
        this.driver = driver;
    }


    // ================= HELPER METHODS =================

    // Common method for entering text into any input field
    private void enterText(By locator, String value) {

        WebElement element = driver.findElement(locator);

        element.clear();

        element.sendKeys(value);
    }


    // Common method for getting value from any input field
    private String getFieldValue(By locator) {

        return driver.findElement(locator).getAttribute("value");
    }


    // ================= ACTION METHODS =================

    public void enterFullName(String name) {
        enterText(fullName, name);
    }


    public void enterEmail(String email) {
        enterText(this.email, email);
    }


    public String getEmailValue() {
        return getFieldValue(email);
    }


    public void enterPanNumber(String pan) {
        enterText(this.pan, pan);
    }


    public String getPanNumber() {
        return getFieldValue(pan);
    }
    public void selectGender(String genderValue) {

        Select select = new Select(driver.findElement(gender));

        select.selectByVisibleText(genderValue);
    }
    public String getSelectedGender() {

        Select select = new Select(driver.findElement(gender));

        return select.getFirstSelectedOption().getText();
    }
}