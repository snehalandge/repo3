package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
   static WebDriver driver;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports reports;
	static ExtentTest extentTest;
	public static WebDriver getDriver()
	{
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		return driver;
		
		
	}
	public static ExtentHtmlReporter  getHtmlReporter()
	{
		if(htmlReporter==null)
		{
			 htmlReporter=new ExtentHtmlReporter("reports.html");
			
			
		}
		return htmlReporter;
		
		
	}
	public static ExtentReports getExtentReports()
	{
		if(reports==null)
		{
			 reports=new ExtentReports();
			 reports.attachReporter(htmlReporter);
		}
		
		return reports;
		
	}
	public static ExtentTest getExtentTest(String testName)
	{
		
		ExtentTest extentTest=reports.createTest(testName);
		return extentTest;
	}
	
	
	
	
	
	
}
