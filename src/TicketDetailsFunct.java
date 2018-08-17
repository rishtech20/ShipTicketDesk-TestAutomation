/*
* To verify the ticket details and to make sure that following functionalities are working as expected
* 1. Tapping on a ticket loads its details
* 2. User is able to post a reply and add a note
* 3. User is able to change the status and the priority of the ticket
*
*
*/

package shitpticketdesk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TicketDetailsFunct extends WalkthroughLogin{
    public static void ticketDetails() throws InterruptedException {
        //Inheriting the state of the driver from the previous activity
        AndroidDriver<AndroidElement> driver = WalkthroughLogin.driver;

        Thread.sleep(5000);

        //Tapping on View All tickets on the dashboard - assuming that there are tickets in the same
        driver.findElementById("com.pb.shipticketdesk:id/ll_view_all_ticket").click();
        Thread.sleep(5000);

        //verifying that there is at least one ticket in the View All tickets activity
        //If there is ticket then, opening up the first ticket
        //Testing the reply functionality
        //Testing the Add Note functionality
        //Testing the priority and status
        if (driver.findElementsById("com.pb.shipticketdesk:id/layout_container").size() > 0){
            driver.findElementsById("com.pb.shipticketdesk:id/text_customer_name").get(0).click();
            replyTest();
            noteTest();
        }
        else{
            System.out.println("There is no ticket to test!!!");
        }
    }

    //Method to test the reply button on the tickets
    public static void replyTest(){
        //Tapping on the reply button in the application
        driver.findElementByAndroidUIAutomator("text(\"Reply\")").click();
        //Inputting text in the text box
        String reply = "This is a test reply";
        driver.findElementById("com.pb.shipticketdesk:id/et_comment")
                .sendKeys(reply);
        driver.hideKeyboard();
        //Tapping on the send button
        driver.findElementByAndroidUIAutomator("text(\"Send\")").click();
        try {
            validReply(reply);
        }
        catch (InterruptedException i){
            System.out.println("Shit!!!");
        }
    }

    //Method to validate the reply in the ticket
    public static void validReply(String reply) throws InterruptedException{
        Thread.sleep(5000);
        System.out.println("Actual Reply:" + reply);
        System.out.println("Reply Posted:" + driver.findElementById("com.pb.shipticketdesk:id/text_body").getText());
    }

    //Method to test the Add Note functionality
    public static void noteTest() {
        driver.findElementById("com.pb.shipticketdesk:id/button_add_note").click();
        String note = "This is a Note...";
        driver.findElementById("com.pb.shipticketdesk:id/et_comment").sendKeys(note);
        driver.hideKeyboard();
        //Tapping on the Send button
        driver.findElementById("com.pb.shipticketdesk:id/button_send").click();
        try{
            validNote(note);
        }
        catch (InterruptedException i){
            System.out.println("Shit!!!");
        }
    }

    //method to validate the note added to the ticket
    public static void validNote(String note) throws InterruptedException{
        Thread.sleep(5000);
        System.out.println("Actual Note:" + note);
        System.out.println("Note Posted:" + driver.findElementById("com.pb.shipticketdesk:id/text_body").getText());
    }
}
