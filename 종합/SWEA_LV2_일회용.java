package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_LV2_일회용 {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            token = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(token.nextToken()); // 신입사원의 수
            int k_min = Integer.parseInt(token.nextToken()); // 각 분반별 최소 인원
            int k_max = Integer.parseInt(token.nextToken()); // 각 분반별 최대 인원

            int[] scores = new int[N];

            token = new StringTokenizer(br.readLine()); // N명의 어학 성적
            for(int i=0 ; i<N ; i++) {
                scores[i] = Integer.parseInt(token.nextToken());
            }

            Arrays.sort(scores);

            int result = Integer.MAX_VALUE; // 최솟값

            for(int i=1 ; i<N ; i++) {
                if(scores[i-1]==scores[i]) continue;
                for(int j=i+1 ; j<N ; j++) {
                    if(scores[j-1]==scores[j]) continue;

                    int low = i;
                    int mid = j-i;
                    int high = N-j;

                    if(low >= k_min && low <= k_max &&
                            mid >= k_min && mid <= k_max &&
                            high >= k_min && high <= k_max) {
                        int maxCount = Math.max(low, Math.max(mid, high));
                        int minCount = Math.min(low, Math.min(mid, high));

                        result = Math.min(result, maxCount-minCount);
                    }
                }
            }

            if(result == Integer.MAX_VALUE) {
                System.out.println("#" + test_case + " " + -1);
            } else {
                System.out.println("#" + test_case + " " + result);
            }

        }
    }
}
