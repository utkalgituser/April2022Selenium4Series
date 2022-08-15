package java8TMB;

@FunctionalInterface
public interface MyInterface<T, U, R> {
	
	// Accepts 2 parameters and returns a string
	public abstract R someName(T t, U u);
	
	// java.util.Function
}
