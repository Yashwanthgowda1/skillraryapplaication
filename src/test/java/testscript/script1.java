package testscript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibrareys.Baseclass;
import pompage.homepage;
import poms.mainpage;

public class script1 extends Baseclass{
@Test
public void m1(){
	SoftAssert soft=new SoftAssert();
	home.clickgearTab();
	home.clickskillrarydemoapp();
	web1.handleChildBrowser();
	soft.assertEquals(demoapp.getpageHeader(),("SkillRary-ECommerce"));
	demoapp.mouseHoverTocourse(web1);
	demoapp.clickseleniumtraning();
	soft.assertEquals(selenium.getpageheader(), "Selenium Training");
	selenium.doubleclick(web1);
	selenium.clickAddTochart();
web1.handelAlertpops("ok", null);
soft.assertEquals(selenium.getiteamaddtocartmessage(), "Item added to cart");
soft.assertAll();
}
}
