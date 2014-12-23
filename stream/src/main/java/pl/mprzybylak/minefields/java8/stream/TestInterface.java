package pl.mprzybylak.minefields.java8.stream;

public interface TestInterface {

	void foo();
	
	default void bar() {
		System.out.println("default immplementation of method");
	}
	
	static void baz() {
		System.out.println("static method in interface");
		
		
		
	}
	
}
