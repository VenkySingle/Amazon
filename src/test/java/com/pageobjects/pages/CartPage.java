package com.pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.commonutils.common.CommonClass;
import com.driver.launch.DriverLaunch;


public class CartPage {

//Common com = new Common();
/*DriverLaunch laun = new DriverLaunch();
public WebDriver driver = laun.getDriver();*/

public static CartPage getInstances;
//WebDriver driver = DriverLaunch.GetInstance().driver();
private CartPage()
{
	
}


public static CartPage getInstance()
{
	if(getInstances == null)
	{
		getInstances = new CartPage();
	}
	return getInstances;
}


	
	@FindBy(xpath="//span[text()='Top deals on headsets']")
     private WebElement Topdealtext;
	
	@FindBy(xpath="//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']")
    private WebElement Dealclick;
	
	@FindBy(xpath="//span[contains(text(),'In stock') and @class = 'a-size-medium a-color-success']")
	private WebElement Selected;

	
	
	
	public void DealCheck(){
		
		//driver.executeScript("arguments[0].scrollIntoView(true);", Topdealtext);
		CommonClass.GetInstance().Scrollintoview(Topdealtext);
		String txt = Topdealtext.getText();
		System.out.println(txt);
		}
	
	
	
	public void DealClick(){
		
		
		Dealclick.click();
	
		}
  
	public void CheckSelectedandInstock(){
		
		String b = CommonClass.GetInstance().getTitle();
		String a = Selected.getText();
		System.out.println(a);
		System.out.println(b);
	
		}
	

}
