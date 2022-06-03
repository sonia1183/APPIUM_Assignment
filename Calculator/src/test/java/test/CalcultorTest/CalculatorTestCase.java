package test.CalcultorTest;

import java.lang.Exception;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class CalculatorTestCase {

	static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args){
		try {
		Calculator();
		}
		catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

	}
	@SuppressWarnings("deprecation")
	@Test(description="calculator testcase")
	public static void Calculator() throws Exception {
		
		//ADD CAPABILITIES FOR ANDROID
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "sonia");
		cap.setCapability("udid", "192.168.1.5:5555");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("appPackage", "com.veronicaapps.veronica.simplecalculator");
		cap.setCapability("appActivity", "com.veronicaapps.veronica.simplecalculator.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		
		System.out.println("start");
		
		Reporter.log("Open Calculator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//NUMBERS 
		
		MobileElement numOne= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[13]");
		MobileElement numTwo= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[14]");
		MobileElement numThree= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[15]");
		
		//OPERATIONS
		MobileElement plus= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[12]");
		MobileElement equal= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[20]");
		MobileElement output=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]");
		MobileElement sub=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[8]");
		MobileElement mult=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[3]");
		
		
		//PERFORM SUM
		
		Reporter.log("Perform Sum 1+2+3");
		
		numOne.click();
		plus.click();
     		numTwo.click();
		plus.click();
		numThree.click();
		equal.click();

		String Addres = output.getText();
		Reporter.log("Sum Result "+ Addres);
		System.out.println("result is "+ Addres);
		
		
		//PERFORM SUBTRACTION
		
		Reporter.log("perform subtraction 2-1");
		numTwo.click();
		sub.click();
     		numOne.click();
		equal.click();
		
		String Subres = output.getText();
		Reporter.log("Subtraction Result "+ Subres);
		System.out.println("result is "+ Subres);
		
		
		//PERFORM MULTIPLICATION
		
		
		Reporter.log("Perform Multiplication 1*2*3 ");
		numOne.click();
		mult.click();
     		numTwo.click();
		mult.click();
		numThree.click();
		equal.click();
		
		
		String Multres = output.getText();
		Reporter.log("Multiplication Result "+ Multres);
		System.out.println("result is "+ Multres);
		
		
		Reporter.log("close App");
		System.out.println("complete...");
		driver.closeApp();
	}
}
