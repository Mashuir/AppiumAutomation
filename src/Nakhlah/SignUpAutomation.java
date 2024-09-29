package Nakhlah;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.netty.handler.timeout.TimeoutException;

import java.time.Duration;
import java.util.NoSuchElementException;

public class SignUpAutomation {

    public static void main(String[] args) throws InterruptedException {

    	boolean nextActivityLoaded;
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
            
            
            /*Learning Purpose Section*/
            Thread.sleep(2000);
            //Click continue button and check if it goes to next page
            driver.findElement(By.id("com.fintechhub.nakhlah:id/purposeContinueBtn")).click();
            
            By countryRecyclerView = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.fintechhub.nakhlah:id/countryRecyclerView']/android.widget.LinearLayout[1]");

            nextActivityLoaded = isElementPresent(driver, countryRecyclerView);
            
            if (nextActivityLoaded) {
                // If the next page is loaded, print a warning message
                System.out.println("Warning: 1. Learning Purpose Test Failed");
            } else {
            	System.out.println("1. Learning Purpose Test Passed");
            	driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/learningPurposeRecyclerView\"]/android.widget.LinearLayout[1]")).click();
                driver.findElement(By.id("com.fintechhub.nakhlah:id/purposeContinueBtn")).click();
            	
            }
            
            
            /*Country Section*/
            Thread.sleep(2000);
            driver.findElement(By.id("com.fintechhub.nakhlah:id/countryContinueBtn")).click();
            
            By learningRecyclerView = By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/learningGoalRecyclerView\"]/android.widget.LinearLayout[1]");
            nextActivityLoaded = isElementPresent(driver, learningRecyclerView);
            
            if (nextActivityLoaded) {
                System.out.println("Warning: 2. Country Test Failed");
            }else {
            	System.out.println("2. Country Test Passed");
            	driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/countryRecyclerView\"]/android.widget.LinearLayout[1]")).click();
                driver.findElement(By.id("com.fintechhub.nakhlah:id/countryContinueBtn")).click();
            }
            
            
            /*Learning Goal Section*/
            Thread.sleep(2000);
            driver.findElement(By.id("com.fintechhub.nakhlah:id/goalContinueBtn")).click();
            
            By goalRecyclerView = By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/learningJourneyRecyclerView\"]/android.widget.LinearLayout[2]");
            nextActivityLoaded = isElementPresent(driver, goalRecyclerView);
            
            if (nextActivityLoaded) {
                System.out.println("Warning: 3. Learning goal Test Failed");
            }else {
            	System.out.println("3. Learning goal Test Passed");
                driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/learningGoalRecyclerView\"]/android.widget.LinearLayout[1]")).click();
                driver.findElement(By.id("com.fintechhub.nakhlah:id/goalContinueBtn")).click();
            }
            
            /*Learning Journey Section*/            
            Thread.sleep(2000);
            driver.findElement(By.id("com.fintechhub.nakhlah:id/learningJourneyContinueBtn")).click();
            
            By socialRecyclerview = By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/socialTrafficRecyclerView\"]/android.widget.LinearLayout[1]");
            nextActivityLoaded = isElementPresent(driver, socialRecyclerview);
            if (nextActivityLoaded) {
                System.out.println("Warning: 4. Learning Journey Test Failed");
            }else {
            	System.out.println("4. Learning Journey Test Passed");
                driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/learningJourneyRecyclerView\"]/android.widget.LinearLayout[2]")).click();
                driver.findElement(By.id("com.fintechhub.nakhlah:id/learningJourneyContinueBtn")).click();
            }
            
            /*Social Traffic Section*/
            Thread.sleep(2000);
            driver.findElement(By.id("com.fintechhub.nakhlah:id/socialTrafficContinueBtn")).click();
            
            By checkBox = By.id("com.fintechhub.nakhlah:id/rememberUserNameCheckbox");
            
            nextActivityLoaded = isElementPresent(driver, checkBox);
            if (nextActivityLoaded) {
                System.out.println("Warning: 5. Social Traffic Test Failed");
            }else {
            	System.out.println("5. Social Traffic Test Passed");
                driver.findElement(By.xpath("//android.widget.GridView[@resource-id=\"com.fintechhub.nakhlah:id/socialTrafficRecyclerView\"]/android.widget.LinearLayout[1]")).click();
                driver.findElement(By.id("com.fintechhub.nakhlah:id/socialTrafficContinueBtn")).click();
            }
            
            /*Privacy Policy Section*/           
            Thread.sleep(2000);           
            driver.findElement(By.id("com.fintechhub.nakhlah:id/privacyContinueBtn")).click();
            
            By signUpScreen = By.id("com.fintechhub.nakhlah:id/register_email");
            
            nextActivityLoaded = isElementPresent(driver, signUpScreen);
            if (nextActivityLoaded) {
                System.out.println("Warning: 6. Privacy Policy Test Failed");
            }else {
            	System.out.println("6. Privacy Policy Test Passed");
                driver.findElement(By.id("com.fintechhub.nakhlah:id/rememberUserNameCheckbox")).click();
                driver.findElement(By.id("com.fintechhub.nakhlah:id/privacyContinueBtn")).click();
            }
            
            
            Thread.sleep(2000);
//            driver.findElement(By.id("com.fintechhub.nakhlah:id/register_email")).sendKeys("abc@gmail.com");
//            driver.findElement(By.id("com.fintechhub.nakhlah:id/register_userName")).sendKeys("abc");
//            driver.findElement(By.id("com.fintechhub.nakhlah:id/register_password")).sendKeys("111");
//            
//            Thread.sleep(2000);
//            driver.findElement(By.id("com.fintechhub.nakhlah:id/register_button")).click();
//
//            Thread.sleep(6000);
//
//            // Quit the driver at the end
//            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    
    public static boolean isElementPresent(WebDriver driver, By by) {
        // Use findElements instead of findElement to avoid exceptions
        return !driver.findElements(by).isEmpty();
    }
}
