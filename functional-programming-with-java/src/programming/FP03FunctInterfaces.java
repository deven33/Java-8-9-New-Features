package programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctInterfaces {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(2, 5, 6, 1, 3);

		filterAndPrint(numbers, x -> x % 2 == 0);
		filterAndPrint(numbers, x -> x % 2 != 0);

		// Supplier
		Supplier<Integer> supplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		System.out.println(supplier.get());

		// Unary
		UnaryOperator<Integer> unary = (x) -> 2 * x;
		System.out.println(unary.apply(4));

		// Bipredicate
		BiPredicate<Integer, String> bipredicate = (num, str) -> {
			return num > 10 && str.length() > 10;
		};
		System.out.println(bipredicate.test(12, "deven"));

		// BiFunction
		BiFunction<Integer, String, String> biFun = (num, str) -> {
			return "dev" + " " + str;
		};
		System.out.println(biFun.apply(12, "ameta"));

		// Biconsumer
		BiConsumer<String, String> biCon = (s1, s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		};
		biCon.accept("dev", "amet");
	}

	protected static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream().filter(predicate).forEach(System.out::println);
	}

}
