package test.gallerytestcase;

import java.lang.Exception;

import org.testng.Reporter;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class GalleryTestcase {
		static AppiumDriver<MobileElement> driver;
		public static void main(String[] args){
			try {
			openGallery();
			}
			catch(Exception exp) {
				System.out.println(exp.getCause());
				System.out.println(exp.getMessage());
				exp.printStackTrace();
			}

		}
		@SuppressWarnings({ "rawtypes" })
		@Test(description="gallery testcase")
		public static void openGallery() throws Exception {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", "sonia");
			cap.setCapability("udid", "192.168.1.5:5555");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "8.1.0");
			cap.setCapability("appPackage", "com.miui.gallery");
			cap.setCapability("appActivity", "com.miui.gallery.activity.HomePageActivity");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,cap);
			
			
			System.out.println("start");
			Reporter.log("Open Gallery");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Reporter.log("Close All popup msg");
			MobileElement popup1= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]");
			popup1.click();
			
			MobileElement popup2= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button");
			popup2.click();
			
			System.out.println("close all popup msg");
			
			//scrolldown
			Reporter.log("Scrolling down using touchaction");
			Dimension dimension = driver.manage().window().getSize();
			System.out.println("scroll start");
			Double scrollHeightStart = dimension.getHeight() * 0.5;
			int scrollStart = scrollHeightStart.intValue();
			
			Double scrollHeightEnd = dimension.getHeight() *0.2;
			int scrollEnd = scrollHeightEnd.intValue();
			
			new TouchAction((PerformsTouchActions) driver)
			.press(PointOption.point(0, scrollStart))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(0, scrollEnd))
			.release().perform();
			
			Reporter.log("stop scrolling");
			System.out.println("scroll stop");
			
			System.out.println("tap");
			Reporter.log("using tap select photo with using coordinates");
			
	        TouchAction touchAction = new TouchAction(driver);
	        touchAction.tap(PointOption.point(155, 1437)).perform();
			
	        Reporter.log("close app");
			System.out.println("complete...");
   		 driver.closeApp();
			
	}

}
