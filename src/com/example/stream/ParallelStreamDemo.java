package com.example.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		// Create a List of numbers from 1 to 100000000
		List<Integer> numbers = IntStream
				.rangeClosed(1, 1000000).boxed()
				.collect(Collectors.toList());
		
		// Call reduce on single thread stream
		long startTime = System.nanoTime();
		// The 0 here is initial value 0 + 1 + 2
		long sumSequential = numbers.stream().reduce(0, Integer::sum);
		System.out.println("Result is "+sumSequential);
		long endTime = System.nanoTime();
		System.out.println("operation sum on single thread stream takes "+ (endTime-startTime) +"ns");
		
		
		
		// Call reduce on parallel stream (multi thread operation)
		
		startTime =  System.nanoTime();
		long sumParallel = numbers.parallelStream().reduce(0, Integer::sum);
		System.out.println("Result is "+sumParallel);
		endTime = System.nanoTime();
		System.out.println("Operation sum on parallel stream takes "+ (endTime - startTime) +" ns");
		
				
				

	}

}
