package TestPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DialerAutomatoin {

	public static void main(String[] args) throws InterruptedException {
		
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
        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity("com.android.dialer.main.impl.MainActivity");

        // Optional capabilities
        options.setNoReset(true);  // To prevent app reset
        options.setAutoGrantPermissions(true);  // Automatically grant app permissions

        try {
            // Set the URL for Appium Server
            URL appiumUrl = new URL("http://localhost:4723/wd/hub");

            // Create AndroidDriver instance
            AndroidDriver driver = new AndroidDriver(appiumUrl, options);
          
            
            driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
            driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
            driver.findElement(By.id("com.google.android.dialer:id/one")).click();
            driver.findElement(By.id("com.google.android.dialer:id/six")).click();
            driver.findElement(By.id("com.google.android.dialer:id/two")).click();
            driver.findElement(By.id("com.google.android.dialer:id/four")).click(); 
            
            Thread.sleep(2000);
            
            driver.findElement(By.id("com.google.android.dialer:id/dialpad_voice_call_button")).click(); 
            
            Thread.sleep(4000);

            // Quit the driver at the end
            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } 

	}

}
