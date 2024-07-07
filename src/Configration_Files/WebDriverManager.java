package Configration_Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class WebDriverManager {
	private static WebDriver d;
	static Common c = new Common();
    
	public static WebDriver getDriverInstance() {
		return d;
	}
	public static WebDriver startDriver(String browser, String URL)
			throws InterruptedException, IOException {
		if (browser.equals("FF")) {
			File file=new File("drivers");
			String browerPath=file.getAbsolutePath()+"//wires.exe";
			System.setProperty("webdriver.gecko.driver", browerPath);
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			capabilities.setCapability("acceptSslCerts", false);
			capabilities.setCapability("acceptInsecureCerts", false);
			d.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		}
		if (browser.equals("CH")) {
			File file=new File("drivers");
			String browerPath=file.getAbsolutePath()+"//chromedriver";
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			System.setProperty("webdriver.chrome.driver",browerPath);
			 d = new ChromeDriver(options);
		}
		if (browser.equals("IE")) {
			try {
				File file=new File("drivers");
				String browerPath=file.getAbsolutePath()+"//IEDriverServer";
				DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
				capabilitiesIE.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				capabilitiesIE.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
				System.setProperty("webdriver.ie.driver",browerPath);
				System.out.println(System.getProperty("webdriver.ie.driver"));
				// d = new RemoteWebDriver(new
				// URL("http://192.168.0.151:4444/wd/hub"), capabilitiesIE);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//JavascriptExecutor executor = (JavascriptExecutor) d;
		//executor.executeScript("window.resizeTo(1920, 1080);");
		d.get(URL);
		Thread.sleep(2000);
		//d.manage().window().maximize();
		if (browser.equals("IE")) {
			d.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		return d;
	}

	public static void stopDriver() {
		//d.manage().deleteAllCookies();
		d.quit();
	}

	public WebElement fluentWait(final String loc) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(d).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(c.getElementName(loc)));
			}
		});

		return foo;
	};

	public static void highlightElement(WebElement element) {
		for (int i = 0; i < 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 2px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
		}
	}

	public String getparam(String sheetname, int indx) throws Exception {
		ReadXclData rddata = new ReadXclData();
		ArrayList<String> arr = new ArrayList<>();
		String[][] t = rddata.readdata(sheetname);
		for (String[] rt : t) {
			for (String val : rt) {
				arr.add(val);
			}
		}
		return arr.get(indx);
	}

}
