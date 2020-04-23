package qa.impListeners.pages;

import org.openqa.selenium.WebElement;

import qa.impListeners.base.SeleniumBase;


public class LoginPage extends SeleniumBase{
	
	public LoginPage enterUsername(String uname) {
		
		clearAndenterText(locateElement("id", "username"),uname);
		
		return this;
	}

	public LoginPage enterPassword(String pwd) {
		
		clearAndenterText(locateElement("id", "password"),pwd);
		return this;
	}
	
	
	public HomePage clickLogin() {
		
		click(locateElement("classname", "decorativeSubmit"),"Login button");
		
		return new HomePage();
	}
	
}
