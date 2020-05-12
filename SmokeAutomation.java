package AutomationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SmokeAutomation{
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		//System.setProperty("Webdriver.chrome.driver", "D:\\Jar Files\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		}
	
	@Test(priority =1)
	public void verifyTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page Title Is:"+ title);
		Assert.assertEquals(title, "Login - My Store");
	}
	
	@Test(priority =2)
	public void VerifyLogoTest() {
		boolean flag = driver.findElement(By.xpath("//img[@class = \'logo img-responsive\']")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =3)
	public void verifySignInTest() {
		boolean flag = driver.findElement(By.cssSelector("#login_form")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =4)
	public void verifySignInLabelTest() {
		String label = driver.findElement(By.xpath("//h3[contains(text(), \'Already registered\')]")).getText();
		Assert.assertEquals(label, "ALREADY REGISTERED?");
	}
	
	@Test(priority =5)
	public void verifyUsernameLabelTest() {
		String label = driver.findElement(By.xpath("//*[@id='login_form']/div/div[1]/label")).getText();
		Assert.assertEquals(label, "Email address");
	}
	
	@Test(priority =6)
	public void verifyUserTextboxTest(){
		boolean flag = driver.findElement(By.cssSelector("#email")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =7)
	public void verifyPasswordLabelTest() {
		String label = driver.findElement(By.xpath("//label[text() = \"Password\"]")).getText();
		Assert.assertEquals(label, "Password");
	}
	
	@Test(priority =8)
	public void verifyPasswordTextboxTest(){
		boolean flag = driver.findElement(By.cssSelector("#passwd")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@Test(priority =9)
	public void verifySignInButtonTest(){
		boolean flag = driver.findElement(By.cssSelector("#SubmitLogin")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@Test(priority=10)
	public void verifyValidIEmailIdPasswordTest()  {
	 driver.findElement(By.cssSelector("#email")).sendKeys("chaudhari.moni789@gmail.com");
	 driver.findElement(By.cssSelector("#passwd")).sendKeys("Monika@123");
	 driver.findElement(By.cssSelector("#SubmitLogin")).click();
		
	}
	
	@Test(priority=11)
	public void verifyInvalidEmailIdTest() {
		 driver.findElement(By.cssSelector("#email")).sendKeys("chaudhaaari.moni789@gmail.com");
		 driver.findElement(By.cssSelector("#passwd")).sendKeys("Monika@123");
		 driver.findElement(By.cssSelector("#SubmitLogin")).click();
			System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
		}
	@Test(priority=12)
	public void verifyInvalidPasswordTest()  {
		 driver.findElement(By.cssSelector("#email")).sendKeys("chaudhari.moni789@gmail.com");
		 driver.findElement(By.cssSelector("#passwd")).sendKeys("Monia@123");
		 driver.findElement(By.cssSelector("#SubmitLogin")).click();
			System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
	}
	
	@Test(priority=13)
	public void verifyInvalidEmailIdPasswordTest() {
		 driver.findElement(By.cssSelector("#email")).sendKeys("chaudhari.monika789@gmail.com");
		 driver.findElement(By.cssSelector("#passwd")).sendKeys("Monia@123");
		 driver.findElement(By.cssSelector("#SubmitLogin")).click();
			System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
	}
	
	@Test(priority=14)
	public void verifyBlankEmailIdPasswordTest() {
		 driver.findElement(By.cssSelector("#email")).sendKeys("");
		 driver.findElement(By.cssSelector("#passwd")).sendKeys("");
		 driver.findElement(By.cssSelector("#SubmitLogin")).click();
			System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
	}
	
	@Test(priority=15)
	public void verifyBlankEmailIdTest() {
		 driver.findElement(By.cssSelector("#email")).sendKeys("");
		 driver.findElement(By.cssSelector("#passwd")).sendKeys("Monika@123");
		 driver.findElement(By.cssSelector("#SubmitLogin")).click();
			System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
	}
	
	@Test(priority=16)
	public void verifyBlankPasswordTest() {
		 driver.findElement(By.cssSelector("#email")).sendKeys("chaudhari.monika789@gmail.com");
		 driver.findElement(By.cssSelector("#passwd")).sendKeys("");
		 driver.findElement(By.cssSelector("#SubmitLogin")).click();
			System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
	}
	
	@Test(priority=17)
	public void verifyForgotPasswordTest() {
		 boolean flag=driver.findElement(By.cssSelector("a[title = 'Recover your forgotten password']")).isDisplayed();
		 Assert.assertTrue(flag);
	}
	
	@Test(priority=18)
	public void verifyForgotPasswordOperationTest() {
		 driver.findElement(By.cssSelector("a[title = 'Recover your forgotten password']")).click();
	 }
	
	@Test(priority=19)
	public void verifyForgotPasswordEmailIdTest() {
		boolean flag = driver.findElement(By.cssSelector("#email")).isDisplayed();
		Assert.assertTrue(flag);
	 }
	
	@Test(priority=20)
	public void verifyForgotPasswordBlankEmailIdTest() {
		driver.findElement(By.cssSelector("a[title = 'Recover your forgotten password']")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("");
		driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
	 }
	
	@Test(priority=21)
	public void verifyForgotPasswordInvalidEmailIdTest() {
		driver.findElement(By.cssSelector("a[title = 'Recover your forgotten password']")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("monika@gmail.com");
		driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
	}
	
	@Test(priority=22)
	public void verifyForgotPasswordValidEmailIdTest() {
		driver.findElement(By.cssSelector("a[title = 'Recover your forgotten password']")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("chaudhari.moni789@gmail.com");
		driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert")).getText());
	}
	
	@Test(priority=23)
	public void verifyBackToButtonTest() {
		driver.findElement(By.cssSelector("a[title = 'Recover your forgotten password']")).click();
		boolean flag=driver.findElement(By.cssSelector("li>a.btn.btn-default.button.button-small")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=24)
	public void verifyBackToButtonClickOnTest() {
		driver.findElement(By.cssSelector("a[title = 'Recover your forgotten password']")).click();
		driver.findElement(By.cssSelector("li>a.btn.btn-default.button.button-small")).click();
	}
	
	@Test(priority=25)
	public void verifyBackToButtonClickOnTest() {
		driver.findElement(By.cssSelector("a[title = 'Recover your forgotten password']")).click();
		driver.findElement(By.cssSelector("li>a.btn.btn-default.button.button-small")).click();
	}
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
}
