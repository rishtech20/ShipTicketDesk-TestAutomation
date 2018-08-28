//Author: Rishabh Madan
package Automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class WalkthroughLoginTest extends Base {
    
    @Test(priority = 1)
    public void A_TapOnNext() throws InterruptedException {
    	driver.findElementByAndroidUIAutomator("text(\"Next\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Next\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Next\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Proceed\")").click();
        test = extent.createTest("Tapping on the Next button");
		test.log(Status.INFO, "Going through the walkthrough screen and tapping on the next button");
    }
    
    @Test(priority = 2)
    public void B_TapOnLoginWithFreshDesk() {
    	driver.findElementByAndroidUIAutomator("text(\"Login with Freshdesk\")").click();
    	test = extent.createTest("Tapping on the Login with Freshdesk Button");
		test.log(Status.INFO, "Tapping on Login with Freshdesk button to input the credentials");
    }
    
    @Test(priority = 3)
    public void C_LoginActivity() {
        //1.Domain Name
        driver.findElementById("com.pb.shipticketdesk:id/et_domain_name")
                .sendKeys("rishventures");
        //Pressing back button
        driver.navigate().back();
        //2.Email
        driver.findElementById("com.pb.shipticketdesk:id/et_input_edit_text_email_id")
                .sendKeys("rish.tech23@gmail.com");
        //Pressing the back button
        driver.navigate().back();
        //3. Password
        driver.findElementById("com.pb.shipticketdesk:id/et_password")
                .sendKeys("9711349456r");
        //Tapping the back button
        driver.navigate().back();
        test = extent.createTest("Inputting the Freshdesk Credentials");
		test.log(Status.INFO, "Logging into the application using the correct credentials");
    }
    
    @Test(priority = 4)
    public void D_TapOnSignInButton() {
    	driver.findElementByAndroidUIAutomator("text(\"Sign In\")").click();
    	test = extent.createTest("Tapping on the Sign-in button");
		test.log(Status.INFO, "Tapping on the sign-in button in order to login into the application");
    }
    
}
