package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV2_26409_나눗셈게임 {

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case);

            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];

            token = new StringTokenizer(br.readLine());
            for(int i=0 ; i<N ; i++) {
                nums[i] = Integer.parseInt(token.nextToken());
            }

            int sum = 0;

            for(int i=0 ; i<N ; i++) {
                for(int j=0 ; j<N ; j++) {
                    sum += nums[i]%nums[j];
                }
            }
            sb.append(" ").append(sum).append("\n");
        }

        System.out.println(sb);
    }
}