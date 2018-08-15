package shitpticketdesk;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import java.net.MalformedURLException;
import java.time.Duration;

public class TandC extends Base{
    public static void testTandC() throws MalformedURLException, InterruptedException {

        //Getting the capabilities in the Android Driver
        AndroidDriver<AndroidElement> driver = capabilities
                ("com.pb.framework.ui.activity.TermsActivity");

        //Waiting for the application to load completely
        Thread.sleep(7000);

        //Swiping the Terms and conditions to make sure that the button is enabled
        //1.Creating a new TouchAction Object to simulate the swipe action
        //2. Long pressing the particular item and then swiping
        TouchAction t = new TouchAction(driver);

        //Using the element from where the swiping is to be started
        ElementOption swipeFrom = ElementOption.element(driver
                .findElementByXPath("//*[@content-desc = 'Version: 1.0 ']"));

        //Using the element to where the swiping is to be ended
        ElementOption swipeTo = ElementOption.element(driver.findElementById
                ("android:id/statusBarBackground"));

        //Setting the time for the duration that is to be pressed
        Duration pressTime = Duration.ofSeconds(1);

        //Performing the swiping action to make sure that the checkbox is enabled
        t.longPress(LongPressOptions.longPressOptions().
                withElement(swipeFrom).withDuration(pressTime))
                .moveTo(swipeTo)
                .release()
                .perform();

        //Tapping the check box after its activation in the screen
        driver.findElementById("com.pb.shipticketdesk:id/checkbox_terms")
                .click();

        //Tapping on the ACCEPT button
        driver.findElementByAndroidUIAutomator("text(\"Accept\")")
                .click();
    }
}
