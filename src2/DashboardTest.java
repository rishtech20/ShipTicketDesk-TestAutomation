//Author: Rishabh Madan
package Automation;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DashboardTest extends Base {
	
	@Test(priority = 5)
	public void G_OpenTicket() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElementById("com.pb.shipticketdesk:id/button_open").click();
        Thread.sleep(8000);
        Assert.assertEquals("Open Tickets", driver.findElementByAndroidUIAutomator("text(\"Open Tickets\")")
                .getText());
        driver.navigate().back();
        Thread.sleep(8000);
        test = extent.createTest("Tapping on the Open Tickets Button");
		test.log(Status.INFO, "Verifying the functoinality of the Open tickets button");
	}
	
	@Test(priority = 6)
	public void I_PendingTickets() throws InterruptedException {
		driver.findElementById("com.pb.shipticketdesk:id/btn_pending").click();
        Thread.sleep(8000);
        Assert.assertEquals("Pending Tickets", driver.findElementByAndroidUIAutomator("text(\"Pending Tickets\")")
                .getText());
        driver.navigate().back();
        Thread.sleep(8000);
        test = extent.createTest("Tapping on the Pending Tickets Button");
		test.log(Status.INFO, "Verifying the functoinality of the Pending tickets button");
	}
	
	@Test(priority = 7)
	public void J_ClosedTickets() throws InterruptedException {
		driver.findElementById("com.pb.shipticketdesk:id/btn_closed").click();
        Thread.sleep(8000);
        Assert.assertEquals("Closed Tickets", driver.findElementByAndroidUIAutomator("text(\"Closed Tickets\")")
                .getText());
        driver.navigate().back();
        Thread.sleep(8000);
        test = extent.createTest("Tapping on the Closed Tickets Button");
		test.log(Status.INFO, "Verifying the functoinality of the Closed tickets button");
	}
	
	@Test(priority = 8)
	public void K_ResolvedTickets() throws InterruptedException {
		driver.findElementById("com.pb.shipticketdesk:id/btn_resolved").click();
        Thread.sleep(8000);
        Assert.assertEquals("Resolved Tickets", driver.findElementByAndroidUIAutomator("text(\"Resolved Tickets\")")
                .getText());
        driver.navigate().back();
        Thread.sleep(8000);
        test = extent.createTest("Tapping on the Resolved Tickets Button");
		test.log(Status.INFO, "Verifying the functoinality of the Resolved tickets button");   
	}
	
	@Test(priority = 9)
	public void L_AllTickets() throws InterruptedException {
		driver.findElementById("com.pb.shipticketdesk:id/ll_view_all_ticket").click();
        Thread.sleep(8000);
        Assert.assertEquals("All Tickets", driver.findElementByAndroidUIAutomator("text(\"All Tickets\")")
                .getText());
        driver.findElementByAndroidUIAutomator("text(\"All Tickets\")")
        .getText();
        driver.navigate().back();
        Thread.sleep(8000);
        test = extent.createTest("Tapping on the All Tickets Button");
		test.log(Status.INFO, "Verifying the functoinality of the All tickets button");
	}
	
	@Test(priority = 10)
	public void M_CreateTicket() throws InterruptedException {
		driver.findElementById("com.pb.shipticketdesk:id/ll_create_ticket").click();
        Thread.sleep(8000);
        Assert.assertEquals("Create Ticket", driver.findElementByAndroidUIAutomator("text(\"Create Ticket\")")
                .getText());
        driver.navigate().back();
        Thread.sleep(8000);
        test = extent.createTest("Tapping on the Create Tickets Button");
		test.log(Status.INFO, "Verifying the functoinality of the Create tickets button");
	}
	
	@Test(priority = 11)
	public void N_SwitchAccount() throws InterruptedException {
		driver.findElementByAndroidUIAutomator("text(\"Switch Account\")").click();
        Thread.sleep(8000);
        Assert.assertEquals("Switch Freshdesk Account", driver.findElementByAndroidUIAutomator("text(\"Switch Freshdesk Account\")")
                .getText());
        driver.findElementByAndroidUIAutomator("text(\"Cancel\")").click();
        test = extent.createTest("Tapping on the Switch Account Button");
		test.log(Status.INFO, "Verifying the functoinality of the Switch Account button");
	}
}
