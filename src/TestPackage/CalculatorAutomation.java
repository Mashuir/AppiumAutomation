package TestPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculatorAutomation {

	public static void main(String[] args) {
		
		// Create UiAutomator2Options object to set the device/app configuration
        UiAutomator2Options options = new UiAutomator2Options();

        // Set the device name or use "Android Emulator" for emulators
        options.setDeviceName("Android");

        // Set the platform name (Android or iOS)
        options.setPlatformName("Android");

        // Set the platform version of the device or emulator
        options.setPlatformVersion("14.0"); // Example: use the correct Android version

       
        // Set the automation engine to "UiAutomator2" (recommended for Android)
        options.setAutomationName("UiAutomator2");
        
        //Mobile APP Info
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        // Optional capabilities
        options.setNoReset(true);  // To prevent app reset
        options.setAutoGrantPermissions(true);  // Automatically grant app permissions

        try {
            // Set the URL for Appium Server
            URL appiumUrl = new URL("http://localhost:4723/wd/hub");

            // Create AndroidDriver instance
            AndroidDriver driver = new AndroidDriver(appiumUrl, options);
          
            
            driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
            driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
            driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
            driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
            
            //Get the result
            String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
            
            //Check the result
            if(result.equals("16")) {

            System.out.println("Passed!");
             
            }else {
            	 System.out.println("Fail");
            }

            // Quit the driver at the end
            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

	}

}
