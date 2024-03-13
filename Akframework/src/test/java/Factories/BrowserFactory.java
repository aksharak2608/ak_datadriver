package Factories;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver startBrowser(String browser, String url)
	{
		WebDriver driver = null;
		System.out.println("setting the browser "+browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("setting the url and launching "+url);
			WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 driver.get(url);
		}
		else if(browser=="edge")
		{
			
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
		
		}
		else
		{
			System.out.println("setting the url and launching "+url);
			WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 driver.get(url);
		}
		
		System.out.println(url);
		//driver.get(url);
		System.out.println("url launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	
	
}
