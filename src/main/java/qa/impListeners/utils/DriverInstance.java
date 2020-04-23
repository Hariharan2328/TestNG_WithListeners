package qa.impListeners.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInstance {
	
	private static ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal();
	private static ThreadLocal<WebDriverWait> wait = new ThreadLocal();
	
	public void setDriver(String browser)
	{
		if(browser.equalsIgnoreCase("CHROME"))
		{
			remoteWebDriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			remoteWebDriver.set(new InternetExplorerDriver());
		}
	}
	
	
	public RemoteWebDriver getDriver()
	{
		
		return remoteWebDriver.get();
	}
	
	
	public void setWait()
	{
		wait.set(new WebDriverWait(getDriver(),5));
	}
	
	public WebDriverWait getWait() {
		return wait.get();
	}
	

}
