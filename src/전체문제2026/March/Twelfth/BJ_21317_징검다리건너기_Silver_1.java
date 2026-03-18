package 전체문제2026.March.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_21317_징검다리건너기_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr =new int[N-1][2];
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        if(N==1) {
            System.out.println(0);
        }else {
            int[][] dp = new int[N][2];
            int INF = 987654321;

            for(int i=0;i<N;i++){
                dp[i][0] = dp[i][1] = INF;
            }

            dp[0][0] = 0;

            for(int i=1;i<N;i++){
                // 작은 점프
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0] + arr[i-1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][1] + arr[i-1][0]);

                if(i >= 2){
                    // 큰 점프
                    dp[i][0] = Math.min(dp[i][0], dp[i-2][0] + arr[i-2][1]);
                    dp[i][1] = Math.min(dp[i][1], dp[i-2][1] + arr[i-2][1]);
                }

                if(i >= 3){
                    // K 점프 (한 번만)
                    dp[i][1] = Math.min(dp[i][1], dp[i-3][0] + K);
                }
            }
            System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
        }
    }
}
