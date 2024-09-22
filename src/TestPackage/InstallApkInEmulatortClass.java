package TestPackage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;

public class InstallApkInEmulatortClass {

    public static void main(String[] args) {
        // Create UiAutomator2Options object to set the device/app configuration
        UiAutomator2Options options = new UiAutomator2Options();

        // Set the device name or use "Android Emulator" for emulators
        options.setDeviceName("Android Emulator");

        // Set the platform name (Android or iOS)
        options.setPlatformName("Android");

        // Set the platform version of the device or emulator
        options.setPlatformVersion("13.0"); // Example: use the correct Android version

        // Set the path to the app's APK file
        options.setApp("C:\\Users\\TM\\Documents\\GitHub\\GAZI_GROUP\\app\\build\\outputs\\apk\\debug\\app-debug.apk");

        // Set the automation engine to "UiAutomator2" (recommended for Android)
        options.setAutomationName("UiAutomator2");
        

        // Optional capabilities
        options.setNoReset(true);  // To prevent app reset
        options.setAutoGrantPermissions(true);  // Automatically grant app permissions

        try {
            // Set the URL for Appium Server
            URL appiumUrl = new URL("http://localhost:4723/wd/hub");

            // Create AndroidDriver instance
            AndroidDriver driver = new AndroidDriver(appiumUrl, options);
            
            driver.findElement(null).click();

            // Perform any actions with driver here...
            System.out.println("App launched successfully!");

            // Quit the driver at the end
            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
