package com.commonutils.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.driver.launch.DriverLaunch;
import com.pageobjects.pages.Accessories;
import com.pageobjects.pages.BookedPage;
import com.pageobjects.pages.CartPage;
import com.pageobjects.pages.Headsets;
import com.pageobjects.pages.HomePage;

import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.et.Eeldades;
import junit.framework.Assert;

public class CommonClass {
	
	public static CommonClass CommonClassInstance;
	public WebDriver driver;
	public Properties prop;
	public Properties prop1;
	public ExtentHtmlReporter Reporter;
	public ExtentReports report;
	public ExtentTest test;
	public JavascriptExecutor exec;
	
	
	private CommonClass()
	{
		
	}
	public static CommonClass GetInstance()
	{
		if(CommonClassInstance == null)
		{
			CommonClassInstance = new CommonClass();
		}
		return CommonClassInstance;
		}

	public Properties PropertyInitialize(String file)
	{
		try{
			FileInputStream Fis = new FileInputStream("./Properties/"+file+".properties");
			prop = new Properties();
			prop.load(Fis);
			Logs.GetInstance().info("Property loaded successfully");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop;
	}

	public void initElements()
	{
		driver = DriverLaunch.GetInstance().getDriver();
		PageFactory.initElements(driver, HomePage.getInstance());
		PageFactory.initElements(driver, Accessories.getInstance());
		PageFactory.initElements(driver, BookedPage.getInstance());
		PageFactory.initElements(driver, CartPage.getInstance());
		PageFactory.initElements(driver, Headsets.getInstance());
			
	}
	
	public boolean sendkeys(WebElement ele,String value)
	{
		try{
		ele.sendKeys(value);
		Logs.GetInstance().info("Send keys are successful");
		}
		catch(Exception e){
			Logs.GetInstance().error("Fail in send keys");
			e.printStackTrace();
		}
		return true;
	}
	public String getTitle()
	{
		String a=driver.getTitle();
		return a;
	}
	public boolean Scrollintoview(WebElement ele)
	{
		try{
			exec = (JavascriptExecutor) driver;
			exec.executeScript("arguments[0].scrollIntoView(true);", ele);
		Logs.GetInstance().info("Scroll is successful");
		}
		catch(Exception e){
			Logs.GetInstance().error("Scroll fail");
			e.printStackTrace();
		}
		return true;
	}
	public boolean click(WebElement ele)
	{
		try{
			
		ele.click();
		Logs.GetInstance().info("click are successful");
		}
		catch(Exception e){
			
			e.printStackTrace();
			Logs.GetInstance().error("click are not successful");
		}
		return true;
	}
	public void impwait()
	{
		
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void AlertAccept()
	{
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ValidationAssert(String expected,String Actual)
	{
		try {
			Assert.assertEquals(expected, Actual);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Assetion fail");
		}
	}
	public String ReportInitialisation(String testcase)
	{
		 Reporter = new ExtentHtmlReporter("./target/"+testcase+".html");
		 report = new ExtentReports();
		report.attachReporter(Reporter);
		return testcase;
	}
	public void ReportSave()
	{
		report.flush();
	}
	public void CreateTest(String Tc,String author,String Cate)
	
	{
       test = report.createTest(Tc);
       test.assignAuthor(author);
       test.assignCategory(Cate);
      
	}
	public void ReportGen(String key, String msg)
	{
		if(key.equalsIgnoreCase("pass"))
			try {
				test.pass(msg);
				//test.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath("../screenshots/"+takescreenshot()+".png").build());
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		else if (key.equalsIgnoreCase("fail"))
			try {
				test.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath("../target/screenshots/"+takescreenshot()+".png").build());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	public int takescreenshot()
	{
		
		try {
			int random;
		
		random = (int)(Math.random()*999999);
		
		TakesScreenshot T = ((TakesScreenshot)driver);
		
		File source = T.getScreenshotAs(OutputType.FILE);
		
		File target = new File("./target/screenshots/"+random+".png");
		
		
			FileUtils.copyFile(source, target);
			
			return random;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	return 0;	
	}

	}

