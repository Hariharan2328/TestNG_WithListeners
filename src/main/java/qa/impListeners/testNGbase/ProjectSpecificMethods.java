package qa.impListeners.testNGbase;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import qa.impListeners.base.SeleniumBase;

public class ProjectSpecificMethods extends SeleniumBase{
	
	@BeforeMethod
	public void openBrowser()
	{
		createNodeForTheTest();
		startApp("chrome","http://leaftaps.com/opentaps");
		
	}
	
	@AfterMethod
	public void close()
	{
		closeBrowser();
	}

}
