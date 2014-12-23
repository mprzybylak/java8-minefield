package pl.mprzybylak.minefields.java8.lambdas;

public class LambdaExample {

	private int internal = 0;
	
	void foo() {
		
		Runnable r1 = new Runnable() {
			
			// runnable can shadow fields from enclosing class
			private int internal = 1;
			
			@Override
			public void run() {
				
				// this referes to runnable
				this.internal = 2;
			}
		};
		
		// this referes to enclosing class - lambda cannot shadows fields from enclosing class
		Runnable r2 = () -> this.internal = 2;
		
		
	}
	
}
