/*This class tests the create ticket activity and then, verifies the presence of the ticket in the
* respective status activity
* Author: Rishabh Madan
*/
package shitpticketdesk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CreateTicket extends WalkthroughLogin {
    public static void createTicket() throws InterruptedException {

        //Inheriting the properties of the driver from the Walkthrough
        //So, the dashboard is not considered as a completely new activity
        //and it doesn't destroy the automation process
        AndroidDriver<AndroidElement> driver = WalkthroughLogin.driver;

        Thread.sleep(6000);

        //First of all clicking on create ticket button on the dashboard
        driver.findElementById("com.pb.shipticketdesk:id/ll_create_ticket").click();
        //Waiting for the CreateTicket screen to load
        Thread.sleep(4000);

        //Entering the text in the fields to make sure to create the ticket
        //1. Enter Name
        //2. Enter Email ID
        //3. Subject
        //4. Input the description of the ticket
        //5. Set the priority for the ticket
        //6. Set the status for the ticket
        //7. Tap on create ticket
        //8. Repeat steps 1 to 7 but this time tap on Discard button
        driver.findElementById("com.pb.shipticketdesk:id/text_name")
                .sendKeys("Test Ticket");
        driver.findElementById("com.pb.shipticketdesk:id/text_email")
                .sendKeys("test@test.com");
        driver.findElementById("com.pb.shipticketdesk:id/et_subject")
                .sendKeys("Test Emergency");
        driver.navigate().back();
        driver.findElementById("com.pb.shipticketdesk:id/et_ticket_description")
                .sendKeys("This is a test ticket generated using Appium");
        driver.navigate().back();
        driver.findElementById("com.pb.shipticketdesk:id/button_priority").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\""+ priorityRand() +"\")").click();
        Thread.sleep(2000);
        driver.findElementById("com.pb.shipticketdesk:id/button_status").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\""+ statusRand() +"\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"Create\")").click();

        Thread.sleep(5000);
        //Simulating the Action for discard button
        driver.findElementById("com.pb.shipticketdesk:id/ll_create_ticket").click();
        //Waiting for the CreateTicket screen to load
        Thread.sleep(4000);

        driver.findElementById("com.pb.shipticketdesk:id/text_name")
                .sendKeys("Test Ticket");
        driver.findElementById("com.pb.shipticketdesk:id/text_email")
                .sendKeys("test@test.com");
        driver.findElementById("com.pb.shipticketdesk:id/et_subject")
                .sendKeys("Test Emergency");
        driver.navigate().back();
        driver.findElementById("com.pb.shipticketdesk:id/et_ticket_description")
                .sendKeys("This is a test ticket generated using Appium");
        driver.navigate().back();
        driver.findElementById("com.pb.shipticketdesk:id/button_priority").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\""+ priorityRand() +"\")").click();
        Thread.sleep(2000);
        driver.findElementById("com.pb.shipticketdesk:id/button_status").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\""+ statusRand() +"\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"Discard\")").click();
    }

    //function to return random priority to the caller
    public static String priorityRand(){
        String[] priorities = {"Low", "Medium", "High", "Urgent"};
        return priorities[(int)Math.random() * priorities.length];
    }

    //function to return random status to the caller
    public static String statusRand() {
        String[] status = {"Open", "Pending", "Closed", "Resolved"};
        return status[(int)Math.random() * status.length];
    }
}
