package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class helper {
	public static  WebDriver driver;
	
	public static String unicvalue()
	{
		Date obj= new Date();
		String fname=	obj.toString().replace(" ", "_").replace(":", "_");
			System.out.println(fname);
			return fname;
	
	}
	public static WebDriver WaitForElementClickable(WebElement ele, WebDriver driver)
	{

WebDriverWait wait= new WebDriverWait(driver, Duration.ofMinutes(2));

wait.until(ExpectedConditions.elementToBeClickable(ele));
ele.click();
	return driver;

	}
	public static WebDriver WaitForElementClickable(By ele, WebDriver driver)
	{

WebDriverWait wait= new WebDriverWait(driver, Duration.ofMinutes(2));

wait.until(ExpectedConditions.elementToBeClickable(ele));
driver.findElement(ele).click();
	return driver;

	}
	public static WebDriver WaitForElementandentertext(By ele, WebDriver driver, String input)
	{

WebDriverWait wait= new WebDriverWait(driver, Duration.ofMinutes(2));

wait.until(ExpectedConditions.elementToBeClickable(ele));
//ele.sendKeys(input);
driver.findElement(ele).sendKeys(input);
return driver;

	}
	public static WebDriver WaitForElementandentertext(WebElement ele, WebDriver driver, String input)
	{

WebDriverWait wait= new WebDriverWait(driver, Duration.ofMinutes(2));

wait.until(ExpectedConditions.elementToBeClickable(ele));
//ele.sendKeys(input);
ele.sendKeys(input);
return driver;

	}
	public static String screenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot s= ((TakesScreenshot)driver);
		File src=s.getScreenshotAs(OutputType.FILE);
		String des=System.getProperty("user.dir")+"//screenshots//"+unicvalue()+"abc.png";
		File dest= new File(des);
		FileHandler.copy(src, dest);
		return des;
		
	}
	
}
