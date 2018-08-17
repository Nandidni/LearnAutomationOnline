package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.contactPage;

public class VerifyContactPageWithRepots {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup()
	{
		reports =new ExtentReports(".\\Reports\\contactPageReports.html",true);
		logger=reports.startTest("verify Test login");
		
		driver=BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getconfig().getApplicationurl());
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testHomePage()
	{
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String Title=home.getApplicationTitle();
		
		Assert.assertTrue(Title.contains("Demo Store"));
		
		logger.log(LogStatus.PASS, "Home page loaded and verified");
		home.clickoncontactlink();
		
		logger.log(LogStatus.INFO, "click on contact Page");
		
		contactPage contact=PageFactory.initElements(driver, contactPage.class);
		
		contact.contacus(DataProviderFactory.getexcel().getData(0, 0, 0), DataProviderFactory.getexcel().getData(0, 0, 1));
		
		logger.log(LogStatus.INFO, "login sucess");
		
		contact.verifysupport();
		
		logger.log(LogStatus.PASS, "support link is present");
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		reports.endTest(logger);
		reports.flush();
	}
	

}
