package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	static WebDriver driver = null;
	static ElementUtil eUtil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		eUtil = new ElementUtil(driver);
		waitForPageLoad(10);
		By amazonDevices = By.linkText("Amazon Devices11");
		retryElement(amazonDevices, 10).click();

		driver.quit();

	}
	//  Write a utility to return the state of the page 
	
	public static void waitForPageLoad(int timeout) {
		long endTime = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < endTime) {
			String pageState=((JavascriptExecutor) driver).executeScript("return document.readyState;").toString();
			System.out.println("page loading state is "+pageState);
			if(pageState.equals("Complete")) {
				System.out.println("Page is fully loaded with scripts");
				break;
			}
		}
	}
	
	public static void shortWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
	public static void mediunsWait() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
	public static void longWait() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
	public static void waitFor(int milliSecs) {
		try {
			Thread.sleep(1000*milliSecs);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static WebElement retryElement(By locator, int maxAttempt) {
		WebElement ele = null;
		int attempts = 1;
		while (attempts <= maxAttempt) {
			System.out.println("attempt number is " + attempts + " ,max attaempts is " + maxAttempt);
			try {
				ele = getElement(locator);
				System.out.println("Element found... in attemps " + attempts);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element not found in attemsps: " + attempts + "for locator " + locator);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
			attempts++;
		}
		if (ele == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println(
						"Element is not found exception... tried for: " + maxAttempt + " secs, with interval of 1 sec");
			}

		}
		return ele;
	}
}
