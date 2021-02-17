package AppBase;

import PageFactory.SignUpPage;
import PageFactory.StartUpPage;

public class ObjectSource {
	
	public DriverFactory getDriverFactory() {
		return new DriverFactory();
	}
	
	public SeleniumHelper getSeleniumHelper() {
		return new SeleniumHelper();
	}
	
	public StartUpPage getStartUpPage() {
		return new StartUpPage(DriverFactory.getDriver());
	}
	
	public SignUpPage getSignUpPage() {
		return new SignUpPage(DriverFactory.getDriver());
	}
	
}
