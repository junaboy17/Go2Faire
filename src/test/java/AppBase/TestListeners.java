package AppBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListeners implements ITestListener{
	ExtentManager manager = new ExtentManager();
	ExtentReports extent = manager.createInstance();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ObjectSource source = new ObjectSource();
	String methodName;

	public void onTestStart(ITestResult result) {
		methodName = result.getMethod().getMethodName();
		ExtentTest test = extent.createTest(result.getClass().getSimpleName() + " : " + methodName);
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		methodName = result.getMethod().getMethodName();
		String logText = "<b>Test Method " + methodName + " Successful<b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		methodName = result.getMethod().getMethodName();
		String screenShotName = null;
		String path = System.getProperty("user.dir") + "/build/Screenshots/" + screenShotName;
		if(ITestResult.FAILURE == result.getStatus()) {
			
			String logText = "<b>Test Method " + methodName + " Failed</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			extentTest.get().log(Status.FAIL, m);
			
			String exceptionMessage = result.getThrowable().getLocalizedMessage();
			extentTest.get().fail("<details><summary><b> <font color = red> Exception occured:" 
									+ "<details><summary><b>" + exceptionMessage.replace(",", "<br>") + "</details> \n");
			
			try {
				screenShotName = source.getSeleniumHelper().takeScreenShot(methodName);
			}catch(Exception e) {
				SeleniumHelper.log.error("Error. Unable to take screenshot for the case: " + methodName);
			}
			
			try {
				extentTest.get().fail("<b><font color=red>" + "Screenshot of Failed Page" + "</font></b>", 
										MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}catch (Exception e) {
				SeleniumHelper.log.error("Error. Unable attach screenshot to report: " + methodName);
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		methodName = result.getMethod().getMethodName();
		String logText = "<b>Test Method " + methodName + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.PURPLE);
		extentTest.get().log(Status.SKIP, m);
		
		String exceptionMessage = result.getThrowable().getLocalizedMessage();
		extentTest.get().skip("<details><summary><b> <font color = blue> Exception occured:" 
								+ "<details><summary><b>" + exceptionMessage.replace(",", "<br>") + "</details> \n");
	}

	public void onFinish(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}
	}

}
