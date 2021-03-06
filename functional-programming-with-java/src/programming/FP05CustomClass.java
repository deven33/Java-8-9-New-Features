package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Course {
	private String name;
	private int noOfStudent;
	private int reviewScore;
	private String course;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfStudent() {
		return noOfStudent;
	}

	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Course(String name, int noOfStudent, int reviewScore, String course) {
		super();
		this.name = name;
		this.noOfStudent = noOfStudent;
		this.reviewScore = reviewScore;
		this.course = course;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", noOfStudent=" + noOfStudent + ", reviewScore=" + reviewScore + "]";
	}

}

public class FP05CustomClass {

	public static void main(String[] args) {
		List<Course> course = List.of(new Course("Java", 400, 34, "Basic"), new Course("Python", 400, 54, "Basic"),
				new Course("React", 101, 314, "Intermediate"), new Course("Spring", 109, 94, "Basic"),
				new Course("Hibernate", 144, 14, "Adv"));

		// All match, none match, any match

		// All match with reviews > 90
		Predicate<Course> matchRulegreaterthan95 = courses -> courses.getReviewScore() > 95;
		Predicate<Course> matchRulegreaterthan10 = courses -> courses.getReviewScore() > 10;

		System.out.println(course.stream().allMatch(matchRulegreaterthan95));
		System.out.println(course.stream().noneMatch(matchRulegreaterthan10));
		System.out.println(course.stream().anyMatch(matchRulegreaterthan95));
		// Sort based on student cnt
		Comparator<Course> comparingNoOfStudentInc = Comparator.comparing(Course::getNoOfStudent);
		// Reverse sort
		Comparator<Course> comparingNoOfStudentRev = Comparator.comparing(Course::getNoOfStudent).reversed();
		System.out.println(course.stream().sorted(comparingNoOfStudentInc).collect(Collectors.toList()));
		// [Course [name=React, noOfStudent=101, reviewScore=314], Course [name=Spring,
		// noOfStudent=109, reviewScore=94], Course [name=Hibernate, noOfStudent=144,
		// reviewScore=14], Course [name=Java, noOfStudent=400, reviewScore=34], Course
		// [name=Python, noOfStudent=400, reviewScore=54]]

		System.out.println(course.stream().sorted(comparingNoOfStudentRev).collect(Collectors.toList()));
		// [Course [name=Java, noOfStudent=400, reviewScore=34], Course [name=Python,
		// noOfStudent=400, reviewScore=54], Course [name=Hibernate, noOfStudent=144,
		// reviewScore=14], Course [name=Spring, noOfStudent=109, reviewScore=94],
		// Course [name=React, noOfStudent=101, reviewScore=314]]

		// If no of student same for more than one object then sort based on reviews
		Comparator<Course> comparingNoOfStudentIncReviews = Comparator.comparing(Course::getNoOfStudent)
				.thenComparing(Course::getReviewScore).reversed();

		System.out.println(course.stream().sorted(comparingNoOfStudentIncReviews).collect(Collectors.toList()));
		// [Course [name=Python, noOfStudent=400, reviewScore=54], Course [name=Java,
		// noOfStudent=400, reviewScore=34], Course [name=Hibernate, noOfStudent=144,
		// reviewScore=14], Course [name=Spring, noOfStudent=109, reviewScore=94],
		// Course [name=React, noOfStudent=101, reviewScore=314]]

		// Reviews in reverse order
		Comparator<Course> comparingNoOfStudentIncReviewsRev = Comparator.comparing(Course::getNoOfStudent)
				.thenComparing(Course::getReviewScore).reversed();
		System.out.println(course.stream().sorted(comparingNoOfStudentIncReviewsRev).collect(Collectors.toList()));
		// [Course [name=Python, noOfStudent=400, reviewScore=54], Course [name=Java,
		// noOfStudent=400, reviewScore=34], Course [name=Hibernate, noOfStudent=144,
		// reviewScore=14], Course [name=Spring, noOfStudent=109, reviewScore=94],
		// Course [name=React, noOfStudent=101, reviewScore=314]]

		// Pickup top 3 records- using limit
		System.out.println(course.stream().limit(3).collect(Collectors.toList()));
		// [Course [name=Java, noOfStudent=400, reviewScore=34], Course [name=Python,
		// noOfStudent=400, reviewScore=54], Course [name=React, noOfStudent=101,
		// reviewScore=314]]

		// Skip top 3 results
		System.out.println(course.stream().skip(3).collect(Collectors.toList()));
		// [Course [name=Spring, noOfStudent=109, reviewScore=94], Course
		// [name=Hibernate, noOfStudent=144, reviewScore=14]]

		// Skip-1 then Limit-2
		System.out.println(course.stream().skip(1).limit(2).collect(Collectors.toList()));
		// [Course [name=Python, noOfStudent=400, reviewScore=54], Course [name=React,
		// noOfStudent=101, reviewScore=314]]

		// Take while match doesnt found- take while review doent come < 100
		System.out.println(course);
		System.out.println(
				course.stream().takeWhile(courses -> courses.getReviewScore() < 100).collect(Collectors.toList()));
		// [Course [name=Java, noOfStudent=400, reviewScore=34], Course [name=Python,
		// noOfStudent=400, reviewScore=54], Course [name=React, noOfStudent=101,
		// reviewScore=314], Course [name=Spring, noOfStudent=109, reviewScore=94],
		// Course [name=Hibernate, noOfStudent=144, reviewScore=14]]
		// [Course [name=Java, noOfStudent=400, reviewScore=34], Course [name=Python,
		// noOfStudent=400, reviewScore=54]]

		// Skip element while match doesnt found- skip while review doent come > 30
		System.out.println(course);
		System.out.println(
				course.stream().dropWhile(courses -> courses.getReviewScore() > 30).collect(Collectors.toList()));
		// [Course [name=Java, noOfStudent=400, reviewScore=34], Course [name=Python,
		// noOfStudent=400, reviewScore=54], Course [name=React, noOfStudent=101,
		// reviewScore=314], Course [name=Spring, noOfStudent=109, reviewScore=94],
		// Course [name=Hibernate, noOfStudent=144, reviewScore=14]]
		// [Course [name=Hibernate, noOfStudent=144, reviewScore=14]]

		// Max - return last element of list
		System.out.println(course.stream().max(comparingNoOfStudentIncReviews));
		// Optional[Course [name=React, noOfStudent=101, reviewScore=314]] // Optional

		// Min - return first element of list
		System.out.println(course.stream().min(comparingNoOfStudentIncReviews));
		// Optional[Course [name=Python, noOfStudent=400, reviewScore=54]]

		// Optional Provides a way that we can see resultant value exists or not
		// if result not exist then we can provide default value using orElse
		System.out.println(
				course.stream().max(comparingNoOfStudentIncReviews).orElse(new Course("Docker", 244, 14, "Basic")));
		// Course [name=React, noOfStudent=101, reviewScore=314] // Option not there

		// Find First
		System.out.println(course.stream().sorted(comparingNoOfStudentIncReviews).findFirst()
				.orElse(new Course("Docker", 244, 14, "Basic")));

		System.out.println(course.stream().filter(matchRulegreaterthan10).map(courses -> courses.getNoOfStudent())
				.collect(Collectors.toList()));
		// [400, 400, 101, 109, 144]

		// Sum
		System.out.println(
				course.stream().filter(matchRulegreaterthan10).mapToInt(courses -> courses.getNoOfStudent()).sum());
		// 1154

		// Average
		System.out.println(
				course.stream().filter(matchRulegreaterthan10).mapToInt(courses -> courses.getNoOfStudent()).average());
		// OptionalDouble[230.8]

		// Count
		System.out.println(
				course.stream().filter(matchRulegreaterthan10).mapToInt(courses -> courses.getNoOfStudent()).count());
		// 5

		// MAx
		System.out.println(
				course.stream().filter(matchRulegreaterthan10).mapToInt(courses -> courses.getNoOfStudent()).max());
		// OptionalInt[400]

		// GroupBy
		System.out.println(course.stream().collect(Collectors.groupingBy(courses -> courses.getCourse())));
		// {Basic=[Course [name=Java, noOfStudent=400, reviewScore=34], Course
		// [name=Python, noOfStudent=400, reviewScore=54], Course [name=Spring,
		// noOfStudent=109, reviewScore=94]], Adv=[Course [name=Hibernate,
		// noOfStudent=144, reviewScore=14]], Intermediate=[Course [name=React,
		// noOfStudent=101, reviewScore=314]]}

		// Count By Group
		System.out.println(course.stream()
				.collect(Collectors.groupingBy(coursess -> coursess.getCourse(), Collectors.counting())));
		// {Basic=3, Adv=1, Intermediate=1}

		// array to Stream
		int arry[] = { 3, 6, 2, 9 };
		System.out.println(Arrays.stream(arry));

		System.out.println(Arrays.stream(arry).sum());

		// generate Numbers and perform operation
		System.out.println(IntStream.range(1, 10).sum());// 10 is exclusive
		System.out.println(IntStream.rangeClosed(1, 10));// 10 inclusive
		System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).sum());
		System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).peek(System.out::print).sum());

		// generate numbers and asve in List --box() is must
		System.out.println(IntStream.rangeClosed(3, 28).boxed().collect(Collectors.toList()));
		// [3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
		// 24, 25, 26, 27, 28]
	}

}
