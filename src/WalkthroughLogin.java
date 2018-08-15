package shitpticketdesk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.MalformedURLException;

public class WalkthroughLogin extends Base{
    //This method takes driver as the argument and returns it to the next  activity
    public static void walkTLog() throws MalformedURLException, InterruptedException {

        //Calling the driver
        AndroidDriver<AndroidElement> driver = capabilities(".ui.activity.AppIntroActivity");

        //Tapping on the next button till button appears
        driver.findElementByAndroidUIAutomator("text(\"Next\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Next\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Next\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Proceed\")").click();
        Thread.sleep(2000);

        //Clicking on the Login with Freshdesk button
        driver.findElementByAndroidUIAutomator("text(\"Login with Freshdesk\")").click();

        //Inputting the text in the text fields in order to login - can be made to take input
        //from the user, hardcoding for now.
        //1.Domain Name
        driver.findElementById("com.pb.shipticketdesk:id/et_domain_name")
                .sendKeys("pbdemo");
        //Pressing back button
        driver.navigate().back();

        //2.Email
        driver.findElementById("com.pb.shipticketdesk:id/et_input_edit_text_email_id")
                .sendKeys("donnydominipb@gmail.com");
        //Pressing the back button
        driver.navigate().back();

        //3. Password
        driver.findElementById("com.pb.shipticketdesk:id/et_password")
                .sendKeys("pitney123");
        //Tapping the back button
        driver.navigate().back();

        //Tapping on the sign in button
        driver.findElementByAndroidUIAutomator("text(\"Sign In\")").click();
    }
}
