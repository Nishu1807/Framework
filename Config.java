package CrossBrowser1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Config {
	public static WebDriver driver;
	
	public static void openBrowser(String browserName) {
		switch(browserName) {
		case "Chrome":			
			System.out.println("Setting crome driver");
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			System.out.println("crome driver Setup complete ");
			break;
    	case "InternetExplorer":
    		System.out.println("Setting IE driver");
			WebDriverManager.iedriver().setup();
			//System.setProperty("webdriver.ie.driver", "D:\\Jar Files\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			System.out.println("IE driver Setup complete ");
			break;
		case "FirefoxBrowser":
			//System.setProperty("webdriver.gecko.driver", "D:\\Jar Files\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		   WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
			break;
		default:
		}
	}
	
	public static void closeBrowser() {
		System.out.println("closing driver"+ driver.getClass());
		driver.close();
	}

}
