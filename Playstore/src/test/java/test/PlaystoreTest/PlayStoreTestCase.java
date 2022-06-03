package test.PlaystoreTest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class PlayStoreTestCase {

//	static AppiumDriver<MobileElement> driver;
	 public static AndroidDriver<MobileElement> driver;
	 
	 @BeforeTest
	public static void main(String[] args){
		try {
		openPlaystore();
		}
		catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

	}
	
	@Test(description = "Playstore")
	public static void openPlaystore() throws Exception {
		
		Reporter.log("Set capabilities");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "sonia");
		cap.setCapability("udid", "192.168.1.5:5555");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("noReset", true);
		cap.setCapability("appPackage", "com.android.vending");
		cap.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,cap);
		Thread.sleep(5000);
		
		Reporter.log("open Playstore");
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View")).click();
		
		Reporter.log("search Bajaj Health App");
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.EditText").sendKeys("Bajaj Finserv Health");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		Reporter.log("Click on app");
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]").click();
		
		Reporter.log("Click on what's new");
		driver.findElementById("More results for About this app").click();
		
		Reporter.log("Scroll till vserion");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"version\").instance(0))"));
		
		driver.closeApp();
		
	}
	
}
