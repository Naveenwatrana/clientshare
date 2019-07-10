package clientshare;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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

public class nav_bar {

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

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aamirpal@ucreate.co.in");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();

	}

	@Test(priority = 0)
	public void Share_button() throws InterruptedException {
		
		
		/*System.setProperty("webdriver.gecko.driver", "D:\\gdriver\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://uat-clientspace.herokuapp.com");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aamirpal@ucreate.co.in");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//button[@id='show-sent']")).click();
		
		Thread.sleep(5000);*/

		driver.findElement(By.xpath("//a[@id='shareDropdown']")).click();

		Thread.sleep(3000);

		driver.findElement(By.tagName("body")).click();
		//driver.findElement(By.xpath("//li[@class='active']//a")).click();
		
		test = extent.createTest("MyFirstTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("that's why test case is pass", colors.GREEN));

		
	}

	@Test(priority = 1)
	public void Share_buttondrop() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		driver.findElement(By.xpath("//a[@id='shareDropdown']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'CS ver:2.0')]")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "CS ver:2.0 Client Share ";
		sa.assertEquals(expectedTitle, actualTitle);

		Thread.sleep(7000);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.go(-1)");
		
		test = extent.createTest("MysecondTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("that's why test case is pass", colors.GREEN));

		
	}

	@Test(priority = 2)
	public void scroll_dropdown() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='shareDropdown']")).click();

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Unicorn')]"));

		je.executeScript("arguments[0].scrollIntoView(true);", element);

		Thread.sleep(2000);

		test = extent.createTest("MyThirdTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.GREEN));

	}

	@Test(priority = 3)
	public void search_test() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='shareDropdown']")).click();

		driver.findElement(By.xpath("//input[@id='search_share']")).sendKeys("airtel ");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'airtel / Vodafone')]")).click();

		test = extent.createTest("MyforthTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.GREEN));

	}

	@Test(priority = 4)
	public void click_outside() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='shareDropdown']")).click();
		Thread.sleep(2000);

		driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);

		test = extent.createTest("MyfifthTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 5)
	public void searchbox() throws InterruptedException {

		Thread.sleep(7000);

		driver.findElement(By.cssSelector("#global-search-box")).click();

		test = extent.createTest("MySixthTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 6)
	public void Entervalue_searchbox() throws InterruptedException {

		Thread.sleep(7000);

		driver.findElement(By.cssSelector("#global-search-box")).click();
		driver.findElement(By.cssSelector("#global-search-box")).sendKeys("fb");

		Thread.sleep(5000);
		test = extent.createTest("MySevenTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 7)
	public void Enterwrongvalue() throws InterruptedException {

		Thread.sleep(7000);

		driver.findElement(By.cssSelector("#global-search-box")).click();
		driver.findElement(By.cssSelector("#global-search-box")).sendKeys("k");

		driver.findElement(By.cssSelector("#global-search-box")).click();
		driver.findElement(By.cssSelector("#global-search-box")).sendKeys("k");
		driver.findElement(By.cssSelector("#global-search-box")).click();
		driver.findElement(By.cssSelector("#global-search-box")).sendKeys("k");
		driver.findElement(By.cssSelector("#global-search-box")).click();
		driver.findElement(By.cssSelector("#global-search-box")).sendKeys("k");

		Thread.sleep(3000);

		String value = driver.findElement(By.xpath("//span[@class='no-result']")).getText();

		String actual_value = "No result found!";

		// na.assertEquals(value, actual_value);

		if (value.equals(actual_value)) {

			test = extent.createTest("MyEightTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyEightTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}

	@Test(priority = 8)
	public void Resultscroll() throws InterruptedException {

		Thread.sleep(8000);

		driver.findElement(By.cssSelector("#global-search-box")).click();
		driver.findElement(By.cssSelector("#global-search-box")).sendKeys("g");

		Thread.sleep(5000);

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement last_value = driver.findElement(By.xpath("//ul[@class='search-dropdown']//li[10]"));

		je.executeScript("arguments[0].scrollIntoView(true);", last_value);

		Thread.sleep(2000);

		test = extent.createTest("MyninthTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 9)
	public void click_out() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("#global-search-box")).click();
		driver.findElement(By.cssSelector("#global-search-box")).sendKeys("g");

		Thread.sleep(5000);

		driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);

		test = extent.createTest("MyTenthTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 10)
	public void Notfication() throws InterruptedException {

		Thread.sleep(7000);

		WebElement element = driver.findElement(By.xpath("//div[@class='notification-wrap']"));
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();

			test = extent.createTest("MyElevanTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		}

		else {

			test = extent.createTest("MyElevanTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}

	@Test(priority = 11)
	public void Noticication_scroll() throws InterruptedException {

		Thread.sleep(7000);

		driver.findElement(By.xpath("//div[@class='notification-wrap']")).click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//div[@class='profile-wrap']//li[5]//a[1]"));

		Thread.sleep(2000);

		je.executeScript("arguments[0].scrollIntoView(true);", element);

		Thread.sleep(2000);

		test = extent.createTest("MytewlveTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 12)
	public void Notication_click() throws InterruptedException {

		Thread.sleep(7000);

		driver.findElement(By.xpath("//div[@class='notification-wrap']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='profile-wrap']//li[3]")).click();

		test = extent.createTest("MythirteenTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 13)
	public void profilepic_click() throws InterruptedException {

		// driver.findElement(By.xpath("//span[@id='user_profile_popup']")).click();

		WebElement element = driver.findElement(By.xpath("//span[@id='user_profile_popup']"));
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();

			test = extent.createTest("MyfourteenTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));
		} else {

			test = extent.createTest("MyfourteenTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}

	@Test(priority = 14)
	public void profile_popup() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='profileDropdown']")).click();

		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[@id='show_user_profile']")).click();
		Thread.sleep(5000);

		test = extent.createTest("MyfifteenTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 15)
	public void profile_popup_1() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='profileDropdown']")).click();

		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[@id='show_user_profile']")).click();
		Thread.sleep(5000);

		String title = driver.findElement(By.xpath("//h5[@class='modal-title']")).getText();
		String actual_title = "Your profile dgdegret";
		if (title.equals(actual_title)) {

			test = extent.createTest("MysixteenTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));
		} else {

			test = extent.createTest("MysixteenTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}

	@Test(priority = 16)
	public void profile_crossicon() throws InterruptedException {

		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[@id='profileDropdown']")).click();
		driver.findElement(By.xpath("//a[@id='show_user_profile']")).click();
		Thread.sleep(5000);

		// driver.findElement(By.className("close")).click();
		WebElement element = driver.findElement(By.className("close"));
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();

			test = extent.createTest("MyseventeenTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		} else {

			test = extent.createTest("MyseventeenTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}

	@Test(priority = 17)

	public void profile_update_icon() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='profileDropdown']")).click();

		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[@id='show_user_profile']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//img[@class='edit-icon']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[@class='cancel-user-name']")).click();

		test = extent.createTest("MyeighteenteenTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 18)
	public void profile_update_information() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='profileDropdown']")).click();

		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[@id='show_user_profile']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//img[@class='edit-icon']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='user_first_name']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user_first_name']")).sendKeys("Aamir");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='user_job_title']")).clear();
		driver.findElement(By.xpath("//input[@id='user_job_title']")).sendKeys("PHP DEVELOPER");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='user_bio']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@id='user_bio']"))
				.sendKeys("American entrepreneur Jeff Bezos is the founder and chief "
						+ "executive officer of Amazon.com " + "and owner of 'The Washington Post."
						+ "' His successful business ventures have made him one"
						+ " of the richest people in the world");

		driver.findElement(By.xpath("//input[@id='user_phone_number']")).clear();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='user_phone_number']")).sendKeys("9988776655");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(7000);

		driver.findElement(By.xpath("//a[@id='profileDropdown']")).click();

		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[@id='show_user_profile']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//img[@class='edit-icon']")).click();

		Thread.sleep(3000);
		String way = driver.findElement(By.xpath("//input[@id='user_job_title']")).getAttribute("value");
		String user = "PHP DEVELOPER";

		System.out.println(way);

		if (way.equals(user)) {

			test = extent.createTest("MynineteenTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));
		} else {

			test = extent.createTest("MynineteenTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}

	@Test(priority = 19)
	public void profilecpic_upload() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//a[@id='profileDropdown']")).click();

		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[@id='show_user_profile']")).click();
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//input[@id='show_profile_pic']")).click();
		Actions actions = new Actions(driver);

		WebElement element = driver.findElement(By.cssSelector("#show_profile_pic"));
		Thread.sleep(5000);
		actions.doubleClick(element).perform();

		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\auotitsave\\Autosavefolder\\upload1.exe");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(7000);

		// find the input element
		// WebElement elem = driver.findElement(By.xpath("//input[@type='file']"));
		// 'type' the file location to it as it were a usual <input type='text' />
		// element
		// elem.sendKeys("C:\\Users\\ucreate-26\\Desktop\\ph.jpg");
		test = extent.createTest("MytwentythTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 20)
	public void side_navbar() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='Community']")).click();

		Thread.sleep(5000);

		String many = driver.findElement(By.xpath("//h4[contains(text(),'Add a new member')]")).getText();
		// System.out.println(many);

		String way = "Add a new member";

		if (many.equals(way)) {

			test = extent.createTest("MytwentyoneTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		} else {

			test = extent.createTest("MytwentyoneTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}

	@Test(priority = 21)
	public void side_navbar_redirectback() throws InterruptedException {

		Thread.sleep(12000);
	
		driver.findElement(By.xpath("//a[@title='Community']")).click();

		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.go(-1)");
		Thread.sleep(6000);

		test = extent.createTest("MytwentytwoTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 22)
	public void side_navbar_hover() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//a[@title='File View']"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();
		Thread.sleep(5000);

		String id = driver.findElement(By.xpath("//a[@title='File View']")).getTagName();
		// System.out.println(id);

		String text = "a";

		if (id.equals(text)) {

			test = extent.createTest("MytwentythreeTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		} else {

			test = extent.createTest("MytwentythreeTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}

	@Test(priority = 23)
	public void side_navbar_bottom() throws InterruptedException {

		Thread.sleep(7000);

		driver.findElement(By.xpath("//a[@title='myclientshare.com']")).click();
		Thread.sleep(8000);
		String bt = driver.getTitle();
		// System.out.println(bt);

		String vt = "Client Share";
		if (bt.equals(vt)) {

			test = extent.createTest("MytwentyfourTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		} else {

			test = extent.createTest("MytwentyfourTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}

	@Test(priority = 24)
	public void category_tile() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]")).click();
		Thread.sleep(7000);

		/*
		 * driver.findElement(By.xpath("//*[@tabindex= '4402']")).click();
		 * Thread.sleep(7000);
		 * 
		 * driver.findElement(By.xpath("//*[@tabindex= '4403']")).click();
		 * Thread.sleep(7000);
		 */
		test = extent.createTest("MytwentyfiveTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

	}

	@Test(priority = 25)
	public void community_tile() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='container-bg container-bg-white']")).click();
		Thread.sleep(5000);

		String many = driver.findElement(By.xpath("//h4[contains(text(),'Add a new member')]")).getText();
		// System.out.println(many);

		String way = "Add a new member";

		if (many.equals(way)) {

			test = extent.createTest("MytwentysixTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

		} else {

			test = extent.createTest("MytwentysixTest", "Sample description");
			test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

		}

	}
	
	@Test(priority= 26)
	public void community_invite() throws InterruptedException {
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Invite')]")).click();
	                                                                                      
		    Thread.sleep(5000);                                                                                          // Invite functionailty is pending...
		 
		
		test = extent.createTest("MytwentysevenTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));
		
		
	}
	
	@Test(priority=27)
	public void community_page() throws InterruptedException {
		

		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(text(),'Invite')]")).click();
	                                                                                      
		    Thread.sleep(8000);    
		    
		    driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]")).click();
		   Thread.sleep(6000);
		   
		  String head =  driver.findElement(By.xpath(" //div[@class='modal-title h4']")).getText();
		  System.out.println(head);
		 
		  String v1 = "Business Card";
		  if (head.equals(v1)) {

				test = extent.createTest("MytwentyeightTest", "Sample description");
				test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));

			} else {

				test = extent.createTest("MytwentyeightTest", "Sample description");
				test.log(Status.FAIL, MarkupHelper.createLabel("this test case is FAIL", colors.LIME));

			}
		  
		
	}
	
	@Test(priority=28)
	public void community_page_2() throws InterruptedException {
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(text(),'Invite')]")).click();
	                                                                                      
		    Thread.sleep(8000);    
		    
		    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]")).click();
		   Thread.sleep(6000);
		   
		   driver.findElement(By.xpath("//div[@class='modal-dialog community-member-popup modal-dialog-centered']//button[@type='button']")).click();
		   Thread.sleep(5000);
		
		   test = extent.createTest("MytwentynineTest", "Sample description");
			test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));
		   
		
	}
	
	
	@Test(priority= 29)
	public void community_buyer_seller() throws InterruptedException {
   
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(text(),'Invite')]")).click();
        
	    Thread.sleep(8000);    
	    
	    driver.findElement(By.xpath("//button[contains(text(),'Airtel India')]")).click();
	    Thread.sleep(6000);
	    
	    
	    driver.findElement(By.xpath("//button[contains(text(),'Vodafone Egypt')]")).click();
	    Thread.sleep(6000);
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.go(-1)");
		Thread.sleep(6000);
		
		test = extent.createTest("MythirtyTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));
	 
		
	}
	
	@Test(priority=30)
	public void communitypage_scroll() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(text(),'Invite')]")).click();
		Thread.sleep(7000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,1500)");
		
		Thread.sleep(7000);
		
		test = extent.createTest("MythirtyoneTest", "Sample description");
		test.log(Status.PASS, MarkupHelper.createLabel("this test case is pass", colors.BLACK));
		
	}
	

	@AfterMethod
	
	

	public void Getresult(ITestResult testresult) {

		driver.close();
		
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
