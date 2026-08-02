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
			
			// 학생들 평점을 담을 맵 (학생 번호, 점수)
			Map<Integer, Double> scores = new HashMap<>(); 
			
			// 총점 계산
			for(int i=1 ; i<=student ; i++) {
				
				int midScore = sc.nextInt();
				int finalScore = sc.nextInt();
				int taskScore = sc.nextInt();
				
				double score = (midScore * 0.35) + (finalScore * 0.45) + (taskScore * 0.2);
				
				scores.put(i, score);
			}
			
			// value 값으로 내림차순 정렬
			List<Integer> keySet = new ArrayList<>(scores.keySet());
			
			keySet.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return scores.get(o2).compareTo(scores.get(o1));
				}
			});
			
			// 찾고자하는 학생의 등수
			int find = keySet.indexOf(findStudent);
			
			// 평점 부여
			String result = arr[find / (student/10)];
			
			System.out.println("#" + test_case + " " + result);
			
		}
		
		
	}
}