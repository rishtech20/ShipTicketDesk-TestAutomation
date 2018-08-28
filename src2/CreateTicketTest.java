/*This class tests the create ticket activity and then, verifies the presence of the ticket in the
* respective status activity
* Author: Rishabh Madan
*/
package Automation;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CreateTicketTest extends Base {
	
	@Test(priority = 12)
	public void P_CreateTicketActivity() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElementById("com.pb.shipticketdesk:id/ll_create_ticket").click();
		Thread.sleep(4000);
	}
	
	@Test(priority = 13)
	public void Q_InputTicketDetails() throws InterruptedException {
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
		test = extent.createTest("Creating a ticket");
		test.log(Status.INFO, "Creating a random ticket and tapping on the DONE button");
	}
	
	@Test(priority = 14)
	public void R_DiscardTicket() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementById("com.pb.shipticketdesk:id/ll_create_ticket").click();
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
		test = extent.createTest("Creating a ticket");
		test.log(Status.INFO, "Creating a random ticket and tapping on the Discard button");
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
