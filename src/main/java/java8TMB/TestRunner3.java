package java8TMB;

public class TestRunner3 {

	public static void main(String[] args) {

		IStringPrintable obj = (a) -> System.out.println(a);
		obj.print("UTKAL");
		
		IPrintable3<String> obj1=(a) -> System.out.println(a);
		obj.print("neel");
		IPrintable3<Integer> obj2=(a) -> System.out.println(a);
		obj2.print(89);
		
		MyInterface<String, String, String> obj3=(str1, str2) -> str1+str2 ;
		System.out.println(obj3.someName("neel ","smita "));
		
	}

}
