package seleniumsessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {


	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on twitter']")).click();
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		Iterator<String> itr=handles.iterator();
		String parentWindowId = itr.next();
		System.out.println("This is parent window id"+parentWindowId);
		String childWindowId = itr.next();
		System.out.println("This is Child window id"+parentWindowId);
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.quit();
		
		// converts to ordered list
		List<String> handlesList=new ArrayList<>(handles);
		System.out.println(handlesList.get(0));
		System.out.println(handlesList.get(1));
	}

}
