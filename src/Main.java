package shitpticketdesk;

import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) {
	//Appium Main code goes here
        //creating objects for each class, i.e. each functionality
        TandC tnc = new TandC();
        WalkthroughLogin wtln = new WalkthroughLogin();
        Dashboard dshb = new Dashboard();

        //Accepting the terms and conditions - run it only once - fresh install
        try {
            tnc.testTandC();
        }
        catch(MalformedURLException m){
            System.out.println("Failed to accept the T&C");
        }
        catch (InterruptedException e){
            System.out.println("Failed to accept the T&C");
        }

        //Testing the Walkthrough screen
        try {
            wtln.walkTLog();
        }
        catch(MalformedURLException m){
            System.out.println("Failed at walkthrough");
        }
        catch(InterruptedException w){
            System.out.println("Failed at walkthrough");
        }

        //Testing the dashboard
        try {
            dshb.dashboard();
        }
        catch(MalformedURLException m){
            System.out.println("Failed at dashboard");
        }
        catch(InterruptedException w){
            System.out.println("Failed at dashboard");
        }
    }
}
