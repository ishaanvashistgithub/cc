package read_tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Configration_Files.WebDriverManager;
import Configration_Files.XLUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readandwriteexcelclass {
    WebDriver driver;

    @Test
    public void loginTest() throws IOException, InterruptedException {
     

    	
    	// Initialize WebDriver (assuming ChromeDriver for this example)
        System.setProperty("webdriver.chrome.driver", "/Users/ishaanvashist/Downloads/Get_Tags/drivers/chromedriver");
        driver = new ChromeDriver();
    	
		Thread.sleep(10000);
		//get collage name and iterate
		

        // Specify the path to the Excel file
        File file = new File("/Users/ishaanvashist/Downloads/Get_Tags/Datafiles/collectdataDemo.xlsx");

        // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(file);

        // Create a Workbook object
        Workbook workbook = WorkbookFactory.create(fis);

        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Iterate through rows
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            // Get cell data from the row
            Row row = sheet.getRow(i);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            // Execute your Selenium WebDriver test with the data
            performLogin(username, password);
            Thread.sleep(4000);
try {
	

	       
         WebElement verificationelement = driver.findElement(By.xpath("//summary[@class='hx_rsm-trigger btn']"));
         
         if(verificationelement.isDisplayed()) {
            
            
           
                System.out.println("Login passed");
                XLUtilities.writereportxlsxworkbookpresent(2, i, "Login passed");
            }
            
}
            
            catch (Exception e) {
				// TODO: handle exception
                System.out.println("Login failed");

                XLUtilities.writereportxlsxworkbookpresent(2, i, "Login failed");
			}
			
          
        
          //driver.quit();
        // Close the browser
        //driver.close();

        // Close the workbook and FileInputStream
        workbook.close();
        fis.close();
      
    try {    
    	
        WebElement verificationelementsecondstage = driver.findElement(By.xpath("//summary[@class='hx_rsm-trigger btn']"));

    	
    	
    	
        if (verificationelementsecondstage.isDisplayed()) {
           
        	driver.findElement(By.xpath("//span[contains(@class,'Button-label')]//img[contains(@class,'avatar circle')]")).click();
        	Thread.sleep(2000);
        	
        	driver.findElement(By.xpath("//span[normalize-space()='Sign out']")).click();
        	Thread.sleep(4000);
        	
        	
        	driver.findElement(By.xpath("//input[@value='Sign out from all accounts']")).click();
        	Thread.sleep(2000);
        	
        	
        	driver.findElement(By.xpath("//a[normalize-space()='Sign in']  ")).click();
        	Thread.sleep(2000);
        	
        }
        
        
        }
        

        
    catch (Exception e) {
		// TODO: handle exception
	System.out.println(e.getMessage());
	
    
    }   
    
        
        
        
        }   
      
        
  
    }

    private void performLogin(String username, String password) throws InterruptedException, IOException {
        // Open the login page
        driver.get("https://github.com/login");
    	//WebDriverManager.startDriver("CH","https://github.com/login");

        driver.manage().window().maximize();

        WebElement usernameInput = driver.findElement(By.id("login_field"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='commit']"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        // Perform assertions or additional steps as needed
    }
}
