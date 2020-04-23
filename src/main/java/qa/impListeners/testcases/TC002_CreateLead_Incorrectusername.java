package qa.impListeners.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import qa.impListeners.pages.LoginPage;
import qa.impListeners.testNGbase.ProjectSpecificMethods;
import qa.impListeners.utils.MyListener;


public class TC002_CreateLead_Incorrectusername extends ProjectSpecificMethods{
	
	
	@BeforeTest
	public void setTestProperties()
	{
		testCaseName = "TC002_CreateLead_Incorrectusername";
		testCaseDescription = "TC002_CreateLead2";
		
		System.out.println("Before Test 2  - Currently accessed by thread = "+Thread.currentThread().getName());
	}
	
	@Test//(retryAnalyzer = MyListener.class)
	public void createNewLead2()
	{
		
		System.out.println("Test 2- Currently accessed by thread = "+Thread.currentThread().getName());
		new LoginPage()
		.enterUsername("demosalesmanag")
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
