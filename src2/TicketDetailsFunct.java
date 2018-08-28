/*
* To verify the ticket details and to make sure that following functionalities are working as expected
* 1. Tapping on a ticket loads its details
* 2. User is able to post a reply and add a note
* 3. User is able to change the status and the priority of the ticket
*
*
*/

package Automation;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class TicketDetailsFunct extends Base{
   
	@Test(priority = 15)
	public void TicketDetailsView() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElementById("com.pb.shipticketdesk:id/ll_view_all_ticket").click();
		Thread.sleep(5000);
		//verifying that there is at least one ticket in the View All tickets activity
		if (driver.findElementsById("com.pb.shipticketdesk:id/layout_container").size() > 0){
            driver.findElementsById("com.pb.shipticketdesk:id/text_customer_name").get(0).click();
        }
        else{
            System.out.println("There is no ticket to test!!!");
        }
	}
	
	@Test(priority = 16)
	public void TestReply() throws InterruptedException {
		Thread.sleep(2000);
		//Tapping on the reply button in the application
        driver.findElementByAndroidUIAutomator("text(\"Reply\")").click();
      //Inputting text in the text box
        String reply = "This is a test reply";
        driver.findElementById("com.pb.shipticketdesk:id/et_comment")
                .sendKeys(reply);
        driver.hideKeyboard();
      //Tapping on the send button
        driver.findElementByAndroidUIAutomator("text(\"Send\")").click();
	}
	
	@Test(priority = 17)
	public void ValidateReply() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(driver.findElementById("com.pb.shipticketdesk:id/text_body")
				.getText().trim().length());
		Assert.assertEquals("This is a test reply", driver.findElementById("com.pb.shipticketdesk:id/text_body")
				.getText().trim());
	}
	
	@Test(priority = 18)
	public void AddNoteTest() {
		driver.findElementById("com.pb.shipticketdesk:id/button_add_note").click();
		String note = "This is a Note...";
		driver.findElementById("com.pb.shipticketdesk:id/et_comment").sendKeys(note);
        driver.hideKeyboard();
      //Tapping on the Send button
        driver.findElementById("com.pb.shipticketdesk:id/button_send").click();
	}
	
	@Test(priority = 19)
	public void ValidateNote() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals("This is a Note...", driver.findElementById("com.pb.shipticketdesk:id/text_body")
				.getText().trim());
	}
}






















