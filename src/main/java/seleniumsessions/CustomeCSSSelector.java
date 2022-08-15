package seleniumsessions;

import org.openqa.selenium.By;

public class CustomeCSSSelector {

	public static void main(String[] args) {

		// id --> #
		// class --> .class or tag name
		
		By.cssSelector("#input-email");
		// "input#input-email"
		// "input#input-email"
		// multiple attribute can be combined no and or key word
		// "input.form-control#input-email"
		
		// Below selector is invalid because we can't use multiple class names with
		// className locator, but we can use with xpath. This will give compound class name error/
		By.className("form-control private-form__control login-email"); 
		
		// input.form-control.private-form__control.login-email (hubspot)
		// select#Form_submitForm_Country
		
		// tag[attr='value']
		// input[name='email'] --> CSS
		// input[@name='email'] --> xpath
		
		// tag[attr='value'][attr='value']
		// input[name='email'][type='text']
		// input[name='email'][input-email]
		// input[name='email']#input-email
		// input[type='email'][id='username'] (hubspot)
		
		// tag[attr*='value'] -- contains
		// input[id*='email'] -- CSS
		// input[contains(@id,'email')] -- xpath
		
		// input[placeholder^='E-Mail'][id^='input'] -- starts with
		// input[placeholder^='E-Mail'][id*='input'] -- starts with and contains combined 
		// input[placeholder$='Address'] -- ends with
		// input[placeholder$='Address'][id*='email'][class^='form']
		
		// no support for text function in CSS 
		// parent to child
		// div#content input --> direct and indirect child tags -- 3
		// div#content > div --> only direct child elements -- 1
		
		// form#hs-login input#username 
		
		// backward traversing not allowed in CSS
		
		// for following siblings
		// https://naveenautomationlabs.com/opencart/index.php?route=account/login
		// div.form-group > label[for='input-email'] +input
		
		// combining multiple type of elements in to one CSS
		// img[title='naveenopencart'],input[name='search'],input[id='input-email'],button[type='button']
		
		// xpath vs CSS
		// 1. syntax: CSS is better than xpath 
		// 2. performance: both are good 
		// 3. backward: xpath
		// 4. siblings: xpath
		// 5. webtables: xpath
		// 6. comma: CSS
		// 7. text: xpath
		// 8. dynamic elements: both
		// 9. SVG elements: xpath
		// 10. shadow doms: CSS selector
		
		
	}

}
