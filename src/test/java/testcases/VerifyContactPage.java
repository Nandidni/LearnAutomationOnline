package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.contactPage;

public class VerifyContactPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getconfig().getApplicationurl());
		
	}
	
	@Test
	public void testHomePage()
	{
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String Title=home.getApplicationTitle();
		
		Assert.assertTrue(Title.contains("Demo Store"));
		
		home.clickoncontactlink();
		
		contactPage contact=PageFactory.initElements(driver, contactPage.class);
		
		contact.contacus(DataProviderFactory.getexcel().getData(0, 0, 0), DataProviderFactory.getexcel().getData(0, 0, 1));
		
		contact.verifysupport();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}
	

}
