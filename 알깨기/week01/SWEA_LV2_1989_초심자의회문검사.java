package week01;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;


public class SWEA_LV2_1989_초심자의회문검사 {

	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String word = sc.next();
            
            char[] arr = word.toCharArray(); // String to char[]
            int answer = 1; 
            
            //System.out.println(Arrays.toString(arr));
            
            for(int i=0 ; i<arr.length/2 ; i++) { //배열의 중간 지점까지 순회
                if(arr[i]==arr[arr.length-1-i]) { //앞 인덱스와 뒤 인덱스 값 비교
                    continue;
                } else {
                    answer = 0;
                }
			}
		 System.out.println("#" + test_case + " " + answer);
	}
    }
	
}
