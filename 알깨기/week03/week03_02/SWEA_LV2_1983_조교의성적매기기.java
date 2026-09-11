package week03_02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class SWEA_LV2_1983_조교의성적매기기 {

	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		String[] arr = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int student = sc.nextInt();
			int findStudent = sc.nextInt();
			
			// 학생들의 점수를 담을 배열
			double[] scores = new double[student+1];
			
			// 정렬을 위한 리스트
			List<Double> scoreList = new ArrayList<>();
			
			// 총점 계산
			for(int i=1 ; i<=student ; i++) {
				
				int midScore = sc.nextInt();
				int finalScore = sc.nextInt();
				int taskScore = sc.nextInt();
				
				double score = (midScore * 0.35) + (finalScore * 0.45) + (taskScore * 0.2);
				// 배열에 점수 저장
				scores[i] = score;
				
				// 리스트에 저장
				scoreList.add(score);
				
			}
			
			// 찾고자하는 학생 점수
			double target = scores[findStudent];
			
			
			// 정렬 규칙 정의 
			//Interface Comparator -> 익명 객체 생성 -> 메서드 오버라이딩
			scoreList.sort(new Comparator<Double>() {
				@Override
				public int compare(Double o1, Double o2) {
					// o2 점수와 o1 점수를 비교 -> 더 큰 쪽을 앞으로 보냄 -> 내림차순
					return o2.compareTo(o1);
				}
			});
			
			// 람다식 표현
//			scoreList.sort((o1,o2) -> Double.compare(o2, o1));
			
			// 찾고자하는 학생의 등수 찾기
			int find = scoreList.indexOf(target);
					
			String result = arr[find / (student / 10)];
			
			System.out.println("#" + test_case + " " + result);
			
		}
		
		
	}
}