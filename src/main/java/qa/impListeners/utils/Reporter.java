package qa.impListeners.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter extends DriverInstance{
	
	private static ThreadLocal<ExtentTest> test = new ThreadLocal();
	private static ThreadLocal<ExtentTest> node = new ThreadLocal();
	
	static ExtentReports extent;
	
	public String testCaseName, testCaseDescription;
	
	@BeforeSuite
	public synchronized void createReporter()
	{
		File f = new File("./reports");
		if(!f.exists())
		{
			f.mkdir();
		}
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/output.html");
		reporter.config().setDocumentTitle("Listener Implementation");
		reporter.config().setReportName("Leaftaps Reports");
		
		reporter.setAppendExisting(false);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@BeforeClass
	public synchronized void createTestInReporter()
	{
		ExtentTest localTest;
		localTest = extent.createTest(testCaseName,testCaseDescription);
		test.set(localTest);
		
		System.out.println("Before class - Currently accessed by thread = "+Thread.currentThread().getName());
		
	}
	
	
	public synchronized void createNodeForTheTest()
	{
		ExtentTest localNode = test.get().createNode(testCaseName);
		node.set(localNode);
	}
	
	public String takeSnap()
	{
		String randomNumber ="";
		
		Date currDate = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		
		randomNumber = formatter.format(currDate);
		
		try {
			FileUtils.copyFile(getDriver().getScreenshotAs(OutputType.FILE), new File("./reports/screenshots/"+randomNumber+".jpg"));
		}catch (IOException e) {
			
		}
		
		return randomNumber;
	}
	
	public void reportStep(String desc, String status, boolean screenshot)
	{
		synchronized(node)
		{
			System.out.println(desc+"-"+status);
			System.out.println("Report step - Currently accessed by thread = "+Thread.currentThread().getName());
			String fileName;
			MediaEntityModelProvider img = null;
			
			if(screenshot & !status.equalsIgnoreCase("INFO")) 
			{
				fileName = takeSnap();
				
				try {
					img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/screenshots/"+fileName+".jpg").build();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(status.equalsIgnoreCase("PASS"))
			{
				node.get().pass(desc, img);
			}
			else if(status.equalsIgnoreCase("Fail"))
			{
				node.get().fail(desc, img);
				throw new RuntimeException();
			}
		}
		
	}
	
	
	@AfterSuite
	public synchronized void closeReporter()
	{
		extent.flush();
	}

}
