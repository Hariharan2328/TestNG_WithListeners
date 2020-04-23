package qa.impListeners.pages;

import java.util.concurrent.TimeUnit;

import qa.impListeners.base.SeleniumBase;

public class MyHomePage extends SeleniumBase{
	
	MyHomePage()
	{
		if(!getBrowserTitle().startsWith("My Home"))
		{
			System.out.println("Not Landed to My Home page");
			reportStep("This is not a My Home page","fail",true);
		}
	}
	
	

	public MyLeadsPage clickLeadsLink()
	{
		
		click(locateElement("linktext","Leads"),"Leads tab");
		
		waitForBrowserToLoad(30);
		
		return new MyLeadsPage();
		
		
	}

}
