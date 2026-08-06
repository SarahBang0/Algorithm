package week03_02;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1946_간단한압축풀기2 {
	 
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
     
        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.println("#" + test_case);
             
            int N = sc.nextInt(); // 알파벳 개수
             
            StringBuilder sb = new StringBuilder();
             
             // 주어진 숫자만큼 반복
            for(int i=0 ; i<N ; i++) {
                 
                String alpabet = sc.next(); // 알파벳 문자
                int num = sc.nextInt(); 
                 
                // 알파벳 숫자만큼 반복
                for(int j=0 ; j<num ; j++) {
                    sb.append(alpabet);
                     
                    if(sb.length() == 10) { // sb에 10개 문자 들어갔다면 출력하고 초기화
                        System.out.println(sb.toString());
                        sb.delete(0, sb.length());
                    } 
                     
                }
                 
                if(i==N-1) {
                    System.out.println(sb.toString());
                }
 
            }
	    }
	}
	 
	}