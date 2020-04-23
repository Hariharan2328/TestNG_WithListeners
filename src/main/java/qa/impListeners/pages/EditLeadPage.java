package qa.impListeners.pages;

import java.util.concurrent.TimeUnit;

import qa.impListeners.testNGbase.ProjectSpecificMethods;


public class EditLeadPage extends ProjectSpecificMethods{
	
	
	public EditLeadPage changeCompanyName(String CompanyName)
	{
		
		clearAndenterText(locateElement("xpath","//input[@id='updateLeadForm_companyName']"), CompanyName);
			
		return this;
	}
	
	public ViewLeadsPage clickUpdateButton()
	{
		click(locateElement("xpath","//input[@class='smallSubmit' and @value='Update']"),"Update button");
		waitForBrowserToLoad(30);
		
		//rgerger
		return new ViewLeadsPage();
	}
	
	

}
