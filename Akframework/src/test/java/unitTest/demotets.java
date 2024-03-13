package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Factories.BaseClass;
import Factories.BrowserFactory;
import Factories.Dataprovider;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.homepage;
import utility.helper;

public class demotets  {

	
	@Test
	public void te()
	{
		//WebDriver driver=helper.browserSetup("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginPage lp= new LoginPage(driver);
		
		lp.enterusername("admin");
		lp.enterpassword("admin123");
		driver=lp.performlogin();
		homepage hp=new homepage(driver);
		hp.ClickMYinfo();
		//driver.quit();
	}
	

	@Test
	public void tepagefactory()
	{WebDriver driver = null;
		LoginPage lp= //new LoginPage(driver);
		PageFactory.initElements(driver, LoginPage.class);
		lp.enterusername("admin");
		lp.enterpassword("admin123");
		driver=lp.performlogin();
		homepage hp=PageFactory.initElements(driver, homepage.class);
				//new homepage(driver);
		hp.ClickMYinfo();
		//driver.quit();
	}
	
	
@Test
public void tets() throws IOException

	{
		System.out.println("staring the before class");
		String browser=Dataprovider.ReadProperties("browser");
		File src = new File(BaseClass.syspath+"\\testdata\\config.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		String browser1=(String)pro.get("url");
		
		String url=Dataprovider.ReadProperties("url").toString();
		System.out.println("browser is "+browser+" url is "+url);
		System.out.println(url);
		String b="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", url);
		//assert.assertEquals(url,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	//	driver=BrowserFactory.startBrowser(browser, url);
		//WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "D:\\EAI\\workspace\\Ak_java\\webdriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get(browser1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

}
}