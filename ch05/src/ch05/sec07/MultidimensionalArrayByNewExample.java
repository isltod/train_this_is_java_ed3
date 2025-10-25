package ch05.sec07;

public class MultidimensionalArrayByNewExample {
	public static void main(String[] args) {
		int[][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		
		for (int i = 0; i < englishScores.length; i++) {
			for (int j = 0; j < englishScores[i].length; j++) {
				System.out.println("englishScores[" + i + "][" + j + "]: " + englishScores[i][j]);
				englishScores[i][j] =(int)(Math.random() * 100 + 1);
			}
		}
		System.out.println();
		
		int totalStudent = 0;
		int totalEnglishSum = 0;
		for (int i = 0; i < englishScores.length; i++) {
			totalStudent += englishScores[i].length;
			for (int j = 0; j < englishScores[i].length; j++) {
				System.out.println("englishScores[" + i + "][" + j + "]: " + englishScores[i][j]);
				totalEnglishSum += englishScores[i][j];
			}
		}
		double totalEnglishAvg = (double) totalEnglishSum / totalStudent;
		System.out.println("전체 학생의 영어 평균 점수: " + totalEnglishAvg);
	}
}
