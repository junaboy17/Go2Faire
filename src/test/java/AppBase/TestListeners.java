package AppBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
		ExtentTest test = extent.createTest("Selenium Test");
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successful<b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		// not implemented
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}
	}

}
