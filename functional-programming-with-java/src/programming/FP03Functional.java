package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP03Functional {

	public static void main(String[] args) {
		/*
		 * Create new List of Squaring elements of Current List
		 */
		List<Integer> numbers = List.of(3, 5, 6, 1, 4);
		System.out.println("List:" + numbers);
		List<Integer> doubleNumbers = doubleNumbersList(numbers);
		System.out.println(doubleNumbers);

		/*
		 * New List With even Numbers
		 */
		System.out.println("Even Number List");
		List<Integer> evenNumber = evenNumberList(numbers);
		System.out.println(evenNumber);

		/*
		 * New List with String Course length
		 */
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");
		System.out.println("Course Length List");
		List<Integer> courseLength = courseLengthList(courses);
		System.out.println(courseLength);
	}

	private static List<Integer> courseLengthList(List<String> courses) {
		return courses.stream().map(x -> x.length()).collect(Collectors.toList());
	}

	private static List<Integer> evenNumberList(List<Integer> numbers) {
		return numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
	}

	private static List<Integer> doubleNumbersList(List<Integer> numbers) {
		return numbers.stream().map(num -> num * num)// square the numbers
				.collect(Collectors.toList())// save that square element in list
		;
	}

}
