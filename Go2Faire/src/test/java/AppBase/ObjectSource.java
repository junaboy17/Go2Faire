package AppBase;

import PageFactory.StartUpPage;

public class ObjectSource {

	public DriverFactory DriverFactor;
	public SeleniumHelper SeleniumHelper;
	public StartUpPage StartUpPage;
	
	public DriverFactory getDriverFactory() {
		return new DriverFactory();
	}
	
	public SeleniumHelper getSeleniumHelper() {
		return new SeleniumHelper();
	}
	
	public StartUpPage getStartUpPage() {
		return new StartUpPage(DriverFactory.getDriver());
	}
	
}
