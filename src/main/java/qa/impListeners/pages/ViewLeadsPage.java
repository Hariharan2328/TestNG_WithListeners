package qa.impListeners.pages;


import qa.impListeners.base.SeleniumBase;

public class ViewLeadsPage extends SeleniumBase{
	
	public ViewLeadsPage()
	{
		if(!getBrowserTitle().startsWith("View Lead"))
		{
			System.out.println("Not Landed to View Lead page");
			reportStep("This is not a View Lead page","fail",true);
		}
	}
	
	public void fetchLeadId()
	{
		String temp = getElementText(locateElement("id","viewLead_companyName_sp"), "Company name");
		
		temp = temp.replaceAll("[\\D]", "");
		intLeadID = Integer.parseInt(temp);
		System.out.println("Successfully created Lead - "+intLeadID);

	}
	
	
	public EditLeadPage clickEditButton()
	{
		
		click(locateElement("linktext","Edit"),"Edit link");
		
		waitForBrowserToLoad(30);
		
		return new EditLeadPage();
	}
	
	public MyLeadsPage clickDeleteButton()
	{
		//driver.findElementByLinkText("Delete").click();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return new MyLeadsPage();
	}
	
	
	public ViewLeadsPage verifyEditedCompanyName(String companyName)
	{
		String strCompanyname = getElementText(locateElement("xpath","//span[@id='viewLead_companyName_sp']"), "View Lead");
		
		if(strCompanyname.contains(companyName)) 
		
		{
			System.out.println("Edit done successfully");
		}
		
		
		return this;
	
	}

}
