package qa.impListeners.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import qa.impListeners.pages.LoginPage;
import qa.impListeners.testNGbase.ProjectSpecificMethods;
import qa.impListeners.utils.MyListener;


public class TC001_CreateLead extends ProjectSpecificMethods{
	
	
	@BeforeTest
	public void setTestProperties()
	{
		testCaseName = "TC001_CreateLead";
		testCaseDescription = "Create a New Lead";
		
		System.out.println("Before Test 1- Currently accessed by thread = "+Thread.currentThread().getName());
	}
	
	@Test//(retryAnalyzer = MyListener.class)
	public void createNewLead()
	{
		
		System.out.println("Test 1- Currently accessed by thread = "+Thread.currentThread().getName());
		
		new LoginPage()
		.enterUsername("demosalesmanager")
		.enterPassword("crmsfa")
		.clickLogin()
		.clickCRMSFA()
		.clickLeadsLink()
		.clickCreateLead()
		.enterCompanyName("CTS")
		.enterFirstName("Hari")
		.enterLastName("Haran")
		.clickCreateLeadButton()
		.fetchLeadId();
		
	}
	

}
