package com.Amazon.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
	
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img")
	WebElement Product;
	
	@FindBy(xpath = "//*[@id=\"p_n_is_cod_eligible/4931671031\"]/span/a/div/label/i")
	WebElement Filter;

public ProductListPage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	}

public void clickonfilter() {
	
	Filter.click();
}

public void clickonProduct() {
	
	Product.click();
}
	
	
}
