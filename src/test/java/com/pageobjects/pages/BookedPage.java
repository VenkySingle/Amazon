package com.pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.commonutils.common.CommonClass;

public class BookedPage {
	
	
	public static BookedPage LoginPageInstance;
	
	private BookedPage()
	{
		
	}

	public static BookedPage getInstance()
	{
		if (LoginPageInstance==null)
		{
			LoginPageInstance = new BookedPage();
		}
		return LoginPageInstance;
	}
	
	
@FindBy(how=How.XPATH,using = "//input[@title = 'Add to Shopping Cart']")
private WebElement AddtoCart;

@FindBy(how=How.XPATH,using = "//span[contains(text(),'Added')]")
private WebElement TxtCmpre;


public void CartClick()
{
	AddtoCart.click();
	String  a = CommonClass.GetInstance().getTitle();
	System.out.println(a);
	String title1 = "Amazon.in Shopping Cart";
	if(a.equalsIgnoreCase(title1))
	{
		CommonClass.GetInstance().ReportGen("pass", "Cart Page");
		System.out.println("success and in home page");
	}
	else
	{
		CommonClass.GetInstance().ReportGen("fail", "Display wrong");
		//throw new ElementClickInterceptedException("Fail");
	}
}
public void Carttextcompare()
{
	String a = TxtCmpre.getText();
	System.out.println(a);
}

}
