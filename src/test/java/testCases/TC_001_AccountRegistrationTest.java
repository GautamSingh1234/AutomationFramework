package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_account_registration() throws InterruptedException
	{
		
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.clickMyAccount();
		Thread.sleep(3000);
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		Thread.sleep(2000);
		regpage.setFirstName(randomeString().toUpperCase());
		Thread.sleep(3000);
		regpage.setLastName(randomeString().toUpperCase());
		Thread.sleep(4000);
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		Thread.sleep(4500);
		regpage.setTelephone(randomeNumber());
		Thread.sleep(4600);
		String password=randomAlphaNumeric();
		Thread.sleep(5000);
		regpage.setPassword(password);
		Thread.sleep(6000);
		regpage.setConfirmPassword(password);
		Thread.sleep(2000);
		regpage.setPrivacyPolicy();
		Thread.sleep(3000);
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
}








