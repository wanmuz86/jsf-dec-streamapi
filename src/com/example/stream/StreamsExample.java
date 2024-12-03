package com.example.stream;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsExample {

	public static void main(String[] args) {
		
		// Collection
		
		List<String> fruits = Arrays.asList("Apple",
				"Banana","Cherry","Date","Figs","ElderBerry");
		
		// Create the stream
		// fruits.stream() -> Transforming a list to a stream
		
		// Applying terminal operation on the stream
		// Each of the stream needs to finish by a terminal operation
		//Terminal Operations: 138 of the slide
		
		fruits.stream().forEach(System.out::println);;
		
		
		// filter operation
		// Stream -> operation -> terminal operation (transform in to a list)
		// filter part -> lamda operation -> for each fruit in the streams, 
		// i want only the one starts with A and B
		List<String> filteredFruits = 
				fruits.stream()
				.filter(fruit -> fruit.startsWith("A")|| fruit.startsWith("B"))
				.collect(Collectors.toList());
		
		//Verify the original list does not change after stream operation
		System.out.println("Original list "+fruits);
		System.out.println("Filtered fruits "+filteredFruits);
		
		
		// map and sorting
		// map transforming each of the stream to a particular format
		// The operation inside map is read as
		// For each of the fruits, I will uppercase it
		
		// terminal operation -> Show it in the log
		List<String> uppercasedFruits  = fruits.stream()
				.map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("Uppercased Fruits "+uppercasedFruits);
		
		
		// sorted operation -> Sort alphabetically
		
		List<String> sortedFruits = fruits.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted fruits "+sortedFruits);
		
		// Reduce operation
		List<Integer> scores = Arrays.asList(40,80,90,50,70,100,90);
		
		// Reduce for each item in the array perform the operation inside ()
		// 40 + 80 + 90 + 50 + ...
		// If you are running binary operation, then reduce will return optional value
		
		Optional<Integer> sum = scores.stream().reduce(Integer::sum);
		// Optional means it can be null or it can have a value
		// If it is not null, then print it
		sum.ifPresent(System.out::println);
		
	}

}
