package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketNavigation {


	static WebDriver driver = null;
	static ElementUtil eutil = null;
	static Actions act=null;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		
		// shop by category -> beverages -> tea -> green tea -> tata tea  
		// shop by category -> friuts and veg -> -> print all elements from sub categories
		By shopByCategory=By.cssSelector("a.meganav-shop");
		act = new Actions(driver);
		moveToElement(act, shopByCategory);
		// act.moveToElement(driver.findElement(By.cssSelector("a.meganav-shop"))).perform();
		
		//ul.bdr-viewall>li.ng-scope>a.ng-binding
		//ul.bdr-viewall>li[ng-mouseenter]>a.ng-binding
		
		By category=By.cssSelector("ul.bdr-viewall>li");
		// ul.nav-stacked>li.ng-scope>a[ng-bind='l2.name']
		By subCategory=By.cssSelector("ul.nav-stacked>li.ng-scope>a[qa='catL2']");
		By subCategoryColumn1=By.cssSelector("ul.list-unstyled>li.ng-scope>a[ng-bind='l3.name']");
		By subCategoryCol1=By.cssSelector("div.ng-scope div.box a[qa='catL3']");
		By popularSearch=By.cssSelector("div.ng-scope div.box li[ng-repeat^='searchTerm']");
		
		int subcategoryColumnsToScan=2;
		readCategoryAndSuncategoryMenu(category, subCategory, subCategoryCol1, popularSearch, subcategoryColumnsToScan);
		driver.quit();
	}
	
	private static void readCategoryAndSuncategoryMenu(By catgoryMenuLocator, By subCategoryLocator, By subCategoryCol1Locator, By popularSearchLocator,
			int subcategoryColumnsToScan) throws InterruptedException {
		List<WebElement> category = driver.findElements(catgoryMenuLocator);
		List<WebElement> categoryNonNull = new ArrayList<>();
		System.out.println("List size is: " + category.size());
		removeBlankElements(category, categoryNonNull);
		System.out.println("categoryNonNull List size is: " + categoryNonNull.size());
		System.out.println("********************");
		// getVisibleText(categoryNonNull);
		// Thread.sleep(2000);
		// Outer loop for sub category
		for (int i = 0; i < categoryNonNull.size(); i++) {
			moveToElement(act, categoryNonNull.get(i));
			act.moveToElement(categoryNonNull.get(i)).perform();
			// Thread.sleep(1000);
			String categoryTxt=categoryNonNull.get(i).getText();
			List<WebElement> subCategoryList = driver.findElements(subCategoryLocator);
			//System.out.println("Subcategory size is " + subCategoryList.size());
			List<WebElement> subCategoryListClean = new ArrayList<>();
			removeBlankElements(subCategoryList, subCategoryListClean);
			//System.out.println("new clean subCategoryList is: "+subCategoryListClean.size());
			System.out.println("for category "+categoryTxt+", Subcategory are: ------------");
			for (int j = 0; j < subCategoryListClean.size(); j++) {
				WebElement ele = subCategoryListClean.get(j);
				act.moveToElement(ele).perform();
				// Thread.sleep(1000);
				System.out.println(ele.getText());
				List<WebElement> subCategoryCol1List = driver.findElements(subCategoryCol1Locator);
				List<WebElement> subCategoryCol1ListNonNull = new ArrayList<>();
				removeBlankElements(subCategoryCol1List, subCategoryCol1ListNonNull);
				List<WebElement> popularSearchList = driver.findElements(popularSearchLocator);
				List<WebElement> popularSearchListNonNull = new ArrayList<>();
				removeBlankElements(popularSearchList, popularSearchListNonNull);
				System.out.println("$$$$$$$$$$$$$$$$$");
				// getVisibleText(subCategoryCol1List);
				System.out.println("sub category col 1");
				for (int k = 0; k < subCategoryCol1ListNonNull.size(); k++) {
					WebElement ele1=subCategoryCol1ListNonNull.get(k);
					act.moveToElement(ele1).perform();
					System.out.println(ele1.getText());
				}
				
				System.out.println("popular Search List text");
				for (int l = 0; l < popularSearchListNonNull.size(); l++) {
					WebElement ele2=popularSearchListNonNull.get(l);
					act.moveToElement(ele2).perform();
					System.out.println(ele2.getText());
				}
			}
			// getVisibleText(subCategoryListClean);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
		}
	}
	
	private static void getVisibleText(List<WebElement> elementList) {
		elementList.stream()
			.map(WebElement::getText)
			.filter(s -> !s.isBlank())
			.forEach(System.out::println);
	}
	
	private static List<WebElement> removeBlankElements(List<WebElement> listWIthBlank,List<WebElement> listWithoutBlank) {
		listWIthBlank.stream()
			.filter(s -> !s.getText().isBlank())
			.forEach(listWithoutBlank::add);
		return listWithoutBlank;
	}
	
	private static void moveToElement(Actions act, By locator) {
		act.moveToElement(driver.findElement(locator)).perform();
	}
	
	private static void moveToElement(Actions act, WebElement ele) {
		act.moveToElement(ele).perform();
	}
}
