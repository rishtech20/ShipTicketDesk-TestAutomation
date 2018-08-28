//Author: Rishabh Madan
package Automation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TandCTest extends Base{
	
	@Test
	public void A_swipeTandC() throws InterruptedException{
		Thread.sleep(8000);
		TouchAction t = new TouchAction(driver);
		Point swipeFrom = driver.findElementByXPath("//*[@content-desc = 'Version: 1.0 ']")
				.getCenter();

		Point swipeTo = driver.findElementById("android:id/statusBarBackground")
				.getCenter();
		
		for (int i = 0; i < 3; ++i) {
			t.press(PointOption.point(swipeFrom.x, swipeFrom.y)).moveTo(PointOption.point(swipeTo.x, swipeTo.y)).release().perform();
			Thread.sleep(1000);
		}
		test = extent.createTest("Swiping the T and C");
		test.log(Status.INFO, "Swiping the T and C to enable the checkbox");
		test.log(Status.PASS, "Swiping Verified");
		Thread.sleep(2000);
	}
	
	@Test
	public void B_ClickOnCheckBox() {
		driver.findElementById("com.pb.shipticketdesk:id/checkbox_terms")
        .click();
		test = extent.createTest("Tapping on the checkbox");
		test.log(Status.INFO, "Tapping on the check box to accept the terms and conditions");
	}
	
	@Test
	public void C_ClickOnAcceptButton() {
		driver.findElementByAndroidUIAutomator("text(\"Accept\")")
        .click();
		test = extent.createTest("Tapping on the Accept button");
		test.log(Status.INFO, "Tapping on the Accept button to go to the walkthrough screen");
	}
		
}
