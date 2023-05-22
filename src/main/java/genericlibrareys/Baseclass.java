package genericlibrareys;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


import generic_librarey.ExcelFileUtility;
import generic_librarey.JavaUtility;
import generic_librarey.PropertyFileUtility;
import generic_librarey.WebDriverUtility;
import popmpages.contactus;
import popmpages.java_selenium;
import popmpages.mainpage;
import popmpages.searchoption;
import popmpages.searchoptionmainpage;
import popmpages.seleniumtriningpage;
import popmpages.skillrarydemopage;
import popmpages.testpage;

public class Baseclass {
	
	protected WebDriverUtility web1;
	protected ExcelFileUtility excel;
	protected JavaUtility junit;
	protected PropertyFileUtility property;// link with property
	protected WebDriver driver;
	protected mainpage home;
	protected skillrarydemopage demoapp;
	protected seleniumtriningpage selenium;
	protected testpage testing;
	protected contactus contact;
	
	
	protected searchoptionmainpage searchhome;
	protected searchoption search;
	protected java_selenium javaselenium;
	
//@BeforeSuite
@BeforeClass
public void lanuchingbrowser() {
	web1 = new WebDriverUtility();
	excel = new ExcelFileUtility();// ;ink with execel
	junit = new JavaUtility();
	property = new PropertyFileUtility();
	
	property.propertyconfg(Iconstantpath.PropertiesFile) ;
	String browser=property.fetchproperty("browser");
	String url=property.fetchproperty("url");
	String t=property.fetchproperty("time");
	long time=Long.parseLong(t);
	driver=web1.openApplication(browser, url, time);
	
}
public void  excelfile() {
	excel.reintilization(Iconstantpath.ExcelFile);
	home = new mainpage(driver);// connection to before class and method
	demoapp = new skillrarydemopage(driver);
	selenium = new seleniumtriningpage(driver);
	testing = new testpage(driver);
	contact = new contactus(driver);
	search = new searchoption(driver);
	 searchhome=new searchoptionmainpage(driver);
	 javaselenium=new java_selenium(driver);
	 Assert.assertTrue(home.getlogo().isDisplayed());

}




@AfterMethod
public void methodteardown() {
	excel.closeWorkBook();
}

@AfterClass
public void closethebrowser() {
	web1.quitBrowser();
}
}







