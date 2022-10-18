package verifywhetherweareabletoaddfunds;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.BaseClass;
import pom.LoginPage;
import util.UtilClass;


public class VerifyUserCanLogin {

	static WebDriver driver;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports reports;
	static ExtentTest extentTest;
	LoginPage lp;
	
	@BeforeClass
	public void beforeClass()
	{
		ExtentHtmlReporter htmlReporter=BaseClass.getHtmlReporter();
		 reports=BaseClass.getExtentReports();
		 extentTest=BaseClass.getExtentTest("verifyUserCanLogin");
		driver=BaseClass.getDriver();
		}
	@BeforeMethod
	public void beforeMethod()
	{
		
		 lp=new LoginPage(driver);
		
	}
	@Test
	public void verifyUserCanLogin() throws IOException, InterruptedException
	{
		lp.enterEmailId();
		lp.enterPassword();
		lp.clickonSubmitButton();
		lp.clickonContinueButton();
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.log(Status.PASS,"Test : " +result.getName());
			
			
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=UtilClass.getScreenshot(driver,result.getName());
			extentTest.log(Status.FAIL,"Test : " +result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP,"Test : " +result.getName());
			
		}
		
	}
	@AfterClass
	public void afterClass()
	{
		reports.flush();
		
		
	}
	
}
