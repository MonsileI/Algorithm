package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]dp = new int[N][3];
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+f;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+s;
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+t;
        }
        System.out.println(Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2])));
    }
}
