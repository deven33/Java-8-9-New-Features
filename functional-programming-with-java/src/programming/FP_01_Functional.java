package programming;

import java.util.Arrays;
import java.util.List;

public class FP_01_Functional {

	public static void main(String[] args) {
		System.out.println("Print Stream");
		printAllNumberListInFunctional(List.of(12, 5, 34, 7, 21, 5, 12));
		System.out.println();

		System.out.println("Print Even Number");
		printAllEvenNumberInListFunctional(List.of(12, 5, 34, 7, 21, 5, 12));
		System.out.println();

		System.out.println("Print Odd Number");
		printAllOddNumberInListFunctional(Arrays.asList(12, 5, 34, 7, 21, 5, 12));
		System.out.println();

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");
		printAllCoursesWithmatchInList(courses);
		System.out.println();

		System.out.println("Print Courses with atleast 4 letters");
		printAllCoursesWith4LettersInList(courses);
		System.out.println();

		System.out.println("Square of Numbers");
		printAllNumberSquareInListFunctional(List.of(12, 5, 34, 7, 21, 5, 12));

	}

	private static void printAllNumberSquareInListFunctional(List<Integer> numbers) {
		numbers.stream().map(num -> num * num) // mapping x -> x*x
				.forEach(System.out::println);

	}

	private static void printAllCoursesWith4LettersInList(List<String> courses) {
		courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);
	}

	private static void printAllCoursesWithmatchInList(List<String> courses) {
		courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
	}

	private static void printAllOddNumberInListFunctional(List<Integer> asList) {
		asList.stream().filter(num -> num % 2 != 0).forEach(System.out::print);
	}

	private static void printAllEvenNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(num -> num % 2 == 0)// Lambda expression
				.forEach(System.out::print);
	}

	private static void printAllNumberListInFunctional(List<Integer> numbers) {
		// Convert List-> streams [12, 5, 34, 7, 21, 5, 12]--> 12 5 34 7 21 5 12
		numbers.stream().forEach(System.out::print);
	}

}
