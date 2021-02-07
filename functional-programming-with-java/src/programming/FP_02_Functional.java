package programming;

import java.util.List;

public class FP_02_Functional {

	public static void main(String[] args) {
		System.out.println("Print Stream");
		int sum = sumAllNumberListInFunctional(List.of(12, 5, 34, 7, 21, 5, 12));
		System.out.println(sum);

	}

	private static int sumAllNumberListInFunctional(List<Integer> numbers) {
		/*
		 * stream of numbers-> one result value combine them into one result -> One
		 * value 0 -> initial sum value a=0
		 */
		// return numbers.stream().reduce(0, FP_02_Functional::sum);
		// 2 nd with lambda
		return numbers.stream().reduce(0, (x, y) -> x + y);
	}

	private static int sum(int a, int b) {
		System.out.println(a + " " + b);
		return a + b;
	}
}
