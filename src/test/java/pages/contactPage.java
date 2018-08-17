package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contactPage {

	WebDriver driver;

	public contactPage(WebDriver driver1) {
		this.driver = driver1;
	}

	@FindBy(name = "your-name")
	WebElement username;

	@FindBy(name = "your-email")
	WebElement email;

	@FindBy(xpath = "//input[@value='Send']")
	WebElement submit;
	
	By support=By.xpath("//a[@class='member-button support-forum']");

	public void contacus(String name, String mail) {
		username.sendKeys(name);
		email.sendKeys(mail);
		submit.click();
		
	}
	public void verifysupport()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(support));
		
	}

}
