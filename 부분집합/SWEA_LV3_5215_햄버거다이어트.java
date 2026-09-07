package 부분집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV3_5215_햄버거다이어트 {

    static int N, L;
    static int[] scores;
    static int[] calories;
    static int maxScore;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        int t = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=t ; tc++) {
            sb.append("#").append(tc);
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken()); // 재료의 수
            L = Integer.parseInt(token.nextToken()); // 제한 칼로리

            scores = new int[N];
            calories = new int[N];

            for(int i=0 ; i<N ; i++) {
                token = new StringTokenizer(br.readLine());
                int T = Integer.parseInt(token.nextToken());
                int K = Integer.parseInt(token.nextToken());
                scores[i] = T;
                calories[i] = K;
            }

            dfs(0, 0, 0);

            sb.append(" ").append(maxScore).append("\n");
            maxScore = 0; // 초기화
        }
        System.out.println(sb);
    }

    static void dfs(int idx, int caloriesSum, int scoreSum) {
        if(caloriesSum > L) return;
        if(idx == N) {
            if(caloriesSum <= L) {
                maxScore = Math.max(maxScore, scoreSum);
            }
            return;
        }

        // 해당 재료를 추가
        dfs(idx+1, caloriesSum+calories[idx], scoreSum+scores[idx]);
        // 해당 재료를 추가 X
        dfs(idx+1, caloriesSum, scoreSum);
    }

}
