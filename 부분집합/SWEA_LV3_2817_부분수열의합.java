package 부분집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV3_2817_부분수열의합 {
    static int N;
    static int K;
    static int count;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1 ; tc<=T ; tc++) {
            sb.append("#").append(tc);
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());

            nums = new int[N];
            token = new StringTokenizer(br.readLine());
            for(int i=0 ; i<N ; i++) {
                nums[i] = Integer.parseInt(token.nextToken());
            }

            count = 0;
            dfs(0, 0);

            sb.append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int idx, int sum) {
        if(sum > K) return;

        if(idx == N) {
            if(sum == K) count++;
            return;
        }

        // 현재 원소를 선택
        dfs(idx+1 , sum+nums[idx]);
        // 현재 원소를 선택 안함
        dfs(idx+1, sum);

    }
}
