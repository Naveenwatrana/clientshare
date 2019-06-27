package clientshare;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class login {
	
	
	public WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	ExtentTest logger;
	ITestResult result;

	public ExtentColor colors;

	@BeforeSuite
	public void set() {

		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// ExtentLogger logger = new ExtentLogger();
		// extent.attachReporter(logger);
	}

	@BeforeMethod

	public void beforeclass() {
		System.setProperty("webdriver.gecko.driver", "D:\\gdriver\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://uat-clientspace.herokuapp.com");
	}

	@Test(priority = 0)
	public void Invalid_creadeditals() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aamirpal@ucreate.co.in");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("est1234");
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();

		String loggedInUser = driver.findElement(By.xpath("//span[@class='error-msg text-left']")).getText();

		String sv = "The email or password you entered is incorrectwwwwww";

		sa.assertEquals(sv, loggedInUser);

		test = extent.createTest("MyFirstTest", "Sample description");
		test.log(Status.FAIL, MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));

		/*
		 * if(loggedInUser.equals(sv)) { test = extent.createTest("MyFirstTest",
		 * "Sample description"); test.log(Status.PASS,
		 * MarkupHelper.createLabel("Now this is testing pass",colors.ORANGE));
		 * 
		 * 
		 * 
		 * } else { test = extent.createTest("MyFirstTest", "Sample description");
		 * test.log(Status.FAIL,
		 * MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));
		 * 
		 * //logger.log(LogStatus.INFO, result.getThrowable());
		 * 
		 * System.out.println("This test is fail"); }
		 */

		Thread.sleep(3000);

	}

	@Test(priority = 1)
	public void Valid_Credentials() throws IOException, InterruptedException {

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aamirpal@ucreate.co.in");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();

		// creates a toggle for the given test, adds all log events under it
		test = extent.createTest("MySecond est", "Sample description");
		test.pass("navigate to client share and it is pass");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		// test.fail("details",
		// MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		// test.addScreenCaptureFromPath("screenshot.png");
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void emptylogin() {

		driver.findElement(By.xpath("//button[@id='show-sent']")).click();

		String button = driver.findElement(By.xpath("//span[contains(text(),'The password field is required')]"))
				.getText();
		String st = "The password field is required";

		if (button.equals(st)) {
			test = extent.createTest("MythirdTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("Now this is testing fail", colors.ORANGE));
		} else

		{
			test = extent.createTest("MythirdTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));
		}

	}
	
	@Test(priority= 3)
	public void Without_Email() {
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		String loggedInUser = driver.findElement(By.xpath("//span[@class='error-msg text-left']")).getText();

		String sv = "The email field is required";
		
		if(loggedInUser.equals(sv)) {
			
			
			test = extent.createTest("forthTest", "Sample descriptions");
			test.log(Status.PASS, MarkupHelper.createLabel("Now this is testing pass", colors.INDIGO));
			
		}
		else {
			test = extent.createTest("forthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));
			
		}
		
		
	}
	
	@Test(priority=4)
	public void without_Password() {
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aamirpal@ucreate.co.in");
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();
		
		String loggedUser = driver.findElement(By.xpath("//span[@class='error-msg text-left']")).getText();
		
		String nv = "The password field is required";
		
		if(loggedUser.equals(nv)) {
			test = extent.createTest("fifthTest", "Sample descriptions");
			test.log(Status.PASS, MarkupHelper.createLabel("Now this is testing pass", colors.INDIGO));
			
		}
		else {
			test = extent.createTest("fifthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));
			
		}
		
		
	}
	
	
	
	

	@Test(priority = 5)
	public void Forgot_password() { // To check that forget option redirect to the next screen or not.

		driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();

		String option = driver.findElement(By.xpath("//p[@class='reset-desc text-left']")).getText();

		String st1 = "Enter the email address associated with your account, and we’ll email you a link to reset your password.";

		if (option.equals(st1)) {
			test = extent.createTest("MysixthTest", "Sample descriptions");
			test.log(Status.PASS, MarkupHelper.createLabel("Now this is testing pass", colors.INDIGO));
		} else {
			test = extent.createTest("MysixthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));
		}

	}

	@Test(priority = 6)
	public void Forgot_passwordcheck() { // To check forget password link is working or not.

		driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sahilgupta@ucreate.co.in");
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();

		String send = driver.findElement(By.xpath("//p[@class='text-center']")).getText();

		String st2 = "If this user is registered they will receive a password reset link";

		if (send.equals(st2)) {
			test = extent.createTest("Myseventest", "Sample descriptions");
			test.log(Status.PASS, MarkupHelper.createLabel("Now this is testing pass", colors.ORANGE));
		} else {
			test = extent.createTest("MysevenTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));
		}

	}

	@Test(priority = 7)
	public void Terms_and_conditions() throws InterruptedException

	{

		driver.findElement(By.linkText("Terms and conditions")).click();

		// String conditions =
		// driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/h1[1]")).getText();

		// String terms = "Client Share Terms of Conditions and Privacy Policy";

		if (driver.getPageSource().contains("Client Share Terms of Conditions and Privacy Policy")) {
			System.out.println("Text is Present");
			test = extent.createTest("eighttest", "Sample descriptions");
			test.log(Status.PASS, MarkupHelper.createLabel("Now this is testing pass", colors.ORANGE));

		} else {
			test = extent.createTest("eightTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));

			System.out.println("Text is not Present");
		}

		Thread.sleep(5000);

	}

	@Test(priority = 8)
	public void Reset_password_validation()

	{

		driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();

		String validation = driver.findElement(By.xpath("//span[@class='error-msg text-left']")).getText();

		String text = "The email field is required";

		if (validation.equals(text)) {

			test = extent.createTest("Myninthtest", "Sample descriptions");
			test.log(Status.PASS, MarkupHelper.createLabel("Now this is testing pass", colors.ORANGE));

		} else {
			test = extent.createTest("MyninthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));

			System.out.println("Text is not Present");
		}

	}
	
	@Test(priority=9)
	public void cancel_option() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.className("bluelinks")).click();
		
		Thread.sleep(2000);
		
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "Client Share";
		
		//System.out.println(actualTitle);
		
		if (actualTitle.equals(expectedTitle)) {
			
			test = extent.createTest("Mytenthtest", "Sample descriptions");
			test.log(Status.PASS, MarkupHelper.createLabel("Now this is testing pass", colors.ORANGE));

			
		}
		else {
			test = extent.createTest("MytenthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("that's why test case is fail", colors.PURPLE));
		
	}
	}
	
	

	@AfterMethod

	public void Getresult(ITestResult testresult) {

		if (testresult.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, MarkupHelper.createLabel("This is the reason why test is fail", colors.LIME));
			test.log(Status.FAIL, testresult.getThrowable());
		}
		/*
		 * else if(testresult.getStatus()==ITestResult.SUCCESS){
		 * 
		 * test.log(Status.PASS,"pass"); }
		 */
		else if (testresult.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP, testresult.getThrowable());
		}

	}

	@AfterClass
	public void teardown() {

		extent.flush();

		driver.get("file:///D:/selenium%20save/clientshare/extent.html");

	}
	
	

}
