package java8TMB;

public class TestRunner1 {

	public static void main(String[] args) {

		// Functional programming
		
		// 1. parameter to the abstract method and your lambda expression should match
		// 2.  return type of the abstract and lambda expression must match
		// 3. only one abstract or, unimplemented method
		
		IPrintable1 obj = (a, b) -> {return  b.toString();};
		System.out.println(obj.print(6, "Utkal"));
		
		ScannerInterface scn=() -> 0;
	}

}
