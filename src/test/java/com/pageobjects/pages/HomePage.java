package com.pageobjects.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.commonutils.common.CommonClass;
import com.driver.launch.DriverLaunch;


public class HomePage {

//Common com = new Common();
/*DriverLaunch laun = new DriverLaunch();
public WebDriver driver = laun.getDriver();*/

public static HomePage getInstances;
//WebDriver driver = DriverLaunch.GetInstance().driver();
private HomePage()
{
	
}


public static HomePage getInstance()
{
	if(getInstances == null)
	{
		getInstances = new HomePage();
	}
	return getInstances;
}




	



	
	@FindBy(xpath="//a[text()='Mobiles' and @class= 'nav-a  ' ]")
     private WebElement Mobiles;
	
	
	
	public void HomePagecheck(String u){
		//System.out.println(driver+ "pages");
		WebElement eles = Mobiles;
		String txt = eles.getText();
		System.out.println(txt);
		String title = CommonClass.GetInstance().getTitle();
		System.out.println(title);
		String title1 = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		if(title.equalsIgnoreCase(title1))
		{
			CommonClass.GetInstance().ReportGen("pass", "In Home page");
			System.out.println("success and in home page");
		}
		else
		{
			CommonClass.GetInstance().ReportGen("fail", "Display wrong");
		}
		
	}
	
    public void MobileClick()
    {
    	Mobiles.click();
    }
	

}
