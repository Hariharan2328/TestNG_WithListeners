package qa.impListeners.pages;

import java.util.concurrent.TimeUnit;


import qa.impListeners.base.SeleniumBase;


public class MyLeadsPage extends SeleniumBase{
	
	MyLeadsPage()
	{
		if(!getBrowserTitle().startsWith("My Leads"))
		{
			System.out.println("Not Landed to My Leads page");
			reportStep("This is not a My Leads page","fail",true);
		}
	}
	
	
	public CreateLeadsPage clickCreateLead()
	{
		click(locateElement("linktext","Create Lead"),"Create Lead");
		
		waitForBrowserToLoad(20);
				
		return new CreateLeadsPage();
	}
	
	
	public FindLeadsPage clickFindLead()
	{
		
		click(locateElement("linktext","Find Leads"), "Find Leads");
		
		waitForBrowserToLoad(30);
		
		return new FindLeadsPage();
	}
	
	

}
