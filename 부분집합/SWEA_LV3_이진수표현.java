package 부분집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV3_이진수표현 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();

        for(int tc=1 ; tc<=T ; tc++) {
            sb.append("#").append(tc);

            token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());

            String result = "ON";
            int mask = (1<<N)-1;

            if((M & mask) != mask) {
                result = "OFF";
            }
            sb.append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}

// M의 이진수 표현의 마지막 N비트가 모두 1로 켜져 있는지 확인