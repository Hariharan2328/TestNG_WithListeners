package qa.impListeners.pages;

import java.util.concurrent.TimeUnit;

import qa.impListeners.base.SeleniumBase;


public class HomePage extends SeleniumBase{
	
	HomePage()
	{
		
		if(!getBrowserTitle().startsWith("Leaftaps - TestLeaf Automation Platform"))
		{
			System.out.println("Not Landed to Home page");
			reportStep("This is not a Home page","fail",true);
		}
	}
	
	public MyHomePage clickCRMSFA()
	{
		
		
		click(locateElement("linktext","CRM/SFA"),"CRM SFA link");
		
		waitForBrowserToLoad(10);
			
		return new MyHomePage();
	}

}
