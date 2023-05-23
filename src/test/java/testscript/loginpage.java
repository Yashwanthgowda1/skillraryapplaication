package testscript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import genericlibrareys.Baseclass1;

public class loginpage extends Baseclass1{
@Test
public void m1() throws InterruptedException {
	SoftAssert soft=new SoftAssert();

	//login.setemailtextfiled(excel.readData("Sheet1", 0, 1));
	login.setemailtextfiled("test101@gmail.com");
	Thread.sleep(1000);
//	login.setpasswordtextfiled(excel.readData("Sheet1", 1, 1));
	login.setpasswordtextfiled("Test@101");
	Thread.sleep(1000);
	login.clickloginbutton();
	Thread.sleep(1000);
	
	soft.assertTrue(home.getlogo().isDisplayed());
	Thread.sleep(1000);
	soft.assertAll();
}
}
