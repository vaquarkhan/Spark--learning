package com.packt.sfjd.ch2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordCountInJava {
	public static final String REGEX = "\\s+";
	public static final String imagineLyrics="Imagine there's no heaven \n"
											+ "It's easy if you try \n"
											+ "No hell below us \n"
											+ "Above us only sky \n"
											+ "Imagine all the people living for today";

	public static void main(String[] args) {

		try {
		//TreeMap<String, Long> count = Files.lines(Paths.get(args[0]))
			TreeMap<String, Long> count = Stream.of( imagineLyrics.split("\n"))
					.map(line -> line.split(REGEX)).flatMap(Arrays::stream)
					.collect(groupingBy(identity(), TreeMap::new, counting()));
			
			// Using Lambda Expression
			Stream.of(count).forEach(x -> System.out.println(x));
			//Using Method Reference
			Stream.of(count).forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}