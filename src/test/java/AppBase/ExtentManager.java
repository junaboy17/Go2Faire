package AppBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	ObjectSource source = new ObjectSource();
	
	public String getReportName() {
		String date = source.getSeleniumHelper().dateTimeFileFormat();
		String fileName = "Test-Report- " + date + ".html";
		return fileName;
	}
	
	public ExtentReports createInstance() {
		String fileName = getReportName();
		htmlReporter = new ExtentHtmlReporter("reports/" + fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Go2Faire Report");
		htmlReporter.config().setReportName("Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "Wolvesfield");
		extent.setSystemInfo("Browser", DataSource.browser.baseBrowser);
		extent.attachReporter(htmlReporter);
		
		return extent;
	}
	
}
