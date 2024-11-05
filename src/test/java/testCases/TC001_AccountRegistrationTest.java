package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registrartion()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  *****");
		try
		{
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link  ");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link  ");
		
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details... ");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setemail(randomeString()+"@gmail.com");  // randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumberic();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating confirmation message..");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
				{
			             Assert.assertTrue(true);
				}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} 
		catch(Exception e)
		{
			//logger.error("Test failed..");
			//logger.debug("Debug logs..");
			Assert.fail();
		}
		
		logger.info("****Finished TC001_AccountRegistrationTest ***");
	}
	
	

}
