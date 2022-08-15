package java8TMB;

public class TestRunner {

	public static void main(String[] args) {

		// Anonymous inner class
		IPrintable obj = new IPrintable() {

			@Override
			public void print() {
				System.out.println("From Anonymous inner class");
			}
		};

		// Anonymous inner class
		IPrintable obj1 = new IPrintable() {

			@Override
			public void print() {
				System.out.println("From Anonymous inner class from obj1");
			}
		};

		obj.print();
		obj1.print();
		
		// Anonymous inner class
		
		IPrintable obj2=() -> 
		{
				System.out.println("From anonymoous inner class obj2");
			// press Ctrl +1 to convert to lambda expression 
		};
		obj2.print();	
		
		// Functional programming
		
		// 1. parameter to the abstract method and your lambda expression should match
		// 2.  return type of the abstract and lambda expression must match
		// 3. only one abstract or, unimplemented method

		IPrintable obj3= () -> System.out.println("I am lambda expression");
		obj3.print();
	}	
}
