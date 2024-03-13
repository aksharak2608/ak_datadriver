package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.helper;

public class LoginPage {
	
	
	By submit=By.xpath("//button[@type='submit']");
	By username1=By.xpath("//input[@name='username']");
	By passcode1=By.xpath("//input[@name='password']");
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		System.out.println("login page driver instantiated"+driver.getTitle());
	}
	public void enterusername(String user)
	{
		WebElement ele=driver.findElement(username1);
		//driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		helper.WaitForElementandentertext(ele, driver, user);
		
	}
	
	public void enterpassword(String passcode)
	{
		helper.WaitForElementandentertext(passcode1, driver, passcode);
	}
	public WebDriver performlogin()
	{
		helper.WaitForElementClickable(submit, driver);
		return driver;
	}
}
