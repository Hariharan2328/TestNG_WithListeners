package qa.impListeners.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import qa.impListeners.pages.LoginPage;
import qa.impListeners.testNGbase.ProjectSpecificMethods;
import qa.impListeners.utils.MyListener;


public class TC003_EditLead extends ProjectSpecificMethods{
	
	
	@BeforeTest
	public void setTestProperties()
	{
		testCaseName = "TC003_EditLead";
		testCaseDescription = "Edit the created Lead";
		
		System.out.println("Before Test 3- Currently accessed by thread = "+Thread.currentThread().getName());
	}
	
	@Test(dependsOnMethods={"qa.impListeners.testcases.TC001_CreateLead.createNewLead"})
	public void editLead() throws InterruptedException
	{
		
		System.out.println("Test 3- Currently accessed by thread = "+Thread.currentThread().getName());
		
		new LoginPage()
		.enterUsername("demosalesmanager")
		.enterPassword("crmsfa")
		.clickLogin()
		.clickCRMSFA()
		.clickLeadsLink()
		.clickFindLead()
		.enterLeadID(intLeadID)
		.clickFindLeadsButton()
		.clickLeadIDLink_In_SearchResult()
		.clickEditButton()
		.changeCompanyName("goojle")
		.clickUpdateButton()
		.verifyEditedCompanyName("goojle");
		
		
		
		
	}
	

}
