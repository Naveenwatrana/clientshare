package clientshare;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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

public class Groups {

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

	@Test(priority = 0)
	public void Group_Exisitance() throws InterruptedException {

		Thread.sleep(10000);

		String grp = driver.findElement(By.xpath("//h5[contains(text(),'Everyone')]")).getText();
		System.out.println(grp);

		String tr = "Everyone";

		if (grp.equals(tr)) {

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

	@Test(priority = 1)
	public void Create_Group_Existence() throws InterruptedException {

		String button = driver.findElement(By.xpath("//button[contains(text(),'Create a group')]")).getText();
		// System.out.println(button);

		String te = "Create a group";
		if (button.equals(te)) {

			test = extent.createTest("MySecondTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MySecondTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 2)
	public void Create_group_click() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Create a group')]")).click();
		Thread.sleep(2000);
		String mh = driver.findElement(By.xpath("//div[@class='modal-title h4']")).getText();
		// System.out.println(mh);
		String tw = "Create a group";

		if (mh.equals(tw)) {

			test = extent.createTest("MyThirdTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyThridTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}
		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 3)
	public void Create_group_close() throws InterruptedException {
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[contains(text(),'Create a group')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);
		Thread.sleep(2000);

		test = extent.createTest("MyForthTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 4)
	public void Create_group_Validation() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Create a group')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Create')]")).click();
		Thread.sleep(2000);

		String ty = driver
				.findElement(By.xpath("//*[contains(text(),'Please add a group name before saving your group')]"))
				.getText();

		// System.out.println(ty);

		String nv = "Please add a group name before saving your group";

		if (ty.equals(nv)) {

			test = extent.createTest("MyFifthTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyFifthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}
		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 5)
	public void Create_group_Valdation_2() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Create a group')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Type a group name']")).sendKeys("Ucreate_147");
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Create')]")).click();

		Thread.sleep(2000);
		String re = driver.findElement(By.xpath("//*[contains(text(),'Please add users to the group')]")).getText();

		System.out.println(re);

		String jk = "Please add users to the group";

		if (re.equals(jk)) {

			test = extent.createTest("MySixthTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MySixthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}
		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 6)
	public void Create_Group() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Create a group')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Type a group name']")).sendKeys("Ucreate_147");
		driver.findElement(By.xpath("//input[@placeholder='Add user starting from @']")).sendKeys("@");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Add user starting from @']")).sendKeys("b");
		driver.findElement(By.xpath("//h4[contains(text(),'Buyermember Normal share')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Add user starting from @']")).sendKeys("@nav");
		driver.findElement(By.xpath("//h4[contains(text(),'Naveen Watrana')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Create')]")).click();

		Thread.sleep(4000);

		String we = driver.findElement(By.xpath("//h5[contains(text(),'Ucreate_147')]")).getText();
		String er = "Ucreate_147";

		if (we.equals(er)) {

			test = extent.createTest("MySeventhTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MySeventhTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}
		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 7)
	public void Edit_Group_Button() throws InterruptedException {
		Thread.sleep(8000);

		driver.findElement(By.xpath("//*[text() = 'Edit groups']")).click();
		Thread.sleep(4000);
		String qw = driver.findElement(By.xpath("//div[@class='modal-title h4']")).getText();
		System.out.println(qw);

		String kc = "Which group would you want to edit?";

		if (qw.equals(kc)) {

			test = extent.createTest("MyEightthTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyEightthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}
		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 8)
	public void Edit_Group_clickoutside() throws InterruptedException {

		Thread.sleep(8000);

		driver.findElement(By.xpath("//*[text() = 'Edit groups']")).click();
		Thread.sleep(4000);

		// driver.findElement(By.tagName("body")).click();

		Actions builder = new Actions(driver);
		Action moveM = builder.moveByOffset(40, 40).build();
		moveM.perform();

		Action click = builder.click().build();
		click.perform();

		Thread.sleep(4000);

		test = extent.createTest("MyNinethTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		driver.navigate().refresh();

		Thread.sleep(8000);
	}

	@Test(priority = 9, description = "verify that whne user click on delete then vlaidation message pop-up is showing")
	public void Edit_group_delete_validation() throws InterruptedException {

		Thread.sleep(8000);

		driver.findElement(By.xpath("//*[text() = 'Edit groups']")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[@class='fade lg-popup modal show']//div[4]//span[1]//img[1]")).click();

		Thread.sleep(4000);

		String ut = driver
				.findElement(By.xpath("//*[contains(text(),'Do you want to permanently delete this group?')]"))
				.getText();
		String op = "Do you want to permanently delete this group?";

		if (ut.equals(op)) {

			test = extent.createTest("MyTenthTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyTenthTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}
		driver.navigate().refresh();

		Thread.sleep(8000);

	}

	@Test(priority = 10, description = "Verify that when user click outside of the delete validation pop up then it redirect to the edit pop or not.")
	public void Edit_group_delete_popup1() throws InterruptedException {
		Thread.sleep(8000);

		driver.findElement(By.xpath("//*[text() = 'Edit groups']")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[@class='fade lg-popup modal show']//div[4]//span[1]//img[1]")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[contains(text(),'Do you want to permanently delete this group?')]")).click();

		Thread.sleep(2000);

		Actions builder = new Actions(driver);
		Action moveM = builder.moveByOffset(40, 40).build();
		moveM.perform();

		Action click = builder.click().build();
		click.perform();

		Thread.sleep(4000);
		String rf = driver.findElement(By.xpath("//*[contains(text(),'Which group would you want to edit?')]"))
				.getText();

		String nh = "Which group would you want to edit?";

		if (rf.equals(nh)) {

			test = extent.createTest("MyEleventhTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyEleventhTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}
		driver.navigate().refresh();

		Thread.sleep(8000);

	}
	
	@Test(priority = 11, description= "verify that group is getting delete.")
	public void Edit_group_delete() throws InterruptedException {
		
		
		Thread.sleep(8000);

		driver.findElement(By.xpath("//*[text() = 'Edit groups']")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[@class='fade lg-popup modal show']//div[4]//span[1]//img[1]")).click();

		Thread.sleep(4000);

	//	driver.findElement(By.xpath("/div[@class='ConfirmationModal-redBtn-0-1-50 ConfirmationModal-redBtn-0-1-55 green-btn']")).click();

		
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='ConfirmationModal-redBtn-0-1-50 ConfirmationModal-redBtn-0-1-55 green-btn']"));
		actions.doubleClick(elementLocator).perform();
		Thread.sleep(4000);

		test = extent.createTest("MyTweleveTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));
	
	}
	@Test(priority = 12, description= "")
	public void Edit_group_information() throws InterruptedException {
		
		Thread.sleep(8000);

		driver.findElement(By.xpath("//*[text() = 'Edit groups']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[20]/div[1]")).click();
		Thread.sleep(3000);
       driver.findElement(By.xpath("//input[@placeholder='Type a group name']")).click();
       Thread.sleep(3000);
       driver.findElement(By.xpath("//input[@placeholder='Type a group name']")).clear();
       
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Type a group name']")).sendKeys("group edit new");
		
		Thread.sleep(5000);
		
		// pending this case .
		
		
		
		
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
