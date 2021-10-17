package WebsiteTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyCommunitySite {

	@SuppressWarnings("deprecation")
	@Test(dataProvider="data-provider")
	public void verifysite(String url,String expectedLang){
		System.setProperty("webdriver.chrome.driver", "../community-website/src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String email = "xyz@qa.com";
		String pass = "Test";
		String lang;
		
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@data-testid='lets_begin']")).click();
		driver.findElement(By.xpath("//input[@data-testid='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@data-testid='signup_password']")).sendKeys(pass);
		driver.findElement(By.xpath("//div/div[@class='Dropdown-root false']")).click();
		driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='Son']")).click();
		
		driver.findElement(By.xpath("//button[@data-testid='next_button']")).click();
		lang = driver.findElement(By.xpath("//div[@class='Dropdown-control mother_tongue_selector Dropdown-disabled']")).getText();
		
		Assert.assertEquals(lang, expectedLang, "incorrect Default languagae");
		
		
		driver.quit();
	}
	
	
	@DataProvider( name = "data-provider")
	public String[][] pageList(){
			
		return CsvUtility.getCsvFileList();
		
	}
}
