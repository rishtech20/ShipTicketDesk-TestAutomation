package Automation;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestClassTest {

  @BeforeSuite
  public void startAppium() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start C:\\startappium.bat");
		Thread.sleep(8000);
	}
  
//  @Test
//  public void A_TandC() {
//	  TandC tnc = new TandC();
//	  try {
//          tnc.testTandC();
//      }
//      catch(MalformedURLException m){
//          System.out.println("Failed to accept the T&C");
//      }
//      catch (InterruptedException e){
//          System.out.println("Failed to accept the T&C");
//      }
//  }
//  
//  @Test
//  public void B_Walkthrough() {
//	  WalkthroughLogin wtln = new WalkthroughLogin();
//	//Testing the Walkthrough screen
//      try {
//          wtln.walkTLog();
//      }
//      catch(MalformedURLException m){
//          System.out.println("Failed at walkthrough");
//      }
//      catch(InterruptedException w){
//          System.out.println("Failed at walkthrough");
//      }
//
//  }
//  
//  @Test
//  public void C_Dashboard() {
//	  Dashboard dshb = new Dashboard();
//	  //Testing the dashboard
//      try {
//         dshb.dashboard();
//     }
//     catch(InterruptedException w){
//         System.out.println("Failed at dashboard");
//     }
//  }
//  
//  @Test
//  public void D_CreateTicket() {
//	  CreateTicket crtTick = new CreateTicket();
//	//Testing Create Ticket Functionality
//      try {
//          crtTick.createTicket();
//      }
//      catch(InterruptedException w){
//          System.out.println("Failed at dashboard");
//      }
//  }
//  
//  
//  @Test
//  public void E_TicketDetails() {
//	  TicketDetailsFunct tickDet = new TicketDetailsFunct();
//	//Ticket Details functionality
//      try {
//          tickDet.ticketDetails();
//      }
//      catch(InterruptedException w){
//          System.out.println("Failed at dashboard");
//      }
//  }
//  
  
  
  
}
