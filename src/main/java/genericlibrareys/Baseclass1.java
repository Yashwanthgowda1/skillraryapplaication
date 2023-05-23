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
import poms.AnalyticsandReports;
import poms.ManageStudent;
import poms.homepage;
import poms.loginPage;
import popmpages.contactus;
import popmpages.java_selenium;
import popmpages.mainpage;
import popmpages.searchoption;
import popmpages.searchoptionmainpage;
import popmpages.seleniumtriningpage;
import popmpages.skillrarydemopage;
import popmpages.testpage;

public class Baseclass1 {
	
	protected WebDriverUtility web1;
	protected ExcelFileUtility excel;
	protected JavaUtility junit;
	protected PropertyFileUtility property;// link with property
	protected WebDriver driver;
protected  loginPage login;
	protected skillrarydemopage demoapp;
	protected seleniumtriningpage selenium;
	protected testpage testing;
	protected ManageStudent managestuden;
	protected contactus contact;
	protected AnalyticsandReports analystreport;
	protected homepage home;
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
 analystreport=new AnalyticsandReports(driver);
 home=new homepage(driver);
login=new loginPage(driver);
 managestuden=new ManageStudent(driver);
}



}







