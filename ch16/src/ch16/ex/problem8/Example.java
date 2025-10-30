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
		double englishAvg = avg(s -> s.getEnglishScore());
		//이게 원래 안돼야 되는데 왜 되지? 여기가 정적 메소드에서 불러서 되는건가? 가 아니고..
		//여기 s 가 위 avg 메소드로 보내지면 function.apply(student)의 student 즉 매개변수로 되므로 클래스 :: 메소드
		//근데 그러면 위에거가 안되야 되는거 아냐? 매개변수가 되면 인스턴스 메소드 참조이자 매개변수 참조이니까 둘 다 되는건가?
//		double englishAvg = avg(Student :: getEnglishScore);
		System.out.println("영어 평균 점수: " + englishAvg);
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균 점수: " + mathAvg);
	}
}
