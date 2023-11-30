package com.Amazon.qa.TestPages;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Amazon.qa.Base.TestBaseAmazon;
import com.Amazon.qa.Pages.HomePageAmazon;
import com.Amazon.qa.Pages.ProductListPage;
import com.Amazon.qa.Utilities.Xls_DataProvider;

@Listeners(ItestListenerClass.class)
public class HomePageAmazonTest extends TestBaseAmazon{ 
	
	HomePageAmazon hp;
	ProductListPage pl;

	@BeforeClass
	public void OpenApp() {

	    openBrowser("Chrome");
		hp = new HomePageAmazon(driver);
		pl = new ProductListPage(driver);
	}

	@Test(priority = '1', dataProvider = "testdata")
	public void enterProduct(String search1) throws InterruptedException { 

		Thread.sleep(2000);
		hp.enterProduct(search1);
		Thread.sleep(2000);
		hp.clickonSearch();
		

	}
	
	@Test(priority = '2')
	public void clickonfilter() throws InterruptedException { 

		Thread.sleep(2000);
		pl.clickonfilter();
		

	}

	@Test(priority = '3')
	public void clickonProduct() throws InterruptedException {
		
		Thread.sleep(2000);
	    pl.clickonProduct();
	}

	@Test(priority = '4')
	public void pageTitle() {
		
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	
	@DataProvider(name = "testdata")
	public Object[][] datasupplier() throws IOException {

		Object[][] input = Xls_DataProvider.getTestData("Sheet1");
		return input;
	}

}