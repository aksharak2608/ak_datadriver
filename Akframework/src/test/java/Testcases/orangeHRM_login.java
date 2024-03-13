package Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Factories.BaseClass;
import Factories.Dataprovider;
import pages.LoginPage;

public class orangeHRM_login extends BaseClass {

	
	@Test(priority=1, groups={"reg"})
	public void logintestdata() 
	{
		Test= Reports.createTest("validating the db credentials","testing the login for multiple usersonly credential");
		
		for(int i=1;i<=2;i++)
		{
		String username=Dataprovider.ReadExcel("credentials", i, 0);
		String passcode=Dataprovider.ReadExcel("credentials", i, 1);
		
		Assert.assertEquals("admin", username);
		Assert.assertEquals("admin123", passcode);
		
		
		}
	}
	@Test(groups={"reg"})
	public void logintoorange()
	{
		
		LoginPage lp;
		
		//Test= Reports.createTest("orange hrm login","testing the login for multiple users");
		
		lp=new LoginPage(driver);//PageFactory.initElements(driver, LoginPage.class);
		lp.enterusername(Dataprovider.ReadExcel("credentials", 1, 0));
		lp.enterpassword(Dataprovider.ReadExcel("credentials", 1, 1));
		Assert.assertEquals("admin", Dataprovider.ReadExcel("credentials", 1, 0));
		Assert.assertEquals("admin123", Dataprovider.ReadExcel("credentials", 1, 1));
		driver=lp.performlogin();
	
	}
	@Test(groups={"sanity"})
	public void logintoorange2()
	{
		
		LoginPage lp;
		
		//Test= Reports.createTest("orange hrm login for 2nd set","testing the login for multiple users");
		
		lp=new LoginPage(driver);//PageFactory.initElements(driver, LoginPage.class);
		lp.enterusername(Dataprovider.ReadExcel("credentials", 2, 0));
		lp.enterpassword(Dataprovider.ReadExcel("credentials", 2, 1));
		Assert.assertEquals("admin", Dataprovider.ReadExcel("credentials", 1, 0));
		Assert.assertEquals("admin123", Dataprovider.ReadExcel("credentials", 1, 1));
		driver=lp.performlogin();
	
	}
	
}
