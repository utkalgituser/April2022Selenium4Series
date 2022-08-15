package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadConcepts {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		// type="file"
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\green\\OneDrive\\Desktop\\cdd008960e3a.jpg");
		Thread.sleep(5000);
		
		driver.quit();
	}

}
