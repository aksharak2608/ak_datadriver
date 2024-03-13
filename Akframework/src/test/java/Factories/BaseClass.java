package Factories;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.helper;

public class BaseClass {
	public static ExtentReports Reports;
	public static ExtentTest Test;
	public static  WebDriver driver;
	public static String syspath=System.getProperty("user.dir");
	
	public String namegeneration()
	{
		Date d= new Date();
		DateFormat df= new SimpleDateFormat("YY_MM_dd_HH_MM_SS");
		//String dateformate=df.format(d);
		
		return df.format(d);
		
		
	}
	@BeforeSuite
	public void statusReport()
	{
		System.out.println("starting before suite");
		
		ExtentSparkReporter spark= new ExtentSparkReporter(syspath+"\\reports\\Projectreport"+namegeneration()+".html");
		Reports= new ExtentReports();
		Reports.attachReporter(spark);
		
	}
	
	@AfterMethod
	public void Resultreport(ITestResult r)
	{
System.out.println("starting after method");
		  int status=r.getStatus();
		  if(status==ITestResult.SUCCESS)
		  {
			  try {
				Test.log(Status.PASS, "Test passed",
				  MediaEntityBuilder.createScreenCaptureFromPath(helper.screenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  System.out.println("sucess");
		  }
		  else  if(status==ITestResult.FAILURE)
		  {
			  try {
				Test.log(Status.FAIL, "Test Failed",
						  MediaEntityBuilder.createScreenCaptureFromPath(helper.screenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					  
					  System.out.println("Failed");
			  System.out.println("Exception"+r.getThrowable().getMessage());
		  }
		  else  if(status==ITestResult.SKIP)
		  {
			  Test.log(Status.SKIP, "Test Skipped");
			  System.out.println("Skip");
		  }
		  Reports.flush();
	  }
	@BeforeClass
	public void startSession()
	{
		System.out.println("staring the before class");
		String browser=Dataprovider.ReadProperties("browser");

		String url=Dataprovider.ReadProperties("url");
		System.out.println("browser is "+browser+" url is "+url);
		driver=BrowserFactory.startBrowser(browser, url);
		
	}
	@AfterClass
	public void EndSession()
	{
		driver.close();
	}

}
