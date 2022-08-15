package java8TMB;

import java.util.function.Consumer;

public class TestRunner4 {

	static void perform(Animal animal) {
		animal.run();
	}

	public static void main(String[] args) {

		perform(new Dog());
		
		perform(() -> {System.out.println("Running at 100 kmph");});
		toUpper("Utkal");
		toLower("nreel");
		stringOperation((s)->System.out.println(s.toLowerCase()), "UtkaL");
		stringOperation((s)->System.out.println(s.toUpperCase()), "Utkal");
		stringOperation((s)->System.out.println(s.length()), "Utkal");
	}
	
	private static void stringOperation(Consumer<String> consumer, String temp) {
		consumer.accept(temp);
	}
	
	private static void toUpper(String string) {
		System.out.println(string.toUpperCase());
	}

	private static void toLower(String string) {
		System.out.println(string.toLowerCase());
	}
}
