package pl.mprzybylak.minefields.java8.stream.parallel;

import java.util.concurrent.RecursiveTask;

public class RecursiveSum extends RecursiveTask<Long> {

	private static final long serialVersionUID = -8825078617287945776L;

	private final long[] numbers;
	private final int start;
	private final int end;
	
	private static final long TRESHOLD = 10_000;
	
	public RecursiveSum(long[] numbers) {
		this.numbers = numbers;
		start = 0;
		end = numbers.length;
	}
	
	private RecursiveSum(long[] numebrs, int start, int end) {
		this.numbers = numebrs;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		int len = end - start;
		if(len <= TRESHOLD) {
			return computeSequentialy();
		}

		RecursiveSum left = new RecursiveSum(numbers, start, start + len/2);
		RecursiveSum right = new RecursiveSum(numbers, start + len /2, end);
		
		left.fork();
		Long rightResult = right.compute();
		Long leftResult = left.join();
		
		return leftResult + rightResult;
	}
	
	private long computeSequentialy() {
		long sum = 0;
		for(int i = start; i < end; ++i) {
			sum += numbers[i];
		}
		return sum;
	}
	

}
