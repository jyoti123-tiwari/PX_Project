package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ProposalPage;
import utilities.ExtentReportListener;
import utilities.TestListner;

@Listeners(ExtentReportListener.class)
public class ProposalFormTest extends BaseTest {

    @BeforeMethod
    public void startBrowser() {
        setup();
    }

    @Test
    public void verifyProposalPageTitle() {

        String actualTitle = driver.getTitle();

        System.out.println("Page Title : " + actualTitle);

        Assert.assertTrue(actualTitle.contains("PolicyXy: Compare Insurance Quotes"));

    }
    @Test
    public void enterNameTest() {
        ProposalPage proposal = new ProposalPage(driver);
        proposal.enterFullName("Jyoti Tiwari");
    }
    @Test
    public void verifyEmail() {

        ProposalPage proposal = new ProposalPage(driver);

        proposal.enterEmail("jyoti@gmail.com");

        String actualEmail = proposal.getEmailValue();

        Assert.assertEquals(actualEmail, "jyoti@gmailt.com");
    }
    @Test
    public void verifyGender(){
        ProposalPage proposal = new ProposalPage(driver);
        proposal.enterPanNumber("CBUPT1558B");
        proposal.selectGender("Female");
        String pan=proposal.getPanNumber();
        Assert.assertEquals(pan,"CBUPT1558B");
    }

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }

}
