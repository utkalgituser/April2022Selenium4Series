package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeHandle {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		driver.findElement(By.cssSelector("div#imageTemplateContainer")).click();
		Thread.sleep(4000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'frame-one')]")));
		driver.findElement(By.xpath("//div[@id='q3']/input[starts-with(@name,'RESULT_TextField')]")).sendKeys("123456");
		Thread.sleep(2000);
		driver.switchTo().defaultContent(); // come back to main page
		
		driver.quit();
		
		// classic CRMPRO add contacts is assignment
		
	}

}
