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

	/*
	 * @BeforeMethod
	 * 
	 * public void beforeclass() { System.setProperty("webdriver.gecko.driver",
	 * "D:\\gdriver\\geckodriver.exe");
	 * 
	 * driver = new FirefoxDriver();
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * driver.get("https://uat-clientspace.herokuapp.com");
	 * 
	 * driver.findElement(By.xpath("//input[@id='email']")).sendKeys(
	 * "aamirpal@ucreate.co.in");
	 * driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test1234");
	 * driver.findElement(By.xpath("//button[@id='show-sent']")).click();
	 * 
	 * }
	 */

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
		String re = driver.findElement(By.xpath("//*[text()= 'Where do you want to post? Choose a category:']"))
				.getText();

		String rt = "Where do you want to post? Choose a category:";

		if (re.equals(rt)) {

			test = extent.createTest("MySecondTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("Second test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MySecondTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("Second test case is FAIL", colors.LIME));

		}

		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 2, description = "To check user is able to select the category ")
	public void select_category() throws InterruptedException {

		Thread.sleep(8000);

		driver.findElement(By.xpath("//button[contains(text(),'Post')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//h5[contains(text(),'Management Information')]")).click();

		String pr = driver.findElement(By.xpath("//*[text()= 'Who should see this? Choose a group:']")).getText();
		String rp = "Who should see this? Choose a group:";

		if (pr.equals(rp)) {

			test = extent.createTest("MyThirdTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("Third test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyThirdTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("Thrid test case is FAIL", colors.LIME));

		}

		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 3, description = "To check user is able to select the group ")
	public void select_group() throws InterruptedException {

		Thread.sleep(8000);

		driver.findElement(By.xpath("//button[contains(text(),'Post')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//h5[contains(text(),'Management Information')]")).click();

		driver.findElement(By.xpath("//h5[contains(text(),'Everyone')]")).click();

		String yu = driver.findElement(By.xpath("//input[@placeholder='Subject']")).getText();
		String uy = "Subject";

		Thread.sleep(3000);

		System.out.println(uy);
		if (yu.equals(uy)) {

			test = extent.createTest("MyForthTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("forth test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyForthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("forth test case is FAIL", colors.LIME));

		}

		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 4, description = "to check validation message when user doesn't enter the text in the field")
	public void Validation_check() throws InterruptedException {

		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[contains(text(),'Post')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//h5[contains(text(),'Management Information')]")).click();

		driver.findElement(By.xpath("//h5[contains(text(),'Everyone')]")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Post')]")).click();

		Thread.sleep(4000);

		String nb = driver.findElement(By.xpath("//*[text()= 'Please add a post subject']")).getText();
		String bn = "Please add a post subject";

		if (nb.equals(bn)) {

			test = extent.createTest("MyFifthtTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("fifth test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyFifthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("fifth test case is FAIL", colors.LIME));

		}

		driver.navigate().refresh();

		Thread.sleep(8000);
	}

	@Test(priority = 5, description = "add a post without attachment")
	public void add_post_without_attachment() throws InterruptedException {

		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[contains(text(),'Post')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//h5[contains(text(),'Management Information')]")).click();

		driver.findElement(By.xpath("//h5[contains(text(),'Everyone')]")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@placeholder='Subject']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(" this is the new post");
		driver.findElement(By.xpath("//textarea[@placeholder='What do you want to talk about?']"))
				.sendKeys("KL Rahul had watched this carnage from 22 yards away. That too can have an"
						+ " unsettling effect; for when Henry ran in to bowl his second over�with three slips and five fielders in catching posiA\r\n"
						+ "\r\n"
						+ "tions�the very first ball tickled Rahul�s bat and landed in Rod Latham�s gloves. From this position of 5 for three after 3.1 overs� and especially due to India�s"
						+ " hitand-miss middle order�sponging up the pressure seemed an improbable task. Promptly the team found itself on 24 for four at the 10-over mark, the new low in this World Cup�s powerplays.");

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Post')]")).click();

		Thread.sleep(8000);

		String ui = driver.findElement(By.xpath("//h3[contains(text(),'this is the new post')]")).getText();
		String iu = "this is the new post";

		if (ui.equals(iu)) {

			test = extent.createTest("MyFifthtTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("fifth test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyFifthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("fifth test case is FAIL", colors.LIME));

		}

		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 6, description = "")

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
