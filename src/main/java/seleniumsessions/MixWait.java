package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MixWait {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		// never mix implicitly wait and explicitly wait
		// badly impact the performance of the script coz of cumulative wait will be applied
		
		//ele -- imp wait      exp wait    total time
		//e1  -- 0               2            2
		//e1 --  5			     0            5
		//e1 --- 0 				15			  15
		//e1 --  10 			15 			  25
		//e1 -   8 				12			  20	
		driver.quit();

	}

}
