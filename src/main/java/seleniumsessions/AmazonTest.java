package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {

		BrowserUtil butil=new BrowserUtil();
		butil.initDriver("edge");
		butil.launchUrl("https://www.amazon.com");
		System.out.println(butil.getPageTitle());
		System.out.println(butil.getPageUrl());
		if(butil.isUrlFractionExists("Amazon")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		butil.quitBrowser();
	}

}
