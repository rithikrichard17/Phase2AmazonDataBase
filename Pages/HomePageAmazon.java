package com.Amazon.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAmazon {
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement Search;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement Searchbtn;
	
	//@FindBy(xpath = "//*[@id=\"p_n_feature_browse-bin/29677683031\"]/span/a/div/label/i")
	//WebElement Filter;

public HomePageAmazon(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
}
	public void enterProduct(String search1) {
		
		Search.clear();
		Search.sendKeys(search1);
		
	}
	
	public void clickonSearch() {
		
		Searchbtn.click();
	}


}
