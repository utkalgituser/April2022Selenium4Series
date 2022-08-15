package seleniumsessions;

import org.openqa.selenium.By;

public class CustomXpath {

	public static void main(String[] args) {
		
		// xpath is not an attribute 
		// its an address of the element non the DOM
		// relative xpath with the help of attributes, xpath function
		
		// htmltag[@attribute='value']
		//input[@id='input-email']
		
		//htmltag[@attribute='value' and @attribute='value']
		//input[@id='input-email' and @placeholder='E-Mail Address']
		
		//htmltag[@attribute='value' or @attribute='value']
		//input[@id='input-email' or @placeholder='E-Mail Address']
		
		//htmltag
		//input
		//a
		//input[@id] 
		//a[@href]
		
		//text function
		//htmltag[text()='value']
		//h2[text()='Returning Customer']
		
		// contains(): used for dynamic elements
		//htmltag[contains(@attr, 'value')]
		//input[contains(@id,'firstname')]
		
		// contains() text() and with attribute: 
		//htmltag[contains(@attr,'value') and cotains(@aattr,'value')]
		//a[contains(text(),' HR Management') and contains(@href,'freshworks')]
		//htmltag[contains(@attr,'value') and cotains(@aattr,'value') and @attr='value']
		
		//start-with()
		//htmltag[starts-with(@attr='value')]
		//input[starts-with(@id,'input')]
		//p[starts-with(text(),'If you already')]
		
		//ends-with() : deprecated in xpath3.0
		
		//index: positional 
		// (//input[@class='form-control'])[2] --> using captha group
		// (//input[@class='form-control'])[6]
		By.xpath("(//input[@class='form-control'])[6]");
		
		// (//input[@class='form-control'])[position()=6]
		// position starts from 1 not 0 in xpath function
		By.xpath("(//input[@class='form-control'])[position()=6]");
		
		// (//input[@class='form-control'])[last()]
		// it will go to last element
		By.xpath("(//input[@class='form-control'])[last()]");
		
		// (//input[@class='form-control'])[last()-1]
		By.xpath("(//input[@class='form-control'])[last()-1]");
		
		// Amazon home page help link
		By.xpath("((//div[@class='navFooterVerticalRow navAccessibility']/div)[last()]/ul/li)[last()]");
		
		// To get the first element of footer columns
		//div[@class='navFooterVerticalRow navAccessibility']/div/ul/li[1]
		

		
		
		
		
		
		
		
		
		
		
		
		
	}

}
