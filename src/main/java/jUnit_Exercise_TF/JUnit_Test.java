package jUnit_Exercise_TF;

import java.util.concurrent.TimeUnit;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JUnit_Test {

	WebDriver driver;

	@Before
	public void stratBrowser() {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://techfios.com/test/101/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void validUserCanBeWorkOnIt() throws InterruptedException {

		//Toggle Box Selected
	//	Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("allbox")));
		
		driver.findElement(By.name("allbox")).click();
		System.out.println("The Toggle All Box Checked");
		

	
		//Remove Toggle Box Selected
		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();
		boolean remove = driver.findElement(By.name("submit")).isSelected();
		
		
		
		if (remove == true) {
			System.out.println("The Toggle All Box is Selected");

		} else {
			System.out.println("The Toggle All Box Not Selected");
		}
		
		Thread.sleep(3000);
	//	driver.findElement(By.name("allbox")).click();
		
		driver.findElement(By.name("data")).sendKeys("xyz");
		driver.findElement(By.name("categorydata")).sendKeys("abc");
		
		WebElement catagory = driver.findElement(By.name("category"));
		Select sel = new Select(catagory);
		sel.selectByVisibleText("objectspy");
		
		WebElement colour = driver.findElement(By.name("colour"));
		Select sel1 = new Select(colour);
		sel1.selectByVisibleText("Blue");
		
		WebElement date = driver.findElement(By.name("due_day"));
		Select sel2 = new Select(date);
		sel2.selectByValue("5");
		
		WebElement month = driver.findElement(By.name("due_month"));
		Select sel3 = new Select(month);
		sel3.selectByVisibleText("Apr");
		
		WebElement year = driver.findElement(By.name("due_year"));
		Select sel4 = new Select(year);
		sel4.selectByVisibleText("2022");
		
		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();
		
		WebElement levelTime = driver.findElement(By.id("label-time"));
		
		System.out.println(levelTime.getText());
		
	
	}
	
	

//	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
