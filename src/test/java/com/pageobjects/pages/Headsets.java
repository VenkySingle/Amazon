package com.pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.commonutils.common.CommonClass;
import com.driver.launch.DriverLaunch;


public class Headsets {

//Common com = new Common();
/*DriverLaunch laun = new DriverLaunch();
public WebDriver driver = laun.getDriver();*/

public static Headsets getInstances;
//WebDriver driver = DriverLaunch.GetInstance().driver();

private Headsets()
{
	
}
public static Headsets getInstance()
{
	if(getInstances == null)
	{
		getInstances = new Headsets();
	}
	return getInstances;
}


	
	@FindBy(xpath="//span[text()='Headsets']")
     private WebElement Headsets;
	

	
	
	
	public void Headsetclick(){
		
		String title = CommonClass.GetInstance().getTitle();
		System.out.println(title);
		String title1 = "Mobile Accessories: Buy Mobile Accessories online at best prices in India - Amazon.in";
		if(title.equalsIgnoreCase(title1))
		{
			CommonClass.GetInstance().ReportGen("pass", "In Accessories page");
			System.out.println("success and in home page");
		}
		else
		{
			CommonClass.GetInstance().ReportGen("fail", "Display wrong");
			//throw new ElementClickInterceptedException("Fail");
		}
		
		Headsets.click();
		
		}
	
  
	

}
