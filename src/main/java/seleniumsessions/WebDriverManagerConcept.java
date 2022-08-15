package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver dr= new EdgeDriver();
		dr.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		System.out.println(dr.getTitle());
		dr.quit();
		
		// login page of open cart and verify url contains account login
	}

}
