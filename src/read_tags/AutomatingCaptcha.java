

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class AutomatingCaptcha {
	 static WebDriver driver;
     
	@Test
    public static void main(String[] args) {
    	 System.setProperty("webdriver.chrome.driver", "/Users/ishaanvashist/Downloads/Get_Tags/drivers/chromedriver");
         driver = new ChromeDriver();
        
         try {
            // Open the website with CAPTCHA
            driver.get("https://example.com");

            // Locate the CAPTCHA element
            WebElement captchaElement = driver.findElement(By.id("captcha"));

            // Extract the CAPTCHA image source URL
            String captchaImageUrl = captchaElement.getAttribute("src");

            // Use a third-party CAPTCHA solving service (e.g., 2Captcha) to get the solution
            String captchaSolution = solveCaptchaWith2Captcha(captchaImageUrl, "YOUR_2CAPTCHA_API_KEY");

            // Enter the solution into the CAPTCHA input field
            WebElement captchaInput = driver.findElement(By.id("captchaInput"));
            captchaInput.sendKeys(captchaSolution);

            // Now, you can continue with the rest of your automation

        } finally {
            driver.quit();
        }
    }

    private static String solveCaptchaWith2Captcha(String captchaImageUrl, String apiKey) {
        // Implement logic to send the CAPTCHA image to 2Captcha and get the solution
        // You need to make HTTP requests to 2Captcha API using your API key
        // Refer to 2Captcha documentation for details
        return "CAPTCHA_SOLUTION";
    }
}
