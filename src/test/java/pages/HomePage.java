package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	public HomePage( WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	@FindBy(xpath="//a[text()='Features']") WebElement featureslink;
	
	@FindBy(xpath="//a[text()='Pricing']") WebElement pricinglink;
	
	@FindBy(xpath="//a[text()='Contact Us']") WebElement contactlink;
	
	@FindBy(xpath="//a[text()='View Demo']") WebElement viewtlink;
	
	public void clickonfeatureslink()
	{
		featureslink.click();
	}
	
	public void clickonpricinglink()
	{
		pricinglink.click();
	}
	public void clickoncontactlink()
	{
		contactlink.click();
	}
	public void clickonviewtlink()
	{
		viewtlink.click();
	}
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
	
	
}
