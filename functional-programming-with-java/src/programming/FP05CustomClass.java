package programming;

import java.util.List;
import java.util.function.Predicate;

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
		List<Course> course = List.of(new Course("Java", 100, 34, "Basic"), new Course("Python", 101, 54, "Basic"),
				new Course("React", 101, 314, "Basic"), new Course("Spring", 109, 94, "Basic"),
				new Course("Hibernate", 144, 14, "Basic"));

		// All match, none match, any match

		// All match with reviews > 90
		Predicate<Course> matchRulegreaterthan95 = courses -> courses.getReviewScore() > 95;
		Predicate<Course> matchRulegreaterthan10 = courses -> courses.getReviewScore() > 10;
		
		System.out.println(course.stream().allMatch(matchRulegreaterthan95));
		System.out.println(course.stream().noneMatch(matchRulegreaterthan10));
		System.out.println(course.stream().anyMatch(matchRulegreaterthan95));

	}

}
