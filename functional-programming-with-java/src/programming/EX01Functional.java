package programming;

import java.util.Comparator;
import java.util.List;

public class EX01Functional {

	public static void main(String[] args) {
		/*
		 * Sum of Squares
		 */
		int sum = sumOfSqurae(List.of(2, 5));
		System.out.println("Square Sum of Numbers:" + sum);

		/*
		 * Disply all distinct Numbers
		 */
		displayDistinctNumbers(List.of(5, 3, 7, 2, 5, 4, 8));

		/*
		 * Sort all numbers
		 */
		System.out.println("Sort Numbers");
		sortNumbers(List.of(5, 3, 7, 2, 5, 4, 8));
		/*
		 * sort distinct numbers
		 */
		System.out.println("Sort Distinct Numbers");
		sortDistinctNumbers(List.of(5, 3, 7, 2, 5, 4, 8));

		/*
		 * Comapator natural sorting
		 */
		System.out.println("Comparator- Natural Sort");
		comparatorNaturalSort(List.of(4, 2, 9, 5, 3, 5));

		/*
		 * Comparator- resver sort
		 */
		System.out.println("Comparator- Reverse Sort");
		comparatorReverseSort(List.of(4, 2, 9, 5, 3, 5));

		/*
		 * Sort based on length of String
		 */
		System.out.println("Sort based on length of String");
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");
		stringLengthSort(courses);
	}

	private static void stringLengthSort(List<String> courses) {
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}

	private static void comparatorReverseSort(List<Integer> numbers) {
		numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	private static void comparatorNaturalSort(List<Integer> numbers) {
		numbers.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
	}

	private static void sortDistinctNumbers(List<Integer> numbers) {
		numbers.stream().distinct()// Strem<T> Intermediate Operation
				.sorted().forEach(System.out::println);
	}

	private static void sortNumbers(List<Integer> numbers) {
		numbers.stream().sorted()// Strem<T> Intermediate Operation
				.forEach(System.out::println);
	}

	private static void displayDistinctNumbers(List<Integer> numbers) {
		numbers.stream().distinct().forEach(System.out::println);
	}

	private static int sumOfSqurae(List<Integer> numbers) {
		return numbers.stream().map(x -> x * x).reduce(0, Integer::sum);
	}

}
