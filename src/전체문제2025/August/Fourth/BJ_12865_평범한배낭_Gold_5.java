package 전체문제2025.August.Fourth;

import java.util.*;
import java.io.*;
public class BJ_12865_평범한배낭_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N+1][2];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][]dp = new int[N+1][K+1];
        int answer = 0;
        for(int i=1;i<N+1;i++){
            int w = arr[i][0];
            int v = arr[i][1];
            for(int j=0;j<K+1;j++){
                dp[i][j] = dp[i-1][j];
                if(arr[i][0]<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-arr[i][0]]+arr[i][1]);
                }
            }
            answer = Math.max(answer,dp[i][K]);
        }
        System.out.println(dp[N][K]);
    }
}
