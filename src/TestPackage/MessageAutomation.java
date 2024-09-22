package TestPackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class MessageAutomation {

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
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity("com.google.android.apps.messaging.main.MainActivity");

		// Optional capabilities
		options.setNoReset(true); // To prevent app reset
		options.setAutoGrantPermissions(true); // Automatically grant app permissions

		try {
			// Set the URL for Appium Server
			URL appiumUrl = new URL("http://localhost:4723/wd/hub");

			// Create AndroidDriver instance
			AndroidDriver driver = new AndroidDriver(appiumUrl, options);

			
			  driver.findElement(By.id("com.google.android.apps.messaging:id/start_chat_fab")).click();

			  WebElement searchField = driver.findElement(
					    AppiumBy.androidUIAutomator(
					        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
					        ".scrollIntoView(new UiSelector().resourceId(\"ContactSearchField\"))"
					    )
					);

			       
			        searchField.click();
			 
			        searchField.sendKeys("01624826221");




			     // Wait for the list of elements to be visible
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			        // Locate the elements in the ContactSuggestionList
			        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
			                By.xpath("//android.view.View[@resource-id='ContactSuggestionList']/android.view.View")));

			        if (!suggestions.isEmpty()) {
			            // Get the first element and click it
			            WebElement firstElement = suggestions.get(0);
			            
			            // Click the first element
			            try {
			                firstElement.click();
			            } catch (Exception e) {
			                System.out.println("Element not clickable directly, using TouchAction.");
			                
			                // If the click fails, use TouchAction as a fallback
			                TouchAction action = new TouchAction(driver);
			                action.tap(TapOptions.tapOptions().withElement(ElementOption.element(firstElement)))
			                      .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250))) // Small wait before releasing
			                      .perform();
			            }
			        } else {
			            System.out.println("No suggestions found to click.");
			        }
			        
			        
			        driver.findElement(By.id("com.google.android.apps.messaging:id/compose_message_text")).sendKeys("Hey Mashiur");
			  
			        driver.findElement(By.xpath("//android.view.View[@resource-id=\"Compose:Draft:Send\"]")).click();
			        Thread.sleep(4000);

			        driver.quit();
			 

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
