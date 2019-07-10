package clientshare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Post_Feed {

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

		System.setProperty("webdriver.gecko.driver", "D:\\gdriver\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://uat-clientspace.herokuapp.com");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aamirpal@ucreate.co.in");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();

	}

	/*@BeforeMethod

	public void beforeclass() {
		System.setProperty("webdriver.gecko.driver", "D:\\gdriver\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://uat-clientspace.herokuapp.com");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aamirpal@ucreate.co.in");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();

	}*/

	@Test(priority = 0, description = "Check that post option is availble.")
     public void Check_post_option_is_availble() throws InterruptedException {
		Thread.sleep(8000);
		String tp = driver.findElement(By.xpath("//*[text()='What do you want to talk about?']")).getText();
		String sp = "What do you want to talk about?";

		if (tp.equals(sp)) {

			test = extent.createTest("MyFirstTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("First test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyFirstTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("first test case is FAIL", colors.LIME));

		}

		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 1, description = "Check the User is able to click on post button.")

	public void Click_on_post_option() throws InterruptedException {
		Thread.sleep(8000);

		driver.findElement(By.xpath("//button[contains(text(),'Post')]")).click();
		Thread.sleep(6000);
         String re = driver.findElement(By.xpath("//*[text()= 'Where do you want to post? Choose a category:']")).getText();
         
         String rt = "Where do you want to post? Choose a category:";

		if (re.equals(rt)) {

			test = extent.createTest("MyFirstTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyFirstTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

		driver.navigate().refresh();

		Thread.sleep(8000);

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
