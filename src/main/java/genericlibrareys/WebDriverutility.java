package genericlibrareys;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverutility {
	private WebDriver driver;
	private Actions a;
	private JavascriptExecutor b;
	private Alert c;
	

	public WebDriver openapplication(String Browser, String url, long time) {
		switch (Browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		}
		driver.manage().window();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return driver; 
	}
	/**
	 * this method is used to wait explictly untile visbalitytext
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explictlywait(long time, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		WebElement e=wait.until(ExpectedConditions.visibilityOf(element));
		return e;
		
	}
	
	public void mouseHover(WebElement element) {
a=new Actions(driver);
a.moveToElement(element).perform();
	}
	/**
	 * THIS METHOD IS USED TO DOUBLE CLICK
	 * @param element
	 */

	public void doubleClick(WebElement element) {
a=new Actions(driver);
a.doubleClick(element).perform();
		
	}
	/**
	 * THIS METHOD IS USED FOR RIGHT CLICK
	 * @param element
	 */

	public void rightClick(WebElement element) {
a=new Actions(driver);
a.contextClick(element).perform();
	}
	public void draganddrop(WebElement element) {
		a=new Actions(driver);
		a.doubleClick(element).perform();
}
	
	public void dropdown(WebElement element, int value) {
		Select a=new Select(element);
		if(a.isMultiple()) {
			a.selectByIndex(value);
		}
		else {
		
		a.selectByIndex(value);
	
	}
	}
	public void takescreeshoot(Javautility java) {
		TakesScreenshot a=(TakesScreenshot)driver;
		File src=a.getScreenshotAs(OutputType.FILE);
		File dsc=new File(".//target"+java.getcurrentdatetime()+".png");
		try {
			FileUtils.copyFile(src, dsc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}
	public void scrolldown1(WebElement element) {
		 b=(JavascriptExecutor)driver;
		b.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void frameindex(int value) {
		driver.switchTo().frame(value);
	}
	public void frametext(String text) {
		driver.switchTo().frame(text);
	}
	public void framewebelemnt(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void framestring(String element) {
		driver.switchTo().frame(element);
	}
	
	public void quitbrower() {
		driver.quit();
	}
	
	
	
	
	public void alertpopsaccept() {
 c=driver.switchTo().alert();
c.accept();
	}
	public void alertpopsdismiss() {
		 c=driver.switchTo().alert();
		 c.dismiss();
	}
	public void alertpopstext() {
		 c=driver.switchTo().alert();
		 System.out.println(c.getText());
	}
	
	
	public void alertpopssendtext(String values) {
		 c=driver.switchTo().alert();
		 c.sendKeys(values);
	}



public void notificcationpops(Integer index, Integer index1, Integer index2) {
	HashMap<String,Integer> contentsettings=new HashMap<>();
	contentsettings.put("geolocation", index);
	contentsettings.put("notifications", index1);
	contentsettings.put("media_stream", index2);
	HashMap<String, Object> profile=new HashMap<>();
	profile.put("manage_default_content_settings", contentsettings);
	HashMap<String, Object>prefrarance=new HashMap<>();
	prefrarance.put("profile", profile);
	ChromeOptions options=new ChromeOptions();
	options.setExperimentalOption("prefs", prefrarance);
	
	

	
		
}

public void handelparent() {
	String parent=driver.getWindowHandle();
	driver.switchTo().window(parent);
}
public void handelchild() {
	Set<String> child=driver.getWindowHandles();
	for(String child11:child) {
		driver.switchTo().window(child11);
	}
}




}
	
	
	

