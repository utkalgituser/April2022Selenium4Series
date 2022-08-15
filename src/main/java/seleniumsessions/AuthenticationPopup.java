package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopup {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {
		String id = "admin";
		String pwd = "admin";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("https://"+id+":"+pwd+"@the-internet.herokuapp.com/basic_auth");
		// This hack will not work if password contains "@" as character
		driver.get("https://"+id+":"+pwd+"@the-internet.herokuapp.com/basic_auth");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
		driver.quit();
	}

}
