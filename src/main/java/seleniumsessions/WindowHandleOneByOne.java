package seleniumsessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleOneByOne {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		String parentWindow=driver.getWindowHandle();
		System.out.println("parent handle is "+parentWindow);
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.cssSelector("img[alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on youtube']")).click();

		Set<String> handles=driver.getWindowHandles();
		List<String> handlesList=new ArrayList<>(handles);
		Iterator<String> itr=handlesList.iterator();
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		
		driver.quit();
	}

}
