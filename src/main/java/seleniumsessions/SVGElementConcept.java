package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		//svg - css doesn't support
		//*[local-name()='svg']/*[name()='g'] (https://www.flipkart.com/)
		//*[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']
		
		
		
		// (//*[local-name()='svg'])[5] (https://petdiseasealerts.org/forecast-map/#/)
		
		// capture all the states
		List<WebElement> statess = driver.findElements(By.xpath("//*[local-name()='svg' and@id='map-svg']//*[name()='path']"));
		System.out.println(statess.size());
		statess.forEach(WebElement::getText);
		Thread.sleep(2000);
		driver.quit();
	}

}
