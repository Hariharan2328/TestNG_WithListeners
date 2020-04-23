package qa.impListeners.pages;

import java.util.concurrent.TimeUnit;

import qa.impListeners.base.SeleniumBase;



public class CreateLeadsPage extends SeleniumBase{
	
	CreateLeadsPage()
	{
		if(!getBrowserTitle().startsWith("Create Lead"))
		{
			System.out.println("Not Landed to Create Lead page");
			reportStep("This is not a Create Lead page","fail",true);
		}
	}
	
	public CreateLeadsPage enterCompanyName(String cname)
	{
		
		clearAndenterText(locateElement("id","createLeadForm_companyName"), cname);
		return this;
	}


	public CreateLeadsPage enterFirstName(String fname)
	{
		
		clearAndenterText(locateElement("id","createLeadForm_firstName"), fname);
		return this;
	}
	
	
	public CreateLeadsPage enterLastName(String lname)
	{
		
		clearAndenterText(locateElement("id","createLeadForm_lastName"), lname);
		return this;
	}
	
	
	public ViewLeadsPage clickCreateLeadButton()
	{
		
		click(locateElement("xpath","//input[@name = 'submitButton']"),"Click button");
		waitForBrowserToLoad(30);
		
		return new ViewLeadsPage();
	}

}
