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


public class Accessories {

//Common com = new Common();
/*DriverLaunch laun = new DriverLaunch();
public WebDriver driver = laun.getDriver();*/
	private Accessories()
	{
		
	}

public static Accessories getInstances;
//WebDriver driver = DriverLaunch.GetInstance().driver();

//span[text()='Headsets']
public static Accessories getInstance()
{
	if(getInstances == null)
	{
		getInstances = new Accessories();
	}
	return getInstances;
}


	
	@FindBy(xpath="//a[@href='/b?node=1389401031&ref_=MH1_Smartphones']")
     private WebElement Smartphone;
	
	@FindBy(xpath="//a[@href='/b?node=1389402031&ref_=MH1_Accessories']")
    private WebElement Accessories;
	
	/*@FindBy(xpath="//a[@href='/b?node=84732872031&ref_=MH1_Moto']")
    private WebElement Moto;*/
	
	
	
	public boolean displaycheck(){
		
		
		String a = Smartphone.getText();
		String b = Accessories.getText();
		String title = CommonClass.GetInstance().getTitle();
		System.out.println(a);
		System.out.println(b);
		System.out.println(title);
		String title1 = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		if(title.equalsIgnoreCase(title1))
		{
			CommonClass.GetInstance().ReportGen("pass", "In Mobile page");
			System.out.println("success and in home page");
		}
		else
		{
			CommonClass.GetInstance().ReportGen("fail", "Display wrong");
			//throw new ElementClickInterceptedException("Fail");
		}
		
	
		
		
		return true;

		
		
	}
	
    public void AccClick()
    {
    	Accessories.click();
    }
	

}
