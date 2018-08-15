package shitpticketdesk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.MalformedURLException;

public class Dashboard extends WalkthroughLogin {
    public static void dashboard() throws MalformedURLException, InterruptedException {

        //Inheriting the properties of the driver from the Walkthrough
        //So, the dashboard is not considered as a completely new activity
        //and it doesnt destroy the automation process
        AndroidDriver<AndroidElement> driver = WalkthroughLogin.driver;

        //Waiting for the dashboard to load
        Thread.sleep(8000);

        //Clicking on the Open Ticket and checking its functionality
        //Validating that application is in the open ticket screen and
        //Coming back to the dashboard
        driver.findElementById("com.pb.shipticketdesk:id/button_open").click();
        Thread.sleep(8000);
        if ( driver.findElementByAndroidUIAutomator("text(\"Open Tickets\")")
                .getText() == "Open Tickets"){
            System.out.println("Open Ticket button is working");
        }
        else{
            System.out.println("Open ticket doesn't work!!!!");
        }
        driver.navigate().back();
        Thread.sleep(2000);

        //clicking on the Pending Tickets and checking its functionality
        //Validating that user is in the Pending tickets screen and
        //Coming back to the dashboard
        driver.findElementById("com.pb.shipticketdesk:id/btn_pending").click();
        Thread.sleep(8000);
        if (driver.findElementByAndroidUIAutomator("text(\"Pending Tickets\")")
                .getText() == "Pending Tickets"){
            System.out.println("Pending Tickets working");
        }
        else{
            System.out.println("Pending Tickets not working");
        }
        driver.navigate().back();
        Thread.sleep(2000);

        //clicking on the Pending Tickets and checking its functionality
        //Validating that user is in the Pending tickets screen and
        //Coming back to the dashboard
        driver.findElementById("com.pb.shipticketdesk:id/btn_closed").click();
        Thread.sleep(8000);
        if (driver.findElementByAndroidUIAutomator("text(\"Closed Tickets\")")
                .getText() == "Closed Tickets"){
            System.out.println("Closed Tickets working");
        }
        else{
            System.out.println("Closed Tickets not working");
        }
        driver.navigate().back();
        Thread.sleep(2000);

        //clicking on the Resolved Tickets and checking its functionality
        //Validating that user is in the Resolved tickets screen and
        //Coming back to the dashboard
        driver.findElementById("com.pb.shipticketdesk:id/btn_resolved").click();
        Thread.sleep(8000);
        if (driver.findElementByAndroidUIAutomator("text(\"Resolved Tickets\")")
                .getText() == "Resolved Tickets"){
            System.out.println("Resolved Tickets working");
        }
        else{
            System.out.println("Resolved Tickets not working");
        }
        driver.navigate().back();
        Thread.sleep(2000);
    }
}
