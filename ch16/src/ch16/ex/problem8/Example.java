package ch16.ex.problem8;

public class Example {
	private static Student[] students = {
			new Student("홍길동", 90, 96),
			new Student("신용권", 95, 93)
	};
	
	private static double avg(Function<Student> function) {
		double sum = 0;
		for (Student student : students) {
			sum += function.apply(student);
		}
		return sum / students.length;
	}
	public static void main(String[] args) {
//		double englishAvg = avg(s -> s.getEnglishScore());
		//이게 원래 안돼야 되는데 왜 되지? 여기가 정적 메소드에서 불러서 되는건가?
		double englishAvg = avg(Student :: getEnglishScore);
		System.out.println("영어 평균 점수: " + englishAvg);
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균 점수: " + mathAvg);
	}
}
