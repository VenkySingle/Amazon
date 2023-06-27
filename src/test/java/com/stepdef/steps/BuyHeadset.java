package com.stepdef.steps;

import com.commonutils.common.CommonClass;
import com.pageobjects.pages.Accessories;
import com.pageobjects.pages.BookedPage;
import com.pageobjects.pages.CartPage;
import com.pageobjects.pages.Headsets;
import com.pageobjects.pages.HomePage;

import io.cucumber.java.en.*;

public class BuyHeadset {
	
	
	@Given("browser is launched, Mobile Navigation link is clicked successfully.")
	public void browserIsLaunchedMobileNavigationLinkIsClickedSuccessfully() {
		try
		{
			
			HomePage.getInstance().HomePagecheck("Mobiles");
			HomePage.getInstance().MobileClick();
			CommonClass.GetInstance().ReportGen("pass", "browser is launched, Mobile Navigation link is clicked successfully.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			CommonClass.GetInstance().ReportGen("fail", "browser is launched, Mobile Navigation link is not clicked successfully.");
		}
	    
	    
	}
	@Then("SmartPhones, Accessories and Motorola razr menus are displayed when clicking Mobiles button and SmartPhones menu is selected by default.")
	public void smartPhonesAccessoriesAndMotorolaRazrMenusAreDisplayedWhenClickingMobilesButtonAndSmartPhonesMenuIsSelectedByDefault() {
		try
		{
			Accessories.getInstance().displaycheck();
			
			CommonClass.GetInstance().ReportGen("pass", "SmartPhones, Accessories  menus are displayed when clicking mobiles");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			CommonClass.GetInstance().ReportGen("fail", "Display fail");
		}
	}
	@When("Accessories Menu is clicked")
	public void accessoriesMenuIsClicked() {
	    
		try
		{
			Accessories.getInstance().AccClick();
			CommonClass.GetInstance().ReportGen("pass", "Accessories click success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			CommonClass.GetInstance().ReportGen("fail", "Accessories click fail");
		}
	}
	@Then("Headsset should be displayed")
	public void headssetShouldBeDisplayed() {
		try
		{
			//Accessories.getInstance().AccClick();
			CommonClass.GetInstance().ReportGen("pass", "Headsset menu should be displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			CommonClass.GetInstance().ReportGen("fail", "Headset click fail");
		}
	}
	@Then("Headset sub menu is clicked to move on to headset section")
	public void headsetSubMenuIsClickedToMoveOnToHeadsetSection() {
	    
		try
		{
		  Headsets.getInstance().Headsetclick();
		  CommonClass.GetInstance().ReportGen("Pass", "Headset click success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			CommonClass.GetInstance().ReportGen("fail", "Headset click success fail");
		}
	}
	@When("TopDeal Headset is clicked")
	public void topDealHeadsetIsClicked() {
	    
		try
		{
			CartPage.getInstance().DealCheck();
			CartPage.getInstance().DealClick();
			CommonClass.GetInstance().ReportGen("Pass", "Top Deal Headset is clicked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			CommonClass.GetInstance().ReportGen("fail", "Top deal headset is not clicked");
		}
	}
	@Then("Topdeal Headset is selected")
	public void topdealHeadsetIsSelected() {
		try
		{
		CartPage.getInstance().CheckSelectedandInstock();	
		CommonClass.GetInstance().ReportGen("Pass", "Top Deal headset selected and Headset is in stock");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			CommonClass.GetInstance().ReportGen("fail", "Top Deal headset not selected and Headset not in stock");
		}
	}
	@When("Add to cart is clicked")
	public void addToCartIsClicked() {
	   
		try
		{
			
			BookedPage.getInstance().CartClick();
			CommonClass.GetInstance().ReportGen("pass", "Add to cart clicked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			CommonClass.GetInstance().ReportGen("fail", "Add to cart not clicked");
		}
	}
	@Then("Add to cart is selected to purchase the headset")
	public void addToCartIsSelectedToPurchaseTheHeadset() {
	    
		try
		{
			BookedPage.getInstance().Carttextcompare();
			CommonClass.GetInstance().ReportGen("Pass", "Headset is added to cart");
			CommonClass.GetInstance().ReportSave();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			CommonClass.GetInstance().ReportGen("fail", "Headset is not added to cart");
		}
	}

}
