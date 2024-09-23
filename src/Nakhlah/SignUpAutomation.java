package Nakhlah;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.time.Duration;

public class SignUpAutomation {

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

        // Mobile APP Info
        options.setAppPackage("com.fintechhub.nakhlah");
        options.setAppActivity("com.fintechhub.nakhlah.authentication.SplashActivity");

        // Optional capabilities
        options.setNoReset(true);  // To prevent app reset
        options.setAutoGrantPermissions(true);  // Automatically grant app permissions

        try {
            // Set the URL for Appium Server
            URL appiumUrl = new URL("http://localhost:4723/wd/hub");

            // Create AndroidDriver instance
            AndroidDriver driver = new AndroidDriver(appiumUrl, options);

            // Wait until the LoginActivity is loaded, use an element unique to LoginActivity
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the 'registerTextView' element in LoginActivity to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.fintechhub.nakhlah:id/registerTextView")));

            // Now interact with the elements in the LoginActivity
            driver.findElement(By.id("com.fintechhub.nakhlah:id/registerTextView")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/learningPurposeRecyclerView\"]/android.widget.LinearLayout[1]")).click();
            driver.findElement(By.id("com.fintechhub.nakhlah:id/purposeContinueBtn")).click();
            
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/countryRecyclerView\"]/android.widget.LinearLayout[1]")).click();
            driver.findElement(By.id("com.fintechhub.nakhlah:id/countryContinueBtn")).click();
            
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/learningGoalRecyclerView\"]/android.widget.LinearLayout[1]")).click();
            driver.findElement(By.id("com.fintechhub.nakhlah:id/goalContinueBtn")).click();
            
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/learningJourneyRecyclerView\"]/android.widget.LinearLayout[2]")).click();
            driver.findElement(By.id("com.fintechhub.nakhlah:id/learningJourneyContinueBtn")).click();
            
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/socialTrafficRecyclerView\"]/android.widget.LinearLayout[1]")).click();
            driver.findElement(By.id("com.fintechhub.nakhlah:id/socialTrafficContinueBtn")).click();
            
            Thread.sleep(2000);
            
            driver.findElement(By.id("com.fintechhub.nakhlah:id/rememberUserNameCheckbox")).click();
            driver.findElement(By.id("com.fintechhub.nakhlah:id/privacyContinueBtn")).click();
            
            Thread.sleep(2000);
            driver.findElement(By.id("com.fintechhub.nakhlah:id/register_email")).sendKeys("abc@gmail.com");
            driver.findElement(By.id("com.fintechhub.nakhlah:id/register_userName")).sendKeys("abc");
            driver.findElement(By.id("com.fintechhub.nakhlah:id/register_password")).sendKeys("111");
            
            Thread.sleep(2000);
            driver.findElement(By.id("com.fintechhub.nakhlah:id/register_button")).click();

            Thread.sleep(6000);

            // Quit the driver at the end
            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
