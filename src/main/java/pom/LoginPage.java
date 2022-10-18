package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.UtilClass;

public class LoginPage extends UtilClass {

	WebDriver driver;
	
	@FindBy(xpath="//input[@id='userid']")
	private WebElement emailID;
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement continueButton;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		
	}
	
	public  void enterEmailId() throws IOException
	{
		emailID.sendKeys(getConfigData("id"));
		
	}
	public  void enterPassword() throws IOException
	{
		password.sendKeys(getConfigData("password"));
		
	}
	public  void clickonSubmitButton() throws InterruptedException
	{
		submit.click();
		
		Thread.sleep(10000);
		
	}
	
	public void clickonContinueButton() 
	{
		
		
		continueButton.click();
		
	}
	
	
	
	
	
}
