package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.helper;

public class homepage {
	public WebDriver driver;

	By myinfoby=By.xpath("//*[text()='My Info']");

	public homepage(WebDriver driver){
		
		
		this.driver=driver;
		
	}
	
	public WebDriver ClickMYinfo()
	{
		WebElement myinfo=driver.findElement(myinfoby);
		helper.WaitForElementClickable(myinfo, driver);
		
		return driver;
		
	}
	

}
