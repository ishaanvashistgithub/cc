package read_tags;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.WebDriverManager;
import Configration_Files.XLUtilities;


public class NewTest {
	 ReadXclData xl= new ReadXclData();
	 XLUtilities xx= new XLUtilities();
	 

	 WebDriver driver;
	 
		@Test(dataProvider = "UserEnrollment", description = " User Unenrollment Process")
		public void UserCheck_and_UnenrollMent(String recordID, String corprateKey, String courseName, String Email,
				String UnenrolledFromSLP, String RemovedFromInvoicing, String Comment, String EnrollmentStart_Date,
				String Unenrollment_Date, String CourseNameRemovedFrom, String ErrorMessage)
						throws InterruptedException, IOException {

 // @Test(priority = 1, description = "Verify Version Transactions Monitoring Foundations course")
 // public void read_data() throws Exception {
		WebDriverManager.startDriver("CH","https://www.thrifted.com");
		Thread.sleep(10000);
		//get college name and iterate
		WebDriver driver= WebDriverManager.getDriverInstance();
		//WebDriverWait wait = new WebDriverWait(driver,30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[normalize-space()='Name of institution']")));
		
		//WebElement element = driver.findElement(By.xpath("//tbody"));
		//List<WebElement> rows = element.findElements(By.tagName("tr"));
		/*try { */
		//section[@class='widget rankings-widget player-rankings-full-table ']		
		 
		 WebElement playerstable = driver.findElement(By.xpath("//section[@class='widget rankings-widget player-rankings-full-table ']"));
		 List<WebElement> rows = playerstable.findElements(By.tagName("tr"));
		 
		//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[4]/table[1]/tbody[1]/tr[" + themain+  "]/td[3]/span[2]
		 
		
		 for(int themain = 1; themain<=rows.size(); themain++)
			 
		 {
			//tbody/tr[2]/td[2]
			 
			 //String playa =driver.findElement(By.xpath("//tbody/tr[" + themain+ "]/td[2]")).getText();
			 
			 String playa =driver.findElement(By.xpath("//tbody/tr[" + themain+ "]/td[5]")).getText();

				System.out.println("Count:" +themain+ " -->"+playa+ " is selected from table");

			// System.out.println(playa);
				xl.writereport(1, themain, playa);
				
				
				
		
	

		 
		 }
		 
  } 
		 
		 
		 
   @Test(priority = 2, description = "Verify Version Transactions Monitoring Foundations course")
   public void two() throws InterruptedException
		 {	

	   //WebElement UserNameSearch = driver.findElement(By.name("username"));

		// Trims Corporate Keys after remove spaces
		//String cp = corprateKey.trim();
		 }
		
		
   
   
   
		 
		/* 
		 for (int rownum = 33; rownum <= 34; rownum++) {
				String UnivrsityName=driver.findElement(By.xpath("//tbody/tr[" + rownum+ "]/td[1]/a[1]")).getText();
				//Reporter.log("Count:" +rownum+ " -->"+UnivrsityName+ " is selected from table");
				System.out.println("Count:" +rownum+ " -->"+UnivrsityName+ " is selected from table");
				xl.writereport(1, rownum, UnivrsityName);
			    driver.findElement(By.xpath("//tbody/tr[" + rownum+ "]/td[1]/a[1]")).click();
				Thread.sleep(1000);
				
				driver.navigate().back();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[normalize-space()='Name of institution']")));
			    Thread.sleep(2000);
				
			}
				
			
				
				//Get Facilities & overview
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Facilities &Overview']")));
				driver.findElement(By.xpath("//a[normalize-space()='Facilities &Overview']")).click();
				Thread.sleep(500);
				try {
					if(driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]//pre[1]")).isDisplayed())
					{
						String FacilOverview=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/pre[1]")).getText();
						System.out.println("Facilities and Overview :  "+FacilOverview);
						xl.writereport(2, rownum, FacilOverview);
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				
				//Get Department
				driver.findElement(By.xpath("//a[normalize-space()='Department']")).click();
				Thread.sleep(500);
				try {
					if(driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]//pre[1]")).isDisplayed())
					{
					String Dept=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/pre[1]")).getText();
					System.out.println("Department :  "+Dept);
					Thread.sleep(500);	
					xl.writereport(3, rownum, Dept);
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				
				//Get scholarship
				driver.findElement(By.xpath("//a[normalize-space()='Scholarship']")).click();
				Thread.sleep(1000);
				try {
					if(driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[3]/div[1]//pre[1]")).isDisplayed())
					{
					String scholarship=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[3]/div[1]/pre[1]")).getText();
					System.out.println("Scholarship :  "+scholarship);
					Thread.sleep(1000);
					xl.writereport(4, rownum, scholarship);
					}
				} catch (Exception e) {
					// TODO: handle exceptions
					System.out.println(e.getMessage());
				}
				
				//Get courses
				driver.findElement(By.xpath("//a[normalize-space()='Courses']")).click();
				Thread.sleep(1000);
				try {
					if(driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[4]/div[1]//pre[1]")).isDisplayed())
					{
					String courcses=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[4]/div[1]/pre[1]")).getText();
					System.out.println("courses :  "+courcses);
					Thread.sleep(1000);
					xl.writereport(5, rownum, courcses);
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				//get university video
				driver.findElement(By.xpath("//a[normalize-space()='University Video']")).click();
				Thread.sleep(1000);
				try {
					if(driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[4]/div[1]//pre[1]")).isDisplayed())
					{
					String Uni=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[5]/div[1]/pre[1]")).getText();
					System.out.println("University video :  "+Uni);
					Thread.sleep(1000);
					xl.writereport(6, rownum, Uni);
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				System.out.println("---------------------------------------------------------------------------------");
				Reporter.log("---------------------------------------------------------------------------------");		 
				Thread.sleep(2000);
				driver.navigate().back();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[normalize-space()='Name of institution']")));
			    Thread.sleep(2000);
			
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println(e.getMessage());
		}
		*/
  }
 

