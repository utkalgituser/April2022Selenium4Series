package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConceptTest {

	String name;

	@Test(expectedExceptions = { ArithmeticException.class, NullPointerException.class })
	public void searchTest() {
		System.out.println("macbook");
		int i = 9 / 0;
		ExpectedExceptionConceptTest obj = new ExpectedExceptionConceptTest();
		obj = null;
		obj.name = "utkal"; // NPE
		System.out.println("bye");
	}
}
