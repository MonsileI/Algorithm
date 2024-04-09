package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;

import java.util.*;
import java.io.*;
public class BJ_1149_RGB거리_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[][]dp = new int[N][3];
        for(int i=0;i<3;i++)dp[0][i] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+ Integer.parseInt(st.nextToken());
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+ Integer.parseInt(st.nextToken());
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+ Integer.parseInt(st.nextToken());
        }
        System.out.println(Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2])));
    }
}
