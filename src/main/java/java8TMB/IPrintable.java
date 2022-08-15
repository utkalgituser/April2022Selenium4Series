package java8TMB;

// Functional interface as it has only abstract method.
// Use annotation so that it will show error if someone tries to add another abstract method
@FunctionalInterface
public interface IPrintable {
	
	// Abstract method
	public abstract void print();

	default void scan() {
		System.out.println("scanning");
	}

	static void printConsole() {
		System.out.println("printing to console");
	}

	default void scanAsPDF() {
		System.out.println("scanning as PDF");
	}
}
