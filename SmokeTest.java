package CrossBrowser1;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SmokeTest {
	@Parameters("BrowserName")
	@Test
	public void test1(@Optional String browserName) throws InterruptedException {
		try {
			if (browserName == null || browserName.isEmpty())
				browserName = "FirefoxBrowser";
			Config.openBrowser(browserName);
			//Config.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			Config.driver.get("http://www.automationpractice.com");
			System.out.println("Test1");
			Thread.sleep(2000);
			Config.closeBrowser();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
