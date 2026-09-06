package D2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_LV2_26059_과일등급분류 {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken()); // 과일의 수
            int lo = Integer.parseInt(token.nextToken()); // 최소 개수
            int hi = Integer.parseInt(token.nextToken()); // 최대 개수

            token = new StringTokenizer(br.readLine()); // N개의 정수

            int[] nums = new int[N];
            for(int i=0 ; i<N ; i++) {
                nums[i] = Integer.parseInt(token.nextToken());
            }

            Arrays.sort(nums); // 오름차순 정렬
            int result = Integer.MAX_VALUE; // 최솟값

            for(int i=1 ; i<N ; i++) {

                if(nums[i-1]==nums[i]) continue;

                for(int j=i+1 ; j<N ; j++) {
                    if(nums[j-1] == nums[j]) continue;

                    int low = i;
                    int mid = j-i;
                    int high = N-j;

                    if(low >= lo && low <= hi &&
                            mid >= lo && mid <= hi &&
                            mid >= lo && mid <= hi) {
                        int maxCount = Math.max(low, Math.max(mid, high));
                        int minCount = Math.min(low, Math.min(mid, high));

                        result = Math.min(result, maxCount-minCount);
                    }
                }
            }

            if(result != Integer.MAX_VALUE) {
                System.out.println("#" + test_case + " " + result);
            } else {
                System.out.println("#" + test_case + " " + -1);
            }

        }
    }
}