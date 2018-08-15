package shitpticketdesk;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
    public static AndroidDriver<AndroidElement> capabilities(String activityName)
            throws MalformedURLException{

        File f = new File("src/shitpticketdesk");
        File fs = new File(f, "FreshDeskCompanion_qa_v1.0.5_d.apk");

        //Creating a desired Capabilities object
        DesiredCapabilities cap = new DesiredCapabilities();

        //Setting the Emulator that needs to be used for the automation test
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "TestingTab123");

        //Setting the path for the apk that needs to be invoked by the client
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

        //Setting additional capabilities
        cap.setCapability("appPackage", "com.pb.shipticketdesk");
        cap.setCapability("appActivity", activityName);
        //cap.setCapability("appActivity", ".ui.activity.AppIntroActivity");


        //Sending the connection request to the server and initiating the automation
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        //returning the driver to the caller for each and every test case
        return driver;
    }
}
