//Author: Rishabh Madan
package Automation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	public static AndroidDriver<AndroidElement> driver;
	public static ExtentHtmlReporter Htmlreporter = new ExtentHtmlReporter("./extent-report.html");
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;
	
	@BeforeSuite
    public void Setup() throws IOException, InterruptedException{
		
		Runtime.getRuntime().exec("cmd /c start C:\\startappium.bat");
		Thread.sleep(12000);
		extent.attachReporter(Htmlreporter);
        File f = new File("src");
        File fs = new File(f, "FreshDeskCompanion_qa_v1.0.5_d.apk");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "TestingTab123");
        cap.setCapability("appPackage", "com.pb.shipticketdesk");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        //Wildcard- for the continuous flow in the application
        cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.pb.*");
        //cap.setCapability("appActivity", activityName);
        //cap.setCapability("appActivity", "com.pb.shipticketdesk.ui.activity.SplashActivity");


        //Sending the connection request to the server and initiating the automation
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }
	
	
	@AfterSuite
	public void Close() {
		driver.quit();
		extent.flush();
	}
}
